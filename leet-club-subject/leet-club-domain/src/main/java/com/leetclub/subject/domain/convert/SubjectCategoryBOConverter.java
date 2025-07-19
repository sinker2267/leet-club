package com.leetclub.subject.domain.convert;

import com.leetclub.subject.common.convert.BaseConverter;
import com.leetclub.subject.domain.entity.SubjectCategoryBO;
import com.leetclub.subject.infra.basic.pojo.SubjectCategory;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author sinker
 * @date 2025/7/18 11:12
 */
@Mapper(componentModel = "spring")
public interface SubjectCategoryBOConverter extends BaseConverter<SubjectCategoryBO, SubjectCategory> {
//    SubjectCategoryBOConverter INSTANCE = Mappers.getMapper(SubjectCategoryBOConverter.class);

    @Override
    SubjectCategory convert(SubjectCategoryBO source);

    @Override
    SubjectCategoryBO convertBack(SubjectCategory source);

    @Override
    List<SubjectCategory> convert(List<SubjectCategoryBO> source);

    @Override
    List<SubjectCategoryBO> convertBack(List<SubjectCategory> source);
}
