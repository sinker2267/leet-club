package com.leetclub.subject.domain.handler.subject;

import com.leetclub.subject.common.enums.SubjectInfoTypeEnum;
import com.leetclub.subject.domain.convert.SubjectRadioAnswerBOConverter;
import com.leetclub.subject.domain.entity.SubjectAnswerBo;
import com.leetclub.subject.domain.entity.SubjectInfoBO;
import com.leetclub.subject.domain.entity.SubjectOptionBO;
import com.leetclub.subject.infra.basic.pojo.SubjectRadio;
import com.leetclub.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sinker
 * @date 2025/7/20 10:22
 */
@Component
public class RadioTypeHandler implements SubjectTypeHandler{

    private final SubjectRadioAnswerBOConverter subjectRadioAnswerBOConverter;
    private final SubjectRadioService subjectRadioService;

    public RadioTypeHandler(SubjectRadioAnswerBOConverter subjectRadioAnswerBOConverter, SubjectRadioService subjectRadioService) {
        this.subjectRadioAnswerBOConverter = subjectRadioAnswerBOConverter;
        this.subjectRadioService = subjectRadioService;
    }

    @Override
    public SubjectInfoTypeEnum getSubjectHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public Boolean add(SubjectInfoBO subjectInfoBO) {
        List<SubjectRadio> subjectRadioList = new ArrayList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectRadio subjectRadio = subjectRadioAnswerBOConverter.convert(option);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadioList.add(subjectRadio);
        });
        return subjectRadioService.saveBatch(subjectRadioList);
    }

    @Override
    public SubjectOptionBO getOptionByCondtion(Long subjectId) {
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        List<SubjectRadio> subjectRadioList = subjectRadioService.quaryByCondition(subjectId);
        List<SubjectAnswerBo> subjectAnswerBoList = new ArrayList<>();
        subjectRadioList.forEach(subjectRadio -> {
            if (subjectRadio.getIsCorrect().equals(1)){
                subjectOptionBO.setSubjectAnswer(subjectRadio.getOptionType().toString());
            }
            subjectAnswerBoList.add(subjectRadioAnswerBOConverter.convertBack(subjectRadio));
        });
        subjectOptionBO.setOptionList(subjectAnswerBoList);
        return subjectOptionBO;
    }


}
