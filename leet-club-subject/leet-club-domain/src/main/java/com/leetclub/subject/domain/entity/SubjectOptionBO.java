package com.leetclub.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author sinker
 * @date 2025/7/21 21:24
 */
@Data
public class SubjectOptionBO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String subjectAnswer;
    private List<SubjectAnswerBo> optionList;
}
