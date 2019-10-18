package com.example.pojo;

import com.example.enumration.SexEnum;

import javax.persistence.AttributeConverter;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/10/18 2:22 下午
 * @Describe
 */
public class SexConverter implements AttributeConverter<SexEnum, Integer> {
    @Override
    public Integer convertToDatabaseColumn(SexEnum sexEnum) {
        return sexEnum.getId();
    }

    @Override
    public SexEnum convertToEntityAttribute(Integer integer) {
        return SexEnum.getEunmBeId(integer);
    }
}
