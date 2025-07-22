package com.leetclub.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leetclub.subject.infra.basic.pojo.SubjectMapping;
import com.leetclub.subject.infra.basic.service.SubjectMappingService;
import com.leetclub.subject.infra.basic.mapper.SubjectMappingMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author 17864
* @description 针对表【subject_mapping(题目分类关系表)】的数据库操作Service实现
* @createDate 2025-07-20 08:20:00
*/
@Service
public class SubjectMappingServiceImpl extends ServiceImpl<SubjectMappingMapper, SubjectMapping>
    implements SubjectMappingService{

    private final SubjectMappingMapper subjectMappingMapper;

    public SubjectMappingServiceImpl(SubjectMappingMapper subjectMappingMapper) {
        this.subjectMappingMapper = subjectMappingMapper;
    }

    @Override
    public List<Long> getCategoryListBySubjectId(Long subjectId) {
        QueryWrapper<SubjectMapping> subjectMappingQueryWrapper = new QueryWrapper<>();
        subjectMappingQueryWrapper.select("DISTINCT category_id").eq("subject_id", subjectId);
        return subjectMappingMapper.selectObjs(subjectMappingQueryWrapper).stream().map(o -> (Long)o).collect(Collectors.toList());
    }

    @Override
    public List<Long> getLabelListBySubjectId(Long subjectId) {
        QueryWrapper<SubjectMapping> subjectMappingQueryWrapper = new QueryWrapper<>();
        subjectMappingQueryWrapper.select("DISTINCT label_id").eq("subject_id", subjectId);
        return subjectMappingMapper.selectObjs(subjectMappingQueryWrapper).stream().map(o -> (Long)o).collect(Collectors.toList());
    }
}




