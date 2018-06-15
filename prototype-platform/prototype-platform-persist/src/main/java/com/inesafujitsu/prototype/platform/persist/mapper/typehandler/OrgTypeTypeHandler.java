package com.inesafujitsu.prototype.platform.persist.mapper.typehandler;

import com.inesafujitsu.prototype.platform.model.OrgType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrgTypeTypeHandler extends BaseTypeHandler<OrgType> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, OrgType parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    @Override
    public OrgType getNullableResult(ResultSet rs, String columnName) throws SQLException {
        if (rs.wasNull()) {
            return null;
        } else {
            String code = rs.getString(columnName);
            return OrgType.get(code);
        }
    }

    @Override
    public OrgType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        if (rs.wasNull()) {
            return null;
        } else {
            String code = rs.getString(columnIndex);
            return OrgType.get(code);
        }
    }

    @Override
    public OrgType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        if (cs.wasNull()) {
            return null;
        } else {
            String code = cs.getString(columnIndex);
            return OrgType.get(code);
        }
    }
}
