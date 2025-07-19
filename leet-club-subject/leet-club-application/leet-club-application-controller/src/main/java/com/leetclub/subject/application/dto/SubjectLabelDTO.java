package com.leetclub.subject.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 题目标签表
 * @TableName subject_label
 */
@Data
public class SubjectLabelDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 标签分类
     */
    @JsonProperty("label_name")
    private String labelName;

    /**
     * 排序
     */
    @JsonProperty("sort_num")
    private Integer sortNum;

    /**
     *
     */
    @JsonProperty("category_id")
    private String categoryId;




}