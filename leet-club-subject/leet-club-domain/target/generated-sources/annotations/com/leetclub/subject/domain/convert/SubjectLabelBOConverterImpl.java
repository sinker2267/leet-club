package com.leetclub.subject.domain.convert;

import com.leetclub.subject.domain.entity.SubjectLabelBO;
import com.leetclub.subject.infra.basic.pojo.SubjectLabel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-21T21:35:09+0800",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.14 (Oracle Corporation)"
)
@Component
public class SubjectLabelBOConverterImpl implements SubjectLabelBOConverter {

    @Override
    public SubjectLabel convert(SubjectLabelBO source) {
        if ( source == null ) {
            return null;
        }

        SubjectLabel subjectLabel = new SubjectLabel();

        subjectLabel.setId( source.getId() );
        subjectLabel.setLabelName( source.getLabelName() );
        subjectLabel.setSortNum( source.getSortNum() );
        subjectLabel.setCategoryId( source.getCategoryId() );

        return subjectLabel;
    }

    @Override
    public SubjectLabelBO convertBack(SubjectLabel source) {
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
    public List<SubjectLabel> convert(List<SubjectLabelBO> source) {
        if ( source == null ) {
            return null;
        }

        List<SubjectLabel> list = new ArrayList<SubjectLabel>( source.size() );
        for ( SubjectLabelBO subjectLabelBO : source ) {
            list.add( convert( subjectLabelBO ) );
        }

        return list;
    }

    @Override
    public List<SubjectLabelBO> convertBack(List<SubjectLabel> source) {
        if ( source == null ) {
            return null;
        }

        List<SubjectLabelBO> list = new ArrayList<SubjectLabelBO>( source.size() );
        for ( SubjectLabel subjectLabel : source ) {
            list.add( convertBack( subjectLabel ) );
        }

        return list;
    }
}
