package com.leetclub.subject.domain.convert;

import com.leetclub.subject.common.convert.BaseConverter;
import com.leetclub.subject.domain.entity.SubjectInfoBO;
import com.leetclub.subject.domain.entity.SubjectOptionBO;
import com.leetclub.subject.infra.basic.pojo.SubjectInfo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author sinker
 * @date 2025/7/20 10:15
 */
@Mapper(componentModel = "spring")
public interface SubjectInfoBOConverter extends BaseConverter<SubjectInfoBO, SubjectInfo> {
    @Override
    SubjectInfo convert(SubjectInfoBO source);

    @Override
    SubjectInfoBO convertBack(SubjectInfo source);

    @Override
    List<SubjectInfo> convert(List<SubjectInfoBO> source);

    @Override
    List<SubjectInfoBO> convertBack(List<SubjectInfo> source);

    SubjectInfoBO convertInfoAndOption(SubjectInfo subjectInfo, SubjectOptionBO subjectOptionBO);
}
