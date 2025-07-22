package com.leetclub.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leetclub.subject.infra.basic.pojo.SubjectInfo;
import com.leetclub.subject.infra.basic.service.SubjectInfoService;
import com.leetclub.subject.infra.basic.mapper.SubjectInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 17864
* @description 针对表【subject_info(题目信息表)】的数据库操作Service实现
* @createDate 2025-07-20 07:57:13
*/
@Service
public class SubjectInfoServiceImpl extends ServiceImpl<SubjectInfoMapper, SubjectInfo>
    implements SubjectInfoService{

    @Autowired
    private SubjectInfoMapper subjectInfoMapper;

    @Override
    public Long saveReturnPojo(SubjectInfo subjectInfo) {
        subjectInfoMapper.insert(subjectInfo);
        return subjectInfo.getId();
    }

    @Override
    public int countByCondition(SubjectInfo subjectInfo, Long categoryId, Long labelId) {
        return subjectInfoMapper.countByCondition(subjectInfo, categoryId, labelId);

    }

    @Override
    public List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Long categoryId, Long labelId, int start, Integer pageSize) {
        return subjectInfoMapper.queryPage(subjectInfo, categoryId, labelId, start, pageSize);
    }
}




