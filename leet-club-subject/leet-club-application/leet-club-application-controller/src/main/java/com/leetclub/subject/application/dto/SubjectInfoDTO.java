package com.leetclub.subject.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.leetclub.subject.common.entity.PageInfo;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 题目信息表
 * @TableName subject_info
 */

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SubjectInfoDTO extends PageInfo implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 题目名称
     */
    private String subjectName;

    /**
     * 题目难度
     */
    private Integer subjectDifficult;

    /**
     * 出题人名
     */
    private String settleName;

    /**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    private Integer subjectType;

    /**
     * 题目分数
     */
    private Integer subjectScore;

    /**
     * 题目解析
     */
    private String subjectParse;

    /**
     * 类型id
     */
    private List<Long> categoryIds;

    /**
     * 标签id
     */
    private List<Long> labelIds;

    /**
     * 标签name
     */
    private List<String> labelName;

    /**
     * 选项列表
     */
    private List<SubjectAnswerDTO> optionList;

    /**
     * 问题答案
     */
    private String subjectAnswer;

    private SubjectAnswerDTO subjectAnswerDTO;

    @Serial
    private static final long serialVersionUID = 1L;

    private Long categoryId;
    private Long labelId;

}