package com.leetclub.subject.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author sinker
 * @date 2025/7/21 10:53
 */

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public  class SubjectAnswerDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer optionType;
    private String optionContent;
    private Integer isCorrect;
    private Integer isWrong;
}