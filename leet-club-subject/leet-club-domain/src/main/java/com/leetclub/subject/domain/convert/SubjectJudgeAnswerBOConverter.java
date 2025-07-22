package com.leetclub.subject.domain.convert;

import com.leetclub.subject.common.convert.BaseConverter;
import com.leetclub.subject.domain.entity.SubjectAnswerBo;
import com.leetclub.subject.infra.basic.pojo.SubjectJudge;

import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author sinker
 * @date 2025/7/20 11:24
 */
@Mapper(componentModel = "spring")
public interface SubjectJudgeAnswerBOConverter extends BaseConverter<SubjectAnswerBo, SubjectJudge> {
    @Override
    SubjectJudge convert(SubjectAnswerBo source);

    @Override
    SubjectAnswerBo convertBack(SubjectJudge source);

    @Override
    List<SubjectJudge> convert(List<SubjectAnswerBo> source);

    @Override
    List<SubjectAnswerBo> convertBack(List<SubjectJudge> source);
}
