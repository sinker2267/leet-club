package com.leetclub.subject.domain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.leetclub.subject.domain.convert.SubjectLabelBOConverter;
import com.leetclub.subject.domain.entity.SubjectLabelBO;
import com.leetclub.subject.domain.service.SubjectLabelDomainService;
import com.leetclub.subject.infra.basic.pojo.SubjectLabel;
import com.leetclub.subject.infra.basic.service.SubjectLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sinker
 * @date 2025/7/19 15:55
 */
@Service
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {
    @Autowired
    private SubjectLabelService subjectLabelService;
    @Autowired
    private SubjectLabelBOConverter subjectLabelBOConverter;


    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = subjectLabelBOConverter.convert(subjectLabelBO);
        return subjectLabelService.save(subjectLabel);
    }

    @Override
    public Boolean deleteById(Long id) {
        return subjectLabelService.removeById(id);
    }

    @Override
    public boolean batchDeleteByIds(List<Long> ids) {
        return subjectLabelService.removeByIds(ids);
    }

    @Override
    public boolean updateById(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = subjectLabelBOConverter.convert(subjectLabelBO);
        return subjectLabelService.updateById(subjectLabel);
    }

    @Override
    public List<SubjectLabelBO> quarySubjectLabelByCategoryId(String categoryId) {
        LambdaQueryWrapper<SubjectLabel> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SubjectLabel::getCategoryId, categoryId);
        List<SubjectLabel> list = subjectLabelService.list(wrapper);
        return subjectLabelBOConverter.convertBack(list);
    }


}
