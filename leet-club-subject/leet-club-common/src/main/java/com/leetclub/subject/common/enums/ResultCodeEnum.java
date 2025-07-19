package com.leetclub.subject.common.enums;

import lombok.Getter;

/**
 * @author sinker
 * @date 2025/7/18 11:50
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "成功"),
    FAIL(500, "失败");

    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResultCodeEnum getByCode(Integer codeVal) {
        for (ResultCodeEnum result : ResultCodeEnum.values()) {
            if (result.code.equals(codeVal)) {
                return result;
            }
        }
        return null;
    }

}
