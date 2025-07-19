package com.leetclub.subject.domain.convert;

import com.leetclub.subject.domain.entity.SubjectCategoryBO;
import com.leetclub.subject.infra.basic.pojo.SubjectCategory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-19T21:46:06+0800",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.14 (Oracle Corporation)"
)
@Component
public class SubjectCategoryBOConverterImpl implements SubjectCategoryBOConverter {

    @Override
    public SubjectCategory convert(SubjectCategoryBO source) {
        if ( source == null ) {
            return null;
        }

        SubjectCategory subjectCategory = new SubjectCategory();

        subjectCategory.setId( source.getId() );
        subjectCategory.setCategoryName( source.getCategoryName() );
        subjectCategory.setCategoryType( source.getCategoryType() );
        subjectCategory.setImageUrl( source.getImageUrl() );
        subjectCategory.setParentId( source.getParentId() );

        return subjectCategory;
    }

    @Override
    public SubjectCategoryBO convertBack(SubjectCategory source) {
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
    public List<SubjectCategory> convert(List<SubjectCategoryBO> source) {
        if ( source == null ) {
            return null;
        }

        List<SubjectCategory> list = new ArrayList<SubjectCategory>( source.size() );
        for ( SubjectCategoryBO subjectCategoryBO : source ) {
            list.add( convert( subjectCategoryBO ) );
        }

        return list;
    }

    @Override
    public List<SubjectCategoryBO> convertBack(List<SubjectCategory> source) {
        if ( source == null ) {
            return null;
        }

        List<SubjectCategoryBO> list = new ArrayList<SubjectCategoryBO>( source.size() );
        for ( SubjectCategory subjectCategory : source ) {
            list.add( convertBack( subjectCategory ) );
        }

        return list;
    }
}
