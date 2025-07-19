package com.leetclub.subject.application.convert;

import com.leetclub.subject.application.dto.SubjectCategoryDTO;
import com.leetclub.subject.common.convert.BaseConverter;
import com.leetclub.subject.domain.entity.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author sinker
 * @date 2025/7/18 11:12
 */
@Mapper(componentModel = "spring")
public interface SubjectCategoryDTOConverter extends BaseConverter<SubjectCategoryDTO, SubjectCategoryBO> {
//    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);

    @Override
    SubjectCategoryBO convert(SubjectCategoryDTO source);

    @Override
    SubjectCategoryDTO convertBack(SubjectCategoryBO source);

    @Override
    List<SubjectCategoryBO> convert(List<SubjectCategoryDTO> source);

    @Override
    List<SubjectCategoryDTO> convertBack(List<SubjectCategoryBO> source);
}
