package com.inesafujitsu.prototype.platform.persist.mapper.typehandler;

import com.inesafujitsu.prototype.platform.model.orgchart.User;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenderTypeHandler extends BaseTypeHandler<User.Gender> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, User.Gender parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    @Override
    public User.Gender getNullableResult(ResultSet rs, String columnName) throws SQLException {
        if (rs.wasNull()) {
            return null;
        } else {
            String code = rs.getString(columnName);
            return User.Gender.get(code);
        }
    }

    @Override
    public User.Gender getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        if (rs.wasNull()) {
            return null;
        } else {
            String code = rs.getString(columnIndex);
            return User.Gender.get(code);
        }
    }

    @Override
    public User.Gender getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        if (cs.wasNull()) {
            return null;
        } else {
            String code = cs.getString(columnIndex);
            return User.Gender.get(code);
        }
    }
}
