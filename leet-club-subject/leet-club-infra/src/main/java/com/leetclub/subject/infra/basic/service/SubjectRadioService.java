package com.leetclub.subject.infra.basic.service;

import com.leetclub.subject.infra.basic.pojo.SubjectRadio;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 17864
* @description 针对表【subject_radio(单选题信息表)】的数据库操作Service
* @createDate 2025-07-20 07:59:24
*/
public interface SubjectRadioService extends IService<SubjectRadio> {

    List<SubjectRadio> quaryByCondition(Long subjectId);
}
