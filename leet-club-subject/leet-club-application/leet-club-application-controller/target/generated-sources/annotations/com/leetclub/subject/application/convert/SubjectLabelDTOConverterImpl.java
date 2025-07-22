package com.leetclub.subject.application.convert;

import com.leetclub.subject.application.dto.SubjectLabelDTO;
import com.leetclub.subject.domain.entity.SubjectLabelBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-21T22:32:53+0800",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.14 (Oracle Corporation)"
)
@Component
public class SubjectLabelDTOConverterImpl implements SubjectLabelDTOConverter {

    @Override
    public SubjectLabelBO convert(SubjectLabelDTO source) {
        if ( source == null ) {
            return null;
        }

        SubjectLabelBO subjectLabelBO = new SubjectLabelBO();

        subjectLabelBO.setId( source.getId() );
        subjectLabelBO.setLabelName( source.getLabelName() );
        subjectLabelBO.setSortNum( source.getSortNum() );
        subjectLabelBO.setCategoryId( source.getCategoryId() );

        return subjectLabelBO;
    }

    @Override
    public SubjectLabelDTO convertBack(SubjectLabelBO source) {
        if ( source == null ) {
            return null;
        }

        SubjectLabelDTO subjectLabelDTO = new SubjectLabelDTO();

        subjectLabelDTO.setId( source.getId() );
        subjectLabelDTO.setLabelName( source.getLabelName() );
        subjectLabelDTO.setSortNum( source.getSortNum() );
        subjectLabelDTO.setCategoryId( source.getCategoryId() );

        return subjectLabelDTO;
    }

    @Override
    public List<SubjectLabelBO> convert(List<SubjectLabelDTO> source) {
        if ( source == null ) {
            return null;
        }

        List<SubjectLabelBO> list = new ArrayList<SubjectLabelBO>( source.size() );
        for ( SubjectLabelDTO subjectLabelDTO : source ) {
            list.add( convert( subjectLabelDTO ) );
        }

        return list;
    }

    @Override
    public List<SubjectLabelDTO> convertBack(List<SubjectLabelBO> source) {
        if ( source == null ) {
            return null;
        }

        List<SubjectLabelDTO> list = new ArrayList<SubjectLabelDTO>( source.size() );
        for ( SubjectLabelBO subjectLabelBO : source ) {
            list.add( convertBack( subjectLabelBO ) );
        }

        return list;
    }
}
