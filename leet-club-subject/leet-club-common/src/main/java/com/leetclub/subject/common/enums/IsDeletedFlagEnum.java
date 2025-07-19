package com.leetclub.subject.common.enums;

import lombok.Getter;

/**
 * @author sinker
 * @date 2025/7/19 9:16
 */
@Getter
public enum IsDeletedFlagEnum {

    DELETED(1, "已删除"),
    UN_DELETED(0, "未删除");

    private int code;
    private String message;

    IsDeletedFlagEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static IsDeletedFlagEnum getByCode(int code) {
        for (IsDeletedFlagEnum flag : IsDeletedFlagEnum.values()) {
            if (flag.getCode() == code) {
                return flag;
            }
        }
        return null;
    }


}
