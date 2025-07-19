package com.leetclub.subject.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 题目标签表
 * @TableName subject_label
 */
@Data
public class SubjectLabelBO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 标签分类
     */
    private String labelName;

    /**
     * 排序
     */
    private Integer sortNum;

    /**
     * 
     */
    private String categoryId;





}