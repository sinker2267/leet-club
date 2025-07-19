package com.leetclub.subject.application.convert;

import com.leetclub.subject.application.dto.SubjectLabelDTO;
import com.leetclub.subject.common.convert.BaseConverter;
import com.leetclub.subject.domain.entity.SubjectLabelBO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author sinker
 * @date 2025/7/19 16:05
 */
@Mapper(componentModel = "spring")
public interface SubjectLabelDTOConverter extends BaseConverter<SubjectLabelDTO, SubjectLabelBO> {
    @Override
    SubjectLabelBO convert(SubjectLabelDTO source);

    @Override
    SubjectLabelDTO convertBack(SubjectLabelBO source);

    @Override
    List<SubjectLabelBO> convert(List<SubjectLabelDTO> source);

    @Override
    List<SubjectLabelDTO> convertBack(List<SubjectLabelBO> source);
}
