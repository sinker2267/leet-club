package com.leetclub.subject.common.enums;

import lombok.Getter;

/**
 * @author sinker
 * @date 2025/7/20 15:25
 */
@Getter
public enum PageEnum {

    DEFAULT_PAGENO(1, "分页默认序号"),
    DEFAULT_PAGESIZE(20, "分页默认大小"),
    TOTAL_PAGES(0, "分页默认页数"),
    TOTAL_COUNT(0, "分页默认数据条数");


    private Integer code;
    private String message;

    PageEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public static PageEnum getByCode(int code) {
        for (PageEnum flag : PageEnum.values()) {
            if (flag.getCode() == code) {
                return flag;
            }
        }
        return null;
    }

}
