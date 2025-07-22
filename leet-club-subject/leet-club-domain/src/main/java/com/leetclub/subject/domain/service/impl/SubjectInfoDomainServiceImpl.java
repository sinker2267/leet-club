package com.leetclub.subject.domain.service.impl;

import com.leetclub.subject.common.entity.PageResult;
import com.leetclub.subject.domain.convert.SubjectInfoBOConverter;
import com.leetclub.subject.domain.convert.SubjectLabelBOConverter;
import com.leetclub.subject.domain.entity.SubjectAnswerBo;
import com.leetclub.subject.domain.entity.SubjectInfoBO;
import com.leetclub.subject.domain.entity.SubjectOptionBO;
import com.leetclub.subject.domain.handler.subject.SubjectTypeHandler;
import com.leetclub.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.leetclub.subject.domain.service.SubjectInfoDomainService;
import com.leetclub.subject.infra.basic.pojo.SubjectCategory;
import com.leetclub.subject.infra.basic.pojo.SubjectInfo;
import com.leetclub.subject.infra.basic.pojo.SubjectLabel;
import com.leetclub.subject.infra.basic.pojo.SubjectMapping;
import com.leetclub.subject.infra.basic.service.SubjectInfoService;
import com.leetclub.subject.infra.basic.service.SubjectLabelService;
import com.leetclub.subject.infra.basic.service.SubjectMappingService;
import com.leetclub.subject.infra.basic.service.impl.SubjectCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sinker
 * @date 2025/7/20 9:40
 */

@Service
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Autowired
    private SubjectInfoService subjectInfoService;

    @Autowired
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;
    @Autowired
    private SubjectInfoBOConverter subjectInfoBOConverter;
    @Autowired
    private SubjectMappingService subjectMappingService;
    @Autowired
    private SubjectCategoryServiceImpl subjectCategoryService;
    @Autowired
    private SubjectLabelService subjectLabelService;


    @Override
    public Boolean add(SubjectInfoBO subjectInfoBO) {
        SubjectInfo subjectInfo = subjectInfoBOConverter.convert(subjectInfoBO);
        Long id = subjectInfoService.saveReturnPojo(subjectInfo);
        subjectInfoBO.setId(id);
        SubjectTypeHandler subjectTypeHandlerFactoryHandler = subjectTypeHandlerFactory.getHandler(subjectInfoBO.getSubjectType());
        Boolean add = subjectTypeHandlerFactoryHandler.add(subjectInfoBO);

        List<Long> categoryIds = subjectInfoBO.getCategoryIds();
        List<Long> labelIds = subjectInfoBO.getLabelIds();
        List<SubjectMapping> mappingList = new ArrayList<>();
        categoryIds.forEach(categoryId -> {
            labelIds.forEach(labelId -> {
                SubjectMapping mapping = new SubjectMapping();
                mapping.setCategoryId(categoryId);
                mapping.setLabelId(labelId);
                mapping.setSubjectId(id);
                mappingList.add(mapping);
            });
        });
        boolean saveBatch = subjectMappingService.saveBatch(mappingList);

        return saveBatch && add;
    }

    @Override
    public PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO) {
        PageResult<SubjectInfoBO> pageResult = new PageResult<>();
        pageResult.setPageNo(subjectInfoBO.getPageNo());
        pageResult.setPageSize(subjectInfoBO.getPageSize());
        int start = (subjectInfoBO.getPageNo() - 1) * subjectInfoBO.getPageSize();
        SubjectInfo subjectInfo = subjectInfoBOConverter.convert(subjectInfoBO);
        int count = subjectInfoService.countByCondition(subjectInfo, subjectInfoBO.getCategoryId(), subjectInfoBO.getLabelId());

        if (count == 0) {
            return pageResult;
        }
        List<SubjectInfo> subjectInfoList = subjectInfoService.queryPage(subjectInfo, subjectInfoBO.getCategoryId(), subjectInfoBO.getLabelId(), start, subjectInfoBO.getPageSize());
        List<SubjectInfoBO> subjectInfoBOList = subjectInfoBOConverter.convertBack(subjectInfoList);
        pageResult.setRecord(subjectInfoBOList);
        pageResult.setTotal(count);
        return pageResult;
    }

    @Override
    public SubjectInfoBO query(Long subjectId) {
        SubjectInfo subjectInfo = subjectInfoService.getById(subjectId);
        SubjectTypeHandler subjectTypeHandlerFactoryHandler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        SubjectOptionBO subjectOptionBO = subjectTypeHandlerFactoryHandler.getOptionByCondtion(subjectId);
        SubjectInfoBO subjectInfoBO = subjectInfoBOConverter.convertInfoAndOption(subjectInfo, subjectOptionBO);

        List<Long> labelList = subjectMappingService.getLabelListBySubjectId(subjectId);
        List<String> labelNameList = Collections.emptyList();
        if (labelList != null && !labelList.isEmpty()) {
            labelNameList  = subjectLabelService.queryByIds(labelList).stream().map(SubjectLabel::getLabelName).collect(Collectors.toList());
        }

        subjectInfoBO.setLabelName(labelNameList);
        return subjectInfoBO;
    }
}
