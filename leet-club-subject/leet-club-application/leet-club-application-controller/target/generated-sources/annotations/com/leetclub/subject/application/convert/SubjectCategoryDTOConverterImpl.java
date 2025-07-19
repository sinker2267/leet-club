package com.leetclub.subject.application.convert;

import com.leetclub.subject.application.dto.SubjectCategoryDTO;
import com.leetclub.subject.domain.entity.SubjectCategoryBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-19T21:46:08+0800",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.14 (Oracle Corporation)"
)
@Component
public class SubjectCategoryDTOConverterImpl implements SubjectCategoryDTOConverter {

    @Override
    public SubjectCategoryBO convert(SubjectCategoryDTO source) {
        if ( source == null ) {
            return null;
        }

        SubjectCategoryBO subjectCategoryBO = new SubjectCategoryBO();

        subjectCategoryBO.setId( source.getId() );
        subjectCategoryBO.setCategoryName( source.getCategoryName() );
        subjectCategoryBO.setCategoryType( source.getCategoryType() );
        subjectCategoryBO.setImageUrl( source.getImageUrl() );
        subjectCategoryBO.setParentId( source.getParentId() );

        return subjectCategoryBO;
    }

    @Override
    public SubjectCategoryDTO convertBack(SubjectCategoryBO source) {
        if ( source == null ) {
            return null;
        }

        SubjectCategoryDTO subjectCategoryDTO = new SubjectCategoryDTO();

        subjectCategoryDTO.setId( source.getId() );
        subjectCategoryDTO.setCategoryName( source.getCategoryName() );
        subjectCategoryDTO.setCategoryType( source.getCategoryType() );
        subjectCategoryDTO.setImageUrl( source.getImageUrl() );
        subjectCategoryDTO.setParentId( source.getParentId() );

        return subjectCategoryDTO;
    }

    @Override
    public List<SubjectCategoryBO> convert(List<SubjectCategoryDTO> source) {
        if ( source == null ) {
            return null;
        }

        List<SubjectCategoryBO> list = new ArrayList<SubjectCategoryBO>( source.size() );
        for ( SubjectCategoryDTO subjectCategoryDTO : source ) {
            list.add( convert( subjectCategoryDTO ) );
        }

        return list;
    }

    @Override
    public List<SubjectCategoryDTO> convertBack(List<SubjectCategoryBO> source) {
        if ( source == null ) {
            return null;
        }

        List<SubjectCategoryDTO> list = new ArrayList<SubjectCategoryDTO>( source.size() );
        for ( SubjectCategoryBO subjectCategoryBO : source ) {
            list.add( convertBack( subjectCategoryBO ) );
        }

        return list;
    }
}
