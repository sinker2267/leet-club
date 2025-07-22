package com.leetclub.subject.application.controller;

import com.google.common.base.Preconditions;
import com.leetclub.subject.application.convert.SubjectInfoDTOConverter;
import com.leetclub.subject.application.dto.SubjectInfoDTO;
import com.leetclub.subject.common.entity.PageResult;
import com.leetclub.subject.common.entity.Result;
import com.leetclub.subject.domain.entity.SubjectInfoBO;
import com.leetclub.subject.domain.service.SubjectInfoDomainService;

import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


/**
 * @author sinker
 * @date 2025/7/17 21:15
 */
@RestController
@RequestMapping("/subject")
@Slf4j
public class SubjectController {

    @Autowired
    private SubjectInfoDomainService subjectDomainService;

    @Autowired
    private SubjectInfoDTOConverter subjectInfoDTOConverter;
    @Autowired
    private SubjectInfoDomainService subjectInfoDomainService;

    public SubjectController(SubjectInfoDTOConverter subjectInfoDTOConverter) {
        this.subjectInfoDTOConverter = subjectInfoDTOConverter;
    }

    @PostMapping
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isDebugEnabled()) {
                log.debug("add subject info: {}", subjectInfoDTO);
            }
            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectName()), "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(), "题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds()), "分类id不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds()), "标签id不能为空");
            SubjectInfoBO subjectInfoBO = subjectInfoDTOConverter.convert(subjectInfoDTO);
            Boolean success = subjectDomainService.add(subjectInfoBO);
            return Result.ok(success);
        } catch (Exception e) {
            log.error("SubjectController.add.error:{}", e.getMessage(), e);
            return Result.fail(false);
        }
    }

    @PostMapping("subjectList")
    public Result<PageResult<SubjectInfoDTO>> getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isDebugEnabled()) {
                log.debug("quarySubjectList subject info: {}", subjectInfoDTO);
            }
            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(), "分类id不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(), "标签id不能为空");
            SubjectInfoBO subjectInfoBO = subjectInfoDTOConverter.convert(subjectInfoDTO);
            PageResult<SubjectInfoBO> pageResult = subjectDomainService.getSubjectPage(subjectInfoBO);
            PageResult<SubjectInfoDTO> dtoPageResult = new PageResult<>();
            dtoPageResult.setPageNo(pageResult.getPageNo());
            dtoPageResult.setPageSize(pageResult.getPageSize());
            dtoPageResult.setTotalCount(pageResult.getTotalCount());
            dtoPageResult.setTotalPages(pageResult.getTotalCount());
            dtoPageResult.setStart(pageResult.getStart());
            dtoPageResult.setEnd(pageResult.getEnd());
            dtoPageResult.setRecord(subjectInfoDTOConverter.convertBack(pageResult.getResults()));
            return Result.ok(dtoPageResult);
        } catch (Exception e) {
            log.error("SubjectController.add.error:{}", e.getMessage(), e);
            return Result.fail(null);
        }
    }

    @GetMapping
    public Result<SubjectInfoDTO> getSubject(@RequestParam("id") Long subjectId) {
        try {
            if (log.isInfoEnabled()){
                log.info("get subject info: {}", subjectId);
            }
            Preconditions.checkNotNull(subjectId, "题目id不能为空");
            SubjectInfoBO subjectInfoBO = subjectInfoDomainService.query(subjectId);
            SubjectInfoDTO subjectInfoDTO = subjectInfoDTOConverter.convertBack(subjectInfoBO);
            return Result.ok(subjectInfoDTO);
        } catch (Exception e){
            log.error("SubjectController.add.error:{}", e.getMessage(), e);
            return Result.fail(null);
        }
    }


}
