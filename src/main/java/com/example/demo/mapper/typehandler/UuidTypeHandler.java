package com.example.demo.mapper.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.UUID;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

/**
 * mybatis uuid를 쓰기 위함 없으면 null로 나온다
 *
 * @see UUID
 */
@MappedTypes({UUID.class})
public class UuidTypeHandler implements TypeHandler<UUID> {
  private static final Logger LOG = LoggerFactory.getLogger(UuidTypeHandler.class);

  @Override
  public void setParameter(PreparedStatement ps, int i, UUID parameter, JdbcType jdbcType) throws SQLException {
    if (parameter == null) {
      ps.setObject(i, null, Types.OTHER);
    } else {
      ps.setObject(i, parameter.toString(), Types.OTHER);
    }

  }

  @Override
  public UUID getResult(ResultSet rs, String columnName) throws SQLException {
    return toUUID(rs.getString(columnName));
  }

  @Override
  public UUID getResult(ResultSet rs, int columnIndex) throws SQLException {
    return toUUID(rs.getString(columnIndex));
  }

  @Override
  public UUID getResult(CallableStatement cs, int columnIndex) throws SQLException {
    return toUUID(cs.getString(columnIndex));
  }

  private static UUID toUUID(String val) {
    if (!Strings.isNullOrEmpty(val)) {
      try {
        return UUID.fromString(val);
      } catch (IllegalArgumentException e) {
        LOG.warn("Bad UUID found: {}", val);
      }
    }
    return null;
  }

}