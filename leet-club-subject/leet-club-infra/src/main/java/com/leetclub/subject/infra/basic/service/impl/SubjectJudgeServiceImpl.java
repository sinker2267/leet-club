package com.leetclub.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leetclub.subject.infra.basic.pojo.SubjectBrief;
import com.leetclub.subject.infra.basic.pojo.SubjectJudge;
import com.leetclub.subject.infra.basic.service.SubjectJudgeService;
import com.leetclub.subject.infra.basic.mapper.SubjectJudgeMapper;
import org.springframework.stereotype.Service;

/**
* @author 17864
* @description 针对表【subject_judge(判断题)】的数据库操作Service实现
* @createDate 2025-07-20 07:58:38
*/
@Service
public class SubjectJudgeServiceImpl extends ServiceImpl<SubjectJudgeMapper, SubjectJudge>
    implements SubjectJudgeService{

    private final SubjectJudgeMapper subjectJudgeMapper;

    public SubjectJudgeServiceImpl(SubjectJudgeMapper subjectJudgeMapper) {
        this.subjectJudgeMapper = subjectJudgeMapper;
    }

    @Override
    public SubjectJudge queryByCondition(Long subjectId) {
        LambdaQueryWrapper<SubjectJudge> subjectJudgeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (subjectId != null) {
            subjectJudgeLambdaQueryWrapper.eq(SubjectJudge::getSubjectId, subjectId);
        }
        return subjectJudgeMapper.selectOne(subjectJudgeLambdaQueryWrapper);
    }
}




