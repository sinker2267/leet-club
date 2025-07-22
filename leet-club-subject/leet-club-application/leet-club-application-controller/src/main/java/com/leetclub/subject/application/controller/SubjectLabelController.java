package com.leetclub.subject.application.controller;

import com.alibaba.fastjson2.JSON;
import com.google.common.base.Preconditions;
import com.leetclub.subject.application.convert.SubjectLabelDTOConverter;
import com.leetclub.subject.application.dto.BatchDeleteSubjectLabelDTO;
import com.leetclub.subject.application.dto.SubjectLabelDTO;
import com.leetclub.subject.common.entity.Result;
import com.leetclub.subject.domain.entity.SubjectLabelBO;
import com.leetclub.subject.domain.service.SubjectLabelDomainService;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @author sinker
 * @date 2025/7/19 15:47
 */
@RestController
@RequestMapping("/subject/label")
@Slf4j
public class SubjectLabelController {
    @Autowired
    private SubjectLabelDomainService subjectLabelDomainService;
    @Autowired
    private SubjectLabelDTOConverter subjectLabelDTOConverter;

    @PostMapping()
    public Result<Boolean> add(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.add.info:{}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(), "题目类别id不能为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(subjectLabelDTO.getLabelName()), "标签名称不能为空");
            SubjectLabelBO subjectLabelBO = subjectLabelDTOConverter.convert(subjectLabelDTO);
            Boolean success = subjectLabelDomainService.add(subjectLabelBO);
            return Result.ok(success);

        } catch (Exception e){
            log.error("SubjectLabelController.add.error:{}", e.getMessage(), e);
            return Result.fail(false);
        }

    }

    @DeleteMapping("{id}")
    public Result<Boolean> delete(@PathVariable("id") Long id) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.delete.info:{}", id);
            }
            Preconditions.checkNotNull(id, "删除id不能为空");
            Boolean success = subjectLabelDomainService.deleteById(id);
            return Result.ok(success);
        } catch (Exception e){
            log.error("SubjectLabelController.delete.error:{}", e.getMessage(), e);
            return Result.fail(false);
        }

    }

    @PostMapping("batch-delete")
    public Result<Boolean> batchDelete(@RequestBody BatchDeleteSubjectLabelDTO batchDeleteSubjectLabel) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.batchDelete.info:{}", batchDeleteSubjectLabel);
            }
            List<Long> ids = batchDeleteSubjectLabel.getIds();
            Preconditions.checkNotNull(ids, "批量删除id列表不能为空");
            Preconditions.checkArgument(!ids.isEmpty(), "批量删除id列表不能为空");
            boolean success = subjectLabelDomainService.batchDeleteByIds(ids);
            return Result.ok(success);
        } catch (Exception e){
            log.error("SubjectLabelController.batchDelete.error:{}", e.getMessage(), e);
            return Result.fail(false);
        }
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.update.info:{}", subjectLabelDTO);
            }
            Preconditions.checkNotNull(subjectLabelDTO.getId(), "待修改id不能为空");
            SubjectLabelBO subjectLabelBO = subjectLabelDTOConverter.convert(subjectLabelDTO);
            boolean success = subjectLabelDomainService.updateById(subjectLabelBO);
            return Result.ok(success);
        } catch (Exception e){
            log.error("SubjectLabelController.update error:{}", e.getMessage(), e);
            return Result.fail(false);
        }
    }

    @GetMapping("{categoryId}")
    public Result<List<SubjectLabelDTO>> quarySubjectLabelByCategoryId(@PathVariable("categoryId") String categoryId) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.quarySubjectLabelByCategoryId.info:{}", categoryId);
            }
            Preconditions.checkNotNull(categoryId, "分类id不能为空");
            List<SubjectLabelBO> subjectLabelBOList = subjectLabelDomainService.quarySubjectLabelByCategoryId(categoryId);
            List<SubjectLabelDTO> subjectLabelDTOList = subjectLabelDTOConverter.convertBack(subjectLabelBOList);
            return Result.ok(subjectLabelDTOList);
        } catch (Exception e){
            log.error("SubjectLabelController.quarySubjectLabelByCategoryId.error:{}", e.getMessage(), e);
            return Result.fail(Collections.emptyList());
        }
    }

}
