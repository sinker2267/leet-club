package com.leetclub.subject.infra.basic.service;

import com.leetclub.subject.infra.basic.pojo.SubjectJudge;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 17864
* @description 针对表【subject_judge(判断题)】的数据库操作Service
* @createDate 2025-07-20 07:58:38
*/
public interface SubjectJudgeService extends IService<SubjectJudge> {

    SubjectJudge queryByCondition(Long subjectId);
}
