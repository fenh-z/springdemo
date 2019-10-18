package com.example.typehandler;

import com.example.enumration.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/10/18 3:46 下午
 * @Describe
 */

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(value = SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {

    //设置非空性别参数
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, sexEnum.getId());
    }

    //通过列名读取性别
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String col) throws SQLException {

        int sex = resultSet.getInt(col);

        if (sex != 1 && sex != 2) {
            return null;
        }

        return SexEnum.getEunmBeId(sex);

    }

    //通过下标读取性别
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sex = resultSet.getInt(i);

        if (sex != 1 && sex != 2) {
            return null;
        }

        return SexEnum.getEunmBeId(sex);
    }

    //通过存储过程获取性别
    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sex = callableStatement.getInt(i);

        if (sex != 1 && sex != 2) {
            return null;
        }

        return SexEnum.getEunmBeId(sex);
    }
}
