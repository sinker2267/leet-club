package com.leetclub.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leetclub.subject.infra.basic.pojo.SubjectBrief;
import com.leetclub.subject.infra.basic.service.SubjectBriefService;
import com.leetclub.subject.infra.basic.mapper.SubjectBriefMapper;
import org.springframework.stereotype.Service;

/**
* @author 17864
* @description 针对表【subject_brief(简答题)】的数据库操作Service实现
* @createDate 2025-07-20 07:58:17
*/
@Service
public class SubjectBriefServiceImpl extends ServiceImpl<SubjectBriefMapper, SubjectBrief>
    implements SubjectBriefService{

    private final SubjectBriefMapper subjectBriefMapper;

    public SubjectBriefServiceImpl(SubjectBriefMapper subjectBriefMapper) {
        this.subjectBriefMapper = subjectBriefMapper;
    }

    @Override
    public SubjectBrief queryByCondition(Long subjectId) {
        LambdaQueryWrapper<SubjectBrief> subjectBriefLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (subjectId != null) {
            subjectBriefLambdaQueryWrapper.eq(SubjectBrief::getSubjectId, subjectId);
        }
        return subjectBriefMapper.selectOne(subjectBriefLambdaQueryWrapper);
    }
}




