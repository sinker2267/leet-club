package com.leetclub.subject.domain.handler.subject;

/**
 * @author sinker
 * @date 2025/7/20 10:28
 */


import com.leetclub.subject.common.enums.SubjectInfoTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目类型工厂
 */
@Component
public class SubjectTypeHandlerFactory implements InitializingBean {


    @Autowired
    private List<SubjectTypeHandler> handlers;

    private Map<SubjectInfoTypeEnum, SubjectTypeHandler> handlerMap = new HashMap<>();

    public SubjectTypeHandler getHandler(int code) {
        SubjectInfoTypeEnum subjectInfoTypeEnum = SubjectInfoTypeEnum.getEnum(code);
        return handlerMap.get(subjectInfoTypeEnum);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (SubjectTypeHandler handler : handlers) {
            handlerMap.put(handler.getSubjectHandlerType(), handler);
        }
    }

}
