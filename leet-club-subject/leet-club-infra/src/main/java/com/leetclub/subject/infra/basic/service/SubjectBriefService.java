package com.leetclub.subject.infra.basic.service;

import com.leetclub.subject.infra.basic.pojo.SubjectBrief;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 17864
* @description 针对表【subject_brief(简答题)】的数据库操作Service
* @createDate 2025-07-20 07:58:18
*/
public interface SubjectBriefService extends IService<SubjectBrief> {

    SubjectBrief queryByCondition(Long subjectId);
}
