package com.leetclub.subject.domain.service;

import com.leetclub.subject.common.entity.PageResult;
import com.leetclub.subject.domain.entity.SubjectInfoBO;

/**
 * @author sinker
 * @date 2025/7/20 9:39
 */
public interface SubjectInfoDomainService {

    /**
     * 新增题目
     * @param subjectInfoBO
     * @return
     */
    Boolean add(SubjectInfoBO subjectInfoBO);

    /**
     * 分页查询题目列表
     * @param subjectInfoBO
     * @return
     */
    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    SubjectInfoBO query(Long subjectId);
}
