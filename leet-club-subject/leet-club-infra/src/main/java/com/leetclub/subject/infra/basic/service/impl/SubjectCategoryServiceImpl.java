package com.leetclub.subject.infra.basic.service.impl;

import com.leetclub.subject.infra.basic.pojo.SubjectCategory;
import com.leetclub.subject.infra.basic.mapper.SubjectCategoryMapper;
import com.leetclub.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 题目分类表(SubjectCategory)表服务实现类
 *
 * @author makejava
 * @since 2025-07-17 22:11:47
 */
@Service("subjectCategoryService")
public class SubjectCategoryServiceImpl implements SubjectCategoryService {
    @Autowired
    private SubjectCategoryMapper subjectCategoryMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectCategory queryById(Long id) {
        return this.subjectCategoryMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param subjectCategory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */

    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory insert(SubjectCategory subjectCategory) {
        this.subjectCategoryMapper.insert(subjectCategory);
        return subjectCategory;
    }

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public int update(SubjectCategory subjectCategory) {
        return this.subjectCategoryMapper.update(subjectCategory);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectCategoryMapper.deleteById(id) > 0;
    }

    @Override
    public List<SubjectCategory> queryCategory(SubjectCategory subjectCategory) {
        return this.subjectCategoryMapper.queryCategory(subjectCategory);
    }

    @Override
    public List<SubjectCategory> queryByIds(List<Long> categoryList) {
        return this.subjectCategoryMapper.queryByIds(categoryList);
    }
}
