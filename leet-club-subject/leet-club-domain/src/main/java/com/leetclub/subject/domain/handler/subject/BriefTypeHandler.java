package com.leetclub.subject.domain.handler.subject;

import com.leetclub.subject.common.enums.SubjectInfoTypeEnum;

import com.leetclub.subject.domain.entity.SubjectInfoBO;
import com.leetclub.subject.domain.entity.SubjectOptionBO;
import com.leetclub.subject.infra.basic.pojo.SubjectBrief;

import com.leetclub.subject.infra.basic.service.SubjectBriefService;
import com.leetclub.subject.infra.basic.service.SubjectMappingService;
import com.leetclub.subject.infra.basic.service.impl.SubjectCategoryServiceImpl;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author sinker
 * @date 2025/7/20 10:27
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler{


    private final SubjectBriefService subjectBriefService;
    private final SubjectMappingService subjectMappingService;
    private final SubjectCategoryServiceImpl subjectCategoryService;

    public BriefTypeHandler(SubjectBriefService subjectBriefService, SubjectMappingService subjectMappingService, SubjectCategoryServiceImpl subjectCategoryService) {
        this.subjectBriefService = subjectBriefService;
        this.subjectMappingService = subjectMappingService;
        this.subjectCategoryService = subjectCategoryService;
    }

    @Override
    public SubjectInfoTypeEnum getSubjectHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }


    @Override
    public Boolean add(SubjectInfoBO subjectInfoBO) {
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(subjectInfoBO.getId());
        subjectBrief.setSubjectAnswer(subjectInfoBO.getSubjectAnswer());
        return subjectBriefService.save(subjectBrief);
    }

    @Override
    public SubjectOptionBO getOptionByCondtion(Long subjectId) {
        SubjectBrief subjectBrief = subjectBriefService.queryByCondition(subjectId);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setSubjectAnswer(subjectBrief.getSubjectAnswer());
        return subjectOptionBO;
    }


}
