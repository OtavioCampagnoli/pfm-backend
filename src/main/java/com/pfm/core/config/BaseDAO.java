package com.pfm.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public class BaseDAO {

	@Value("${spring.datasource.defaultSchema}")
	public String schemaName;

	@Autowired
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public String mapLike(String value) {
		if (value != null) {
			return "%" + value + "%";
		}
		return null;
	}

}
