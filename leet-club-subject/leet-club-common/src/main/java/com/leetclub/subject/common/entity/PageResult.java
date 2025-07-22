package com.leetclub.subject.common.entity;

import com.leetclub.subject.common.enums.PageEnum;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * 分页查询返回的实体
 * @author sinker
 * @date 2025/7/20 15:19
 */
@Data
public class PageResult<T> {

    private Integer pageNo = PageEnum.DEFAULT_PAGENO.getCode();
    private Integer pageSize = PageEnum.DEFAULT_PAGESIZE.getCode();
    private Integer totalCount = PageEnum.TOTAL_COUNT.getCode();
    private Integer totalPages = PageEnum.TOTAL_PAGES.getCode();
    private List<T> results =  Collections.emptyList();
    private Integer start;
    private Integer end;

    public void setRecord(List<T> results) {
        this.results = results;
        if (results != null && !results.isEmpty()) {
            setTotal(results.size());
        }
    }

    public void setTotal(int size) {
        this.totalCount = size;
        if(this.pageSize > 0) {
            this.totalPages = (this.totalCount + this.pageSize - 1) / this.pageSize;
        } else {
            this.totalPages = 0;
        }
        this.start = (this.pageNo > 0 ? (this.pageNo - 1)  * this.pageSize : 0) + 1;
        this.end = (this.start - 1 + this.pageSize * (this.pageNo > 0 ? 1 : 0));

    }

    public void setPageSize(Integer pageSize) {
        if(pageSize != null && pageSize > 0) {
            this.pageSize = pageSize;
        }
    }
    public void setPageNo(Integer current) {
        if(current != null && current > 0) {
            this.pageNo = current;
        }
    }

}
