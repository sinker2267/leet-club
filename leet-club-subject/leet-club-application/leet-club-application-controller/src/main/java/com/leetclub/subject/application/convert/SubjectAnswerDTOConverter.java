package com.leetclub.subject.application.convert;

import com.leetclub.subject.application.dto.SubjectAnswerDTO;
import com.leetclub.subject.common.convert.BaseConverter;
import com.leetclub.subject.domain.entity.SubjectCategoryBO;

import java.util.List;

/**
 * @author sinker
 * @date 2025/7/21 11:04
 */
public interface SubjectAnswerDTOConverter extends BaseConverter<SubjectAnswerDTO, SubjectCategoryBO> {
    @Override
    SubjectCategoryBO convert(SubjectAnswerDTO source);

    @Override
    SubjectAnswerDTO convertBack(SubjectCategoryBO source);

    @Override
    List<SubjectCategoryBO> convert(List<SubjectAnswerDTO> source);

    @Override
    List<SubjectAnswerDTO> convertBack(List<SubjectCategoryBO> source);
}
