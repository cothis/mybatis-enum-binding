package com.cothis.mybatisenum.typehandlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@RequiredArgsConstructor
@MappedTypes(EnumCode.class)
@Slf4j
public class EnumCodeHandler<E extends Enum<E>> extends BaseTypeHandler<EnumCode> {

	private final Class<E> type;

	private EnumCode getEnumCode(int code) {
		EnumCode[] enumCodes = (EnumCode[]) type.getEnumConstants();
		return Arrays.stream(enumCodes).filter(enumCode -> enumCode.getCode() == code)
				.findAny()
				.orElseGet(() -> {
					log.warn("해당하는 enum code " + code + "가 존재하지 않습니다. null 로 동작합니다.");
					return null;
				});
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, EnumCode enumCode, JdbcType jdbcType) throws SQLException {
		ps.setInt(i, enumCode.getCode());
	}

	@Override
	public EnumCode getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return getEnumCode(rs.getInt(columnName));
	}

	@Override
	public EnumCode getNullableResult(ResultSet rs, int i) throws SQLException {
		return getEnumCode(rs.getInt(i));
	}

	@Override
	public EnumCode getNullableResult(CallableStatement cs, int i) throws SQLException {
		return getEnumCode(cs.getInt(i));
	}
}