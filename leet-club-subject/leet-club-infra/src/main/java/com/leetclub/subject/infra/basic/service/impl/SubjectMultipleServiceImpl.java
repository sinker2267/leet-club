package com.leetclub.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leetclub.subject.infra.basic.pojo.SubjectMultiple;
import com.leetclub.subject.infra.basic.service.SubjectMultipleService;
import com.leetclub.subject.infra.basic.mapper.SubjectMultipleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 17864
* @description 针对表【subject_multiple(多选题信息表)】的数据库操作Service实现
* @createDate 2025-07-20 07:59:09
*/
@Service
public class SubjectMultipleServiceImpl extends ServiceImpl<SubjectMultipleMapper, SubjectMultiple>
    implements SubjectMultipleService{

    private final SubjectMultipleMapper subjectMultipleMapper;

    public SubjectMultipleServiceImpl(SubjectMultipleMapper subjectMultipleMapper) {
        this.subjectMultipleMapper = subjectMultipleMapper;
    }

    @Override
    public List<SubjectMultiple> queryByCondition(Long subjectId) {
        LambdaQueryWrapper<SubjectMultiple> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SubjectMultiple::getSubjectId, subjectId);
        return subjectMultipleMapper.selectList(queryWrapper);
    }
}




