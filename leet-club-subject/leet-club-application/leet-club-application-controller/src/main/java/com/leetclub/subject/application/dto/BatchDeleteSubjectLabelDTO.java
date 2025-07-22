package com.leetclub.subject.application.dto;

import com.leetclub.subject.common.entity.BatchRequest;
import lombok.Data;

import java.util.List;

/**
 * @author sinker
 * @date 2025/7/19 19:53
 */
@Data
public class BatchDeleteSubjectLabelDTO implements BatchRequest<Long> {
    private List<Long> ids;
}
