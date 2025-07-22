package com.leetclub.subject.domain.handler.subject;

import com.leetclub.subject.common.enums.SubjectInfoTypeEnum;
import com.leetclub.subject.domain.convert.SubjectMultipleAnswerBOConverter;
import com.leetclub.subject.domain.entity.SubjectAnswerBo;
import com.leetclub.subject.domain.entity.SubjectInfoBO;
import com.leetclub.subject.domain.entity.SubjectOptionBO;
import com.leetclub.subject.infra.basic.pojo.SubjectJudge;
import com.leetclub.subject.infra.basic.pojo.SubjectMultiple;
import com.leetclub.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sinker
 * @date 2025/7/20 10:26
 */
@Component
public class MultipleTypeHandler implements SubjectTypeHandler{
    private final SubjectMultipleAnswerBOConverter subjectMultipleAnswerBOConverter;
    private final SubjectMultipleService subjectMultipleService;

    public MultipleTypeHandler(SubjectMultipleAnswerBOConverter subjectMultipleAnswerBOConverter, SubjectMultipleService subjectMultipleService) {
        this.subjectMultipleAnswerBOConverter = subjectMultipleAnswerBOConverter;
        this.subjectMultipleService = subjectMultipleService;
    }

    @Override
    public SubjectInfoTypeEnum getSubjectHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public Boolean add(SubjectInfoBO subjectInfoBO) {
        List<SubjectMultiple> subjectMultiples = new ArrayList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectMultiple subjectMultiple = subjectMultipleAnswerBOConverter.convert(option);
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultiples.add(subjectMultiple);
        });
        return subjectMultipleService.saveBatch(subjectMultiples);
    }

    @Override
    public SubjectOptionBO getOptionByCondtion(Long subjectId) {
        List<SubjectMultiple> subjectMultipleList = subjectMultipleService.queryByCondition(subjectId);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        List<SubjectAnswerBo> subjectAnswerBoList = new ArrayList<>();
        List<Long> answerList = new ArrayList<>();
        subjectMultipleList.forEach(subjectMultiple -> {
            if (subjectMultiple.getIsCorrect().equals(1)){
                answerList.add(subjectMultiple.getOptionType());
            }
            subjectAnswerBoList.add(subjectMultipleAnswerBOConverter.convertBack(subjectMultiple));
        });
        subjectOptionBO.setOptionList(subjectAnswerBoList);
        subjectOptionBO.setSubjectAnswer(answerList.toString());
        return subjectOptionBO;
    }


}
