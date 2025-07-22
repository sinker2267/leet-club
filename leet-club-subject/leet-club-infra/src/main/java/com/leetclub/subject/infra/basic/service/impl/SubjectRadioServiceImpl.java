package com.leetclub.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leetclub.subject.infra.basic.pojo.SubjectRadio;
import com.leetclub.subject.infra.basic.service.SubjectRadioService;
import com.leetclub.subject.infra.basic.mapper.SubjectRadioMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 17864
* @description 针对表【subject_radio(单选题信息表)】的数据库操作Service实现
* @createDate 2025-07-20 07:59:24
*/
@Service
public class SubjectRadioServiceImpl extends ServiceImpl<SubjectRadioMapper, SubjectRadio>
    implements SubjectRadioService{

    private final SubjectRadioMapper subjectRadioMapper;

    public SubjectRadioServiceImpl(SubjectRadioMapper subjectRadioMapper) {
        this.subjectRadioMapper = subjectRadioMapper;
    }

    @Override
    public List<SubjectRadio> quaryByCondition(Long subjectId) {
        LambdaQueryWrapper<SubjectRadio> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SubjectRadio::getSubjectId, subjectId);
        return subjectRadioMapper.selectList(wrapper);
    }
}




