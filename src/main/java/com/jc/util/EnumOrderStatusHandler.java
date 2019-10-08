package com.jc.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnumOrderStatusHandler extends BaseTypeHandler<Gender> {

    /**
     * 设置配置文件设置的转换类以及枚举类内容，供其他方法更便捷高效的实现
     * @param type 配置文件中设置的转换类
     */
    public EnumOrderStatusHandler(Class<Gender> type) {
        if (type == null)
            throw new IllegalArgumentException("Type argument cannot be null");
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Gender parameter, JdbcType jdbcType) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放int类型
        // ps.setString
        ps.setString(i, parameter.getKey());
    }

    @Override
    public Gender getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放int类型
        String i = rs.getString(columnName);
       // int i = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的值，定位Enum子类
            return locateEnum(i);
        }
    }


    @Override
    public Gender getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放int类型
         String i = rs.getString(columnIndex);
        //int i = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的值，定位Enum子类
            return locateEnum(i);
        }
    }


    @Override
    public Gender getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放int类型
        // String i = cs.getString(columnIndex);
        String i = cs.getString(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的值，定位Enum子类
            return locateEnum(i);
        }
    }

    /**
     * 枚举类型转换
     * @param value 数据库中存储的自定义属性
     * @return value对应的枚举类
     */
    private Gender locateEnum(String value) {
        for (Gender status : Gender.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("未知的枚举类型：" + value);
    }
}
