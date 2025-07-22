package com.leetclub.subject.infra.basic.service;

import com.leetclub.subject.infra.basic.pojo.SubjectMapping;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 17864
* @description 针对表【subject_mapping(题目分类关系表)】的数据库操作Service
* @createDate 2025-07-20 08:20:00
*/
public interface SubjectMappingService extends IService<SubjectMapping> {

    List<Long> getCategoryListBySubjectId(Long subjectId);

    List<Long> getLabelListBySubjectId(Long subjectId);
}
