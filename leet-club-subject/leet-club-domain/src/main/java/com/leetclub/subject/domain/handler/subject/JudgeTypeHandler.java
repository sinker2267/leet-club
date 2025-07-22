package com.leetclub.subject.domain.handler.subject;

import com.leetclub.subject.common.enums.SubjectInfoTypeEnum;
import com.leetclub.subject.domain.convert.SubjectJudgeAnswerBOConverter;
import com.leetclub.subject.domain.entity.SubjectAnswerBo;
import com.leetclub.subject.domain.entity.SubjectInfoBO;
import com.leetclub.subject.domain.entity.SubjectOptionBO;
import com.leetclub.subject.infra.basic.pojo.SubjectBrief;
import com.leetclub.subject.infra.basic.pojo.SubjectJudge;
import com.leetclub.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sinker
 * @date 2025/7/20 10:27
 */
@Component
public class JudgeTypeHandler implements SubjectTypeHandler {
    private final SubjectJudgeAnswerBOConverter subjectJudgeAnswerBOConverter;
    private final SubjectJudgeService subjectJudgeService;

    public JudgeTypeHandler(SubjectJudgeAnswerBOConverter subjectJudgeAnswerBOConverter, SubjectJudgeService subjectJudgeService) {
        this.subjectJudgeAnswerBOConverter = subjectJudgeAnswerBOConverter;
        this.subjectJudgeService = subjectJudgeService;
    }

    @Override
    public SubjectInfoTypeEnum getSubjectHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public Boolean add(SubjectInfoBO subjectInfoBO) {
        List<SubjectJudge> subjectJudgeList = new ArrayList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectJudge subjectJudge = subjectJudgeAnswerBOConverter.convert(option);
            subjectJudge.setSubjectId(subjectInfoBO.getId());
            subjectJudgeList.add(subjectJudge);
        });
        return subjectJudgeService.saveBatch(subjectJudgeList);
    }

    @Override
    public SubjectOptionBO getOptionByCondtion(Long subjectId) {
        SubjectJudge subjectJudge = subjectJudgeService.queryByCondition(subjectId);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setSubjectAnswer(subjectJudge.getIsCorrect().toString());
        return subjectOptionBO;
    }


}
