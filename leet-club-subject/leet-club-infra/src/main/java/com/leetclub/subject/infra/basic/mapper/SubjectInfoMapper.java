package com.leetclub.subject.infra.basic.mapper;

import com.leetclub.subject.infra.basic.pojo.SubjectInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 17864
* @description 针对表【subject_info(题目信息表)】的数据库操作Mapper
* @createDate 2025-07-20 07:57:13
* @Entity com.leetclub.subject.infra.basic.pojo.SubjectInfo
*/
public interface SubjectInfoMapper extends BaseMapper<SubjectInfo> {

    int countByCondition(@Param("subjectInfo") SubjectInfo subjectInfo,
                         @Param("categoryId") Long categoryId,
                         @Param("labelId") Long labelId);

    List<SubjectInfo> queryPage(@Param("subjectInfo") SubjectInfo subjectInfo,
                                @Param("categoryId") Long categoryId,
                                @Param("labelId") Long labelId,
                                @Param("start") int start,
                                @Param("pageSize") Integer pageSize);
}




