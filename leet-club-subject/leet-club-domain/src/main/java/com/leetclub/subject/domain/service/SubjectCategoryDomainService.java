package com.leetclub.subject.domain.service;

import com.leetclub.subject.domain.entity.SubjectCategoryBO;
import com.leetclub.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

/**
 * @author sinker
 * @date 2025/7/18 11:05
 */
public interface SubjectCategoryDomainService {
    void add(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    Boolean update(SubjectCategoryBO subjectCategoryBO);

    boolean deleteLogic(SubjectCategoryBO subjectCategoryBO);
}
