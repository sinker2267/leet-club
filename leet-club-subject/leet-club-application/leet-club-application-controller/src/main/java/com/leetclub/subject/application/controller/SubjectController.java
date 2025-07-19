package com.leetclub.subject.application.controller;

import com.leetclub.subject.infra.basic.entity.SubjectCategory;
import com.leetclub.subject.infra.basic.service.SubjectCategoryService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sinker
 * @date 2025/7/17 21:15
 */
@RestController
public class SubjectController {

    @Autowired
    private SubjectCategoryService subjectCategoryService;

    @GetMapping("test")
    public String test(){
        return subjectCategoryService.queryById(1L).getCategoryName();
    }
}
