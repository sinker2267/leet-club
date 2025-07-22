package com.leetclub.subject.domain.entity;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author sinker
 * @date 2025/7/21 10:53
 */

@Data
public  class SubjectAnswerBo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer optionType;
    private String optionContent;
    private Integer isCorrect;
    private Integer isWrong;
}