package com.leetclub.subject.domain.convert;

import com.leetclub.subject.common.convert.BaseConverter;
import com.leetclub.subject.domain.entity.SubjectAnswerBo;
import com.leetclub.subject.domain.entity.SubjectInfoBO;
import com.leetclub.subject.infra.basic.pojo.SubjectRadio;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author sinker
 * @date 2025/7/20 11:24
 */
@Mapper(componentModel = "spring")
public interface SubjectRadioAnswerBOConverter extends BaseConverter<SubjectAnswerBo, SubjectRadio> {
    @Override
    SubjectRadio convert(SubjectAnswerBo source);

    @Override
    SubjectAnswerBo convertBack(SubjectRadio source);

    @Override
    List<SubjectRadio> convert(List<SubjectAnswerBo> source);

    @Override
    List<SubjectAnswerBo> convertBack(List<SubjectRadio> source);
}
