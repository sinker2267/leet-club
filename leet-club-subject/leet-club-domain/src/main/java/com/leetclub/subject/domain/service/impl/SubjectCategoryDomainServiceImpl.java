package com.leetclub.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.leetclub.subject.common.enums.IsDeletedFlagEnum;
import com.leetclub.subject.domain.convert.SubjectCategoryBOConverter;
import com.leetclub.subject.domain.entity.SubjectCategoryBO;
import com.leetclub.subject.domain.service.SubjectCategoryDomainService;
import com.leetclub.subject.infra.basic.pojo.SubjectCategory;
import com.leetclub.subject.infra.basic.service.SubjectCategoryService;
import com.leetclub.subject.infra.basic.service.impl.SubjectCategoryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sinker
 * @date 2025/7/18 11:06
 */
@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Autowired
    private SubjectCategoryService subjectCategoryService;

    @Autowired
    private SubjectCategoryBOConverter subjectCategoryBOConverter;
    @Autowired
    private SubjectCategoryServiceImpl subjectCategoryServiceImpl;

    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()) {
            log.info("add subject category Bo: {}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = subjectCategoryBOConverter.convert(subjectCategoryBO);
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = subjectCategoryBOConverter.convert(subjectCategoryBO);
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        return subjectCategoryBOConverter.convertBack(subjectCategoryList);
    }

    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = subjectCategoryBOConverter.convert(subjectCategoryBO);
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }

    @Override
    public boolean deleteLogic(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = subjectCategoryBOConverter.convert(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        return subjectCategoryServiceImpl.update(subjectCategory) > 0;
    }
}
