package com.leetclub.subject.domain.service;

import com.leetclub.subject.domain.entity.SubjectLabelBO;

import java.util.List;

/**
 * @author sinker
 * @date 2025/7/19 15:54
 */
public interface SubjectLabelDomainService {
    Boolean add(SubjectLabelBO subjectLabelBO);

    Boolean deleteById(Long id);

    boolean batchDeleteByIds(List<Long> ids);

    boolean updateById(SubjectLabelBO subjectLabelBO);


    List<SubjectLabelBO> quarySubjectLabelByCategoryId(String categoryId);
}
