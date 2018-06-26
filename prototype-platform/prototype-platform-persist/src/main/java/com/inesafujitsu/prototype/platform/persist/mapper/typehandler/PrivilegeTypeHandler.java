package com.inesafujitsu.prototype.platform.persist.mapper.typehandler;

import com.inesafujitsu.prototype.platform.model.ctrl.Privilege;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrivilegeTypeHandler extends BaseTypeHandler<Privilege.Type> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Privilege.Type parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    @Override
    public Privilege.Type getNullableResult(ResultSet rs, String columnName) throws SQLException {
        if (rs.wasNull()) {
            return null;
        } else {
            String code = rs.getString(columnName);
            return Privilege.Type.get(code);
        }
    }

    @Override
    public Privilege.Type getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        if (rs.wasNull()) {
            return null;
        } else {
            String code = rs.getString(columnIndex);
            return Privilege.Type.get(code);
        }
    }

    @Override
    public Privilege.Type getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        if (cs.wasNull()) {
            return null;
        } else {
            String code = cs.getString(columnIndex);
            return Privilege.Type.get(code);
        }
    }
}
