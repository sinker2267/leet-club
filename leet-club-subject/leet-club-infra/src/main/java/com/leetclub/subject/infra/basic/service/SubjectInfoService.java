package com.leetclub.subject.infra.basic.service;

import com.leetclub.subject.infra.basic.pojo.SubjectInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 17864
* @description 针对表【subject_info(题目信息表)】的数据库操作Service
* @createDate 2025-07-20 07:57:13
*/
public interface SubjectInfoService extends IService<SubjectInfo> {

    Long saveReturnPojo(SubjectInfo subjectInfo);

    int countByCondition(SubjectInfo subjectInfo, Long categoryId, Long labelId);

    List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Long categoryId, Long labelId, int start, Integer pageSize);
}
