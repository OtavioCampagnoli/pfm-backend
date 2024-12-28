package com.pfm.core.dao.impl;

import com.pfm.core.config.BaseDAO;
import com.pfm.core.dao.IClassifierDAO;
import com.pfm.core.mapper.ClassifierMapper;
import com.pfm.core.model.ClassifierModel;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;



@Repository
public class ClassifierDAO extends BaseDAO implements IClassifierDAO {

	@Override
	public ClassifierModel save(ClassifierModel model) throws Exception {

		try {
			StringBuffer query = new StringBuffer();

			query.append("INSERT INTO ").append(schemaName).append("classifier ");
			query.append("( ");
			query.append("value, ");
			query.append("type, ");
			query.append("label, ");
			query.append("description ");
			query.append(") ");
			query.append("VALUES ");
			query.append("( ");
			query.append(":value, ");
			query.append(":type, ");
			query.append(":label, ");
			query.append(":description)");

			MapSqlParameterSource params = new MapSqlParameterSource();

			params.addValue("value", model.getValue());
			params.addValue("type", model.getType());
			params.addValue("label", model.getLabel());
			params.addValue("description", model.getDescription());

			KeyHolder keyHolder = new GeneratedKeyHolder();

			this.namedParameterJdbcTemplate.update(query.toString(), params, keyHolder, new String[] { "id" });

			Number generatedId = keyHolder.getKey();

			if (generatedId != null) {
				model.setId(generatedId.intValue());
			}

		} catch (Exception e) {
			throw new Exception("Ocorreu um erro: ", e);
		}

		return model;
	}

	@Override
	public List<ClassifierModel> paginatedSearch(ClassifierModel model, int page, int size, String sortBy, int sortDirection) throws Exception {
		
		List<ClassifierModel> listReturn = new LinkedList<ClassifierModel>();

		try {

			StringBuffer query = new StringBuffer();

			query.append("SELECT ");
			query.append("cla.cla_id, ");
			query.append("cla.value, ");
			query.append("cla.type, ");
			query.append("cla.label, ");
			query.append("cla.description ");
			query.append("FROM ").append(this.schemaName).append("classifier AS cla ");
			query.append(" WHERE cla.cla_id > 0 ");

			MapSqlParameterSource params = new MapSqlParameterSource();

			if(model != null) {
				
				
				if(model.getValue() != null) {
					query.append(" AND cla.value LIKE :value " );
					params.addValue("value", mapLike(model.getValue()));
				}
				
				if(model.getType() != null) {
					query.append(" AND cla.type LIKE :type " );
					params.addValue("type", mapLike(model.getType()));
				}
				
				if(model.getLabel() != null) {
					query.append(" AND cla.label LIKE :label " );
					params.addValue("label", mapLike(model.getLabel()));
				}
				
				if(model.getDescription() != null) {
					query.append(" AND cla.description LIKE :description " );
					params.addValue("description", mapLike(model.getDescription()));
				}
			}
			
			if (sortBy != null && !sortBy.isBlank()) {
				
				switch (sortBy) {
				
					case "value":
						query.append(" ORDER BY cla.value ");
						break;
					case "type":
						query.append(" ORDER BY cla.type ");
						break;
					case "label":
						query.append(" ORDER BY cla.label ");
						break;	
					case "description":
						query.append(" ORDER BY cla.description ");
						break;	
					default:
					    query.append(" ORDER BY cla.cla_id ");
					}
				
					if(sortDirection == -1) {
					    query.append(" DESC ");
				}
			}
			
			query.append(" LIMIT  :limit ");
			params.addValue("limit", size);

			query.append(" OFFSET :offset ");
			params.addValue("offset", page);

			List<ClassifierModel> list = this.namedParameterJdbcTemplate.query(query.toString(), params,
					new ClassifierMapper());

			if (!list.isEmpty()) {
				listReturn.addAll(list);
			}

		} catch (Exception e) {
			throw new Exception("Ocorreu um erro: ", e);
		}

		return listReturn;
	}

	@Override
	public List<ClassifierModel> search(ClassifierModel model) throws Exception {
		List<ClassifierModel> listReturn = new LinkedList<ClassifierModel>();

		try {

			StringBuffer query = new StringBuffer();

			query.append("SELECT ");
			query.append("cla.cla_id, ");
			query.append("cla.value, ");
			query.append("cla.type, ");
			query.append("cla.label, ");
			query.append("cla.description ");
			query.append("FROM ").append(this.schemaName).append("classifier AS cla ");
			query.append(" WHERE cla.cla_id > 0 ");

			MapSqlParameterSource params = new MapSqlParameterSource();

			if(model != null) {
				
				if(model.getValue() != null) {
					query.append(" AND cla.value LIKE :value " );
					params.addValue("value", mapLike(model.getValue()));
				}
				
				if(model.getType() != null) {
					query.append(" AND cla.type LIKE :type " );
					params.addValue("type", mapLike(model.getType()));
				}
				
				if(model.getLabel() != null) {
					query.append(" AND cla.label LIKE :label " );
					params.addValue("label", mapLike(model.getLabel()));
				}
				
				if(model.getDescription() != null) {
					query.append(" AND cla.description LIKE :description " );
					params.addValue("description", mapLike(model.getDescription()));
				}
			}
			
			List<ClassifierModel> list = this.namedParameterJdbcTemplate.query(query.toString(), params,
					new ClassifierMapper());

			if (!list.isEmpty()) {
				listReturn.addAll(list);
			}

		} catch (Exception e) {
			throw new Exception("Ocorreu um erro: ", e);
		}

		return listReturn;
	}

	@Override
	public ClassifierModel update(ClassifierModel model) throws Exception {

		try {

			StringBuffer query = new StringBuffer();

			query.append("UPDATE ").append(schemaName).append("classifier SET ");
			query.append("value = :value, ");
			query.append("type = :type, ");
			query.append("label = :label, ");
			query.append("description = :description ");
			query.append("WHERE cla_id = :id ");

			MapSqlParameterSource params = new MapSqlParameterSource();

			params.addValue("value", model.getValue());
			params.addValue("type", model.getType());
			params.addValue("label", model.getLabel());
			params.addValue("description", model.getDescription());
			params.addValue("id", model.getId());

			this.namedParameterJdbcTemplate.update(query.toString(), params);

		} catch (Exception e) {
			throw new Exception("Ocorreu um erro: ", e);
		}

		return model;
	}

	@Override
	public Boolean deleteById(Integer id) throws Exception {

		try {

			StringBuffer query = new StringBuffer();

			query.append("DELETE FROM ").append(schemaName).append("classifier WHERE cla_id = :id ");

			MapSqlParameterSource params = new MapSqlParameterSource();

			params.addValue("id", id);

			int rowsAffected = this.namedParameterJdbcTemplate.update(query.toString(), params);

			return rowsAffected > 0;

		} catch (Exception e) {
			throw new Exception("Ocorreu um erro: ", e);
		}
	}

	@Override
	public ClassifierModel getById(Integer id) throws Exception {

		ClassifierModel objReturn = new ClassifierModel();

		try {

			StringBuffer query = new StringBuffer();

			query.append("SELECT ");
			query.append("cla.cla_id, ");
			query.append("cla.value, ");
			query.append("cla.type, ");
			query.append("cla.label, ");
			query.append("cla.description ");
			query.append("FROM ").append(this.schemaName).append("classifier AS cla ");
			query.append(" WHERE cla.cla_id = :id ");

			MapSqlParameterSource params = new MapSqlParameterSource();

			params.addValue("id", id);

			List<ClassifierModel> list = this.namedParameterJdbcTemplate.query(query.toString(), params,
					new ClassifierMapper());

			if (!list.isEmpty()) {
				objReturn = list.get(0);
			}

		} catch (Exception e) {
			throw new Exception("Ocorreu um erro: ", e);
		}

		return objReturn;
	}

	@Override
	public List<ClassifierModel> findAll() throws Exception {

		List<ClassifierModel> listReturn = new LinkedList<ClassifierModel>();

		try {

			StringBuffer query = new StringBuffer();

			query.append("SELECT ");
			query.append("cla.cla_id, ");
			query.append("cla.value, ");
			query.append("cla.type, ");
			query.append("cla.label, ");
			query.append("cla.description ");
			query.append("FROM ").append(this.schemaName).append("classifier AS cla ");

			List<ClassifierModel> list = this.jdbcTemplate.query(query.toString(), new ClassifierMapper());

			if (!list.isEmpty()) {
				listReturn.addAll(list);
			}

		} catch (Exception e) {
			throw new Exception("Ocorreu um erro: ", e);
		}

		return listReturn;
	}

	@Override
	public List<ClassifierModel> findAllByType(ClassifierModel model) throws Exception {

		List<ClassifierModel> listReturn = new LinkedList<ClassifierModel>();

		try {

			StringBuffer query = new StringBuffer();

			query.append("SELECT ");
			query.append("cla.cla_id, ");
			query.append("cla.value, ");
			query.append("cla.type, ");
			query.append("cla.label, ");
			query.append("cla.description ");
			query.append("FROM ").append(this.schemaName).append("classifier AS cla ");
			query.append(" WHERE cla.type = :type ");

			MapSqlParameterSource params = new MapSqlParameterSource();

			params.addValue("type", model.getType());

			List<ClassifierModel> list = this.namedParameterJdbcTemplate.query(query.toString(), params,
					new ClassifierMapper());

			if (!list.isEmpty()) {
				listReturn.addAll(list);
			}

		} catch (Exception e) {
			throw new Exception("Ocorreu um erro: ", e);
		}

		return listReturn;
	}

}
