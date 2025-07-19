package com.leetclub.subject.application.controller;

import ch.qos.logback.core.util.StringUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.leetclub.subject.application.dto.SubjectCategoryDTO;
import com.leetclub.subject.application.convert.SubjectCategoryDTOConverter;
import com.leetclub.subject.common.entity.Result;
import com.leetclub.subject.domain.convert.SubjectCategoryBOConverter;
import com.leetclub.subject.domain.entity.SubjectCategoryBO;
import com.leetclub.subject.domain.service.SubjectCategoryDomainService;
import com.leetclub.subject.infra.basic.entity.SubjectCategory;
import io.micrometer.common.util.StringUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author sinker
 * @date 2025/7/18 11:42
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {

    @Autowired
    private SubjectCategoryDomainService subjectCategoryDomainService;
    @Autowired
    private SubjectCategoryDTOConverter subjectCategoryDTOConverter;

    @PostMapping("add")
    public Result<String> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("add subject category: {}", subjectCategoryDTO);
            }
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(), "分类类型不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "分类父级id不能为空");
            Preconditions.checkArgument(!StringUtils.isEmpty(subjectCategoryDTO.getCategoryName()), "分类名称不能为空");
            SubjectCategoryBO subjectCategoryBO = subjectCategoryDTOConverter.convert(subjectCategoryDTO);
            subjectCategoryDomainService.add(subjectCategoryBO);
            return Result.ok("true");
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("queryPrimaryCategory")
    public Result<List<SubjectCategoryDTO>> queryPrimaryCategory() {
        try {
            SubjectCategoryDTO subjectCategoryDTO = new SubjectCategoryDTO();
            SubjectCategoryBO subjectCategoryBO = subjectCategoryDTOConverter.convert(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList =  subjectCategoryDomainService.queryCategory(subjectCategoryBO);
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.queryPrimaryCategory.info{}", JSON.toJSONString(subjectCategoryBOList));
            }
            List<SubjectCategoryDTO> subjectCategoryDTOList = subjectCategoryDTOConverter.convertBack(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOList);
        } catch (Exception e){
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}", e.getMessage(), e);
            return Result.fail(Collections.emptyList());
        }
    }

    @PostMapping("queryCategoryByPrimary")
    public Result<List<SubjectCategoryDTO>> queryCategoryByPrimary(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            SubjectCategoryBO subjectCategoryBO = subjectCategoryDTOConverter.convert(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList =  subjectCategoryDomainService.queryCategory(subjectCategoryBO);
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.queryPrimaryCategory.info{}", JSON.toJSONString(subjectCategoryBOList));
            }
            List<SubjectCategoryDTO> subjectCategoryDTOList = subjectCategoryDTOConverter.convertBack(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOList);
        } catch (Exception e){
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}", e.getMessage(), e);
            return Result.fail(Collections.emptyList());
        }
    }

    /**
     * 更新分类
     * @param subjectCategoryDTO
     * @return
     */
    @PostMapping("update")
    public Result<Boolean> update(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            SubjectCategoryBO subjectCategoryBO = subjectCategoryDTOConverter.convert(subjectCategoryDTO);
            Preconditions.checkNotNull(subjectCategoryDTO.getId(), "被修改类型id不能为空");
            if (log.isInfoEnabled()) {
                log.info("update subject category: {}", subjectCategoryDTO);
            }
            Boolean updateBoolean = subjectCategoryDomainService.update(subjectCategoryBO);
            return Result.ok(updateBoolean);
        } catch (Exception e){
            log.error("SubjectCategoryController.update error:{}", e.getMessage(), e);
            return Result.fail(false);
        }
        
    }

    /**
     * 删除分类 逻辑删除
     * @param subjectCategoryDTO
     * @return
     */
    @PostMapping("delete")
    public Result<Boolean> delete(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            Preconditions.checkNotNull(subjectCategoryDTO.getId(), "待删除id不能为空");
            if (log.isInfoEnabled()) {
                log.info("delete subject category: {}", subjectCategoryDTO);
            }
            SubjectCategoryBO subjectCategoryBO = subjectCategoryDTOConverter.convert(subjectCategoryDTO);
            boolean status = subjectCategoryDomainService.deleteLogic(subjectCategoryBO);
            return Result.ok(status);
        } catch (Exception e){
            log.error("SubjectCategoryController.delete error:{}", e.getMessage(), e);
            return Result.fail(false);
        }

    }



}
