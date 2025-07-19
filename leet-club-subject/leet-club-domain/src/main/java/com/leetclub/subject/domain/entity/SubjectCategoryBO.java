package com.leetclub.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 题目分类表(SubjectCategory)实体类
 *
 * @author makejava
 * @since 2025-07-17 22:11:42
 */
@Data
public class SubjectCategoryBO implements Serializable {
    private static final long serialVersionUID = -25506823703496656L;
/**
     * 主键
     */
    private Long id;
/**
     * 分类名称
     */
    private String categoryName;
/**
     * 分类类型
     */
    private Integer categoryType;
/**
     * 图标链接
     */
    private String imageUrl;
/**
     * 父级id
     */
    private Long parentId;



}

