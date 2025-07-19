package com.leetclub.subject.common.entity;

import java.util.List;

/**
 * @author sinker
 * @date 2025/7/19 19:51
 */
public interface BatchRequest<ID> {
    List<ID> getIds();
}
