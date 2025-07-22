package com.leetclub.subject.domain.convert;

import com.leetclub.subject.common.convert.BaseConverter;
import com.leetclub.subject.domain.entity.SubjectAnswerBo;
import com.leetclub.subject.domain.entity.SubjectInfoBO;
import com.leetclub.subject.infra.basic.pojo.SubjectMultiple;
import com.leetclub.subject.infra.basic.pojo.SubjectRadio;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author sinker
 * @date 2025/7/20 11:24
 */
@Mapper(componentModel = "spring")
public interface SubjectMultipleAnswerBOConverter extends BaseConverter<SubjectAnswerBo, SubjectMultiple> {
    @Override
    SubjectMultiple convert(SubjectAnswerBo source);

    @Override
    SubjectAnswerBo convertBack(SubjectMultiple source);

    @Override
    List<SubjectMultiple> convert(List<SubjectAnswerBo> source);

    @Override
    List<SubjectAnswerBo> convertBack(List<SubjectMultiple> source);
}
