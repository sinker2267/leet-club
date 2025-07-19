package com.leetclub.subject.infra.basic.service;

import com.leetclub.subject.infra.basic.pojo.SubjectCategory;

import java.util.List;


/**
 * 题目分类表(SubjectCategory)表服务接口
 *
 * @author makejava
 * @since 2025-07-17 22:11:47
 */
public interface SubjectCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectCategory queryById(Long id);


    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    SubjectCategory insert(SubjectCategory subjectCategory);

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    int update(SubjectCategory subjectCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<SubjectCategory> queryCategory(SubjectCategory subjectCategory);

}
