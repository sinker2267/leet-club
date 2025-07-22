package com.leetclub.subject.domain.handler.subject;

import com.leetclub.subject.common.enums.SubjectInfoTypeEnum;
import com.leetclub.subject.domain.entity.SubjectAnswerBo;
import com.leetclub.subject.domain.entity.SubjectInfoBO;
import com.leetclub.subject.domain.entity.SubjectOptionBO;
import com.leetclub.subject.infra.basic.pojo.SubjectInfo;

/**
 * @author sinker
 * @date 2025/7/20 10:18
 */
public interface SubjectTypeHandler {

    /**
     * 枚举身份的识别
     * @return
     */
    SubjectInfoTypeEnum getSubjectHandlerType();

    /**
     * 添加题目
     * @param subjectInfoBO
     */
    Boolean add(SubjectInfoBO subjectInfoBO);


    SubjectOptionBO getOptionByCondtion(Long subjectId);
}
