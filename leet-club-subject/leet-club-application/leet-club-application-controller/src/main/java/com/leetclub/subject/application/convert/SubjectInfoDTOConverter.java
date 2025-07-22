package com.leetclub.subject.application.convert;

import com.leetclub.subject.application.dto.SubjectInfoDTO;
import com.leetclub.subject.common.convert.BaseConverter;
import com.leetclub.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


/**
 * @author sinker
 * @date 2025/7/20 9:03
 */
@Mapper(componentModel = "spring")
public interface SubjectInfoDTOConverter extends BaseConverter<SubjectInfoDTO, SubjectInfoBO> {
//    @Mappings({
//            @Mapping(source = "pageNo", target = "pageNo"),
//            @Mapping(source = "pageSize", target = "pageSize"),
//    })
    @Override
    SubjectInfoBO convert(SubjectInfoDTO source);
//    @Mappings({
//            @Mapping(source = "pageNo", target = "pageNo"),
//            @Mapping(source = "pageSize", target = "pageSize"),
//    })
    @Override
    SubjectInfoDTO convertBack(SubjectInfoBO source);

    @Override
    List<SubjectInfoBO> convert(List<SubjectInfoDTO> source);

    @Override
    List<SubjectInfoDTO> convertBack(List<SubjectInfoBO> source);
}
