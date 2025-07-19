package com.leetclub.subject.infra.basic.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serial;
import java.util.Date;
import java.io.Serializable;

/**
 * 题目分类表(SubjectCategory)实体类
 *
 * @author makejava
 * @since 2025-07-17 22:11:42
 */
@Data
public class SubjectCategory implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
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
/**
     * 创建人
     */
    private String createdBy;
/**
     * 创建时间
     */
    private Date createdTime;
/**
     * 更新人
     */
    private String updateBy;
/**
     * 更新时间
     */
    private Date updateTime;

    @TableLogic
    private Integer isDeleted;




}

