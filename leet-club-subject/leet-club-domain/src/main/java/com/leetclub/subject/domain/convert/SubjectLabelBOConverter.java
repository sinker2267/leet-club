package com.leetclub.subject.domain.convert;

import com.leetclub.subject.common.convert.BaseConverter;
import com.leetclub.subject.domain.entity.SubjectLabelBO;
import com.leetclub.subject.infra.basic.pojo.SubjectLabel;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author sinker
 * @date 2025/7/19 15:50
 */
@Mapper(componentModel = "spring")
public interface SubjectLabelBOConverter extends BaseConverter<SubjectLabelBO, SubjectLabel> {
    @Override
    SubjectLabel convert(SubjectLabelBO source);

    @Override
    SubjectLabelBO convertBack(SubjectLabel source);

    @Override
    List<SubjectLabel> convert(List<SubjectLabelBO> source);

    @Override
    List<SubjectLabelBO> convertBack(List<SubjectLabel> source);
}
