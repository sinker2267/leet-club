package com.leetclub.subject.common.enums;

import lombok.Getter;

/**
 * @author sinker
 * @date 2025/7/20 10:16
 */
@Getter
public enum SubjectInfoTypeEnum {
    RADIO(1, "单选"),
    MULTIPLE(2, "多选"),
    JUDGE(3, "判断"),
    BRIEF(4, "简答");

    private int code;
    private String desc;
    SubjectInfoTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SubjectInfoTypeEnum getEnum(int code) {
        for (SubjectInfoTypeEnum e : SubjectInfoTypeEnum.values()) {
            if (e.code == code) {
                return e;
            }
        }
        return null;
    }
}
