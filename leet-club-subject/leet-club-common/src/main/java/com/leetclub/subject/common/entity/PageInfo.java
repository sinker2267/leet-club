package com.leetclub.subject.common.entity;

import com.leetclub.subject.common.enums.PageEnum;
import lombok.Data;

/**
 * 分页请求实体
 * @author sinker
 * @date 2025/7/20 15:15
 */


@Data
public class PageInfo {

    private Integer pageNo;
    private Integer pageSize;

    public Integer getPageNo() {
        if (pageNo == null || pageNo < 1) {
            pageNo = PageEnum.DEFAULT_PAGENO.getCode();
        }
        return pageNo;
    }
    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1) {
            return PageEnum.DEFAULT_PAGESIZE.getCode();
        }
        return pageSize;
    }
}
