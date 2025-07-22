package com.leetclub.subject.infra.basic.service;

import com.leetclub.subject.infra.basic.pojo.SubjectMultiple;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 17864
* @description 针对表【subject_multiple(多选题信息表)】的数据库操作Service
* @createDate 2025-07-20 07:59:09
*/
public interface SubjectMultipleService extends IService<SubjectMultiple> {

    List<SubjectMultiple> queryByCondition(Long subjectId);
}
