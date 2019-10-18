package com.example.enumration;

public enum SexEnum {

    MALE(1, "男"),
    FAMALE(2, "女");

    private int id;
    private String name;


    SexEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static SexEnum getEunmBeId(int id) {
        for (SexEnum sex : SexEnum.values()) {
            if (sex.id == id) {
                return sex;
            }
        }
        return null;
    }
}
