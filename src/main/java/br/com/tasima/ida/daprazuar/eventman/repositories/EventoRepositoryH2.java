package br.com.tasima.ida.daprazuar.eventman.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import br.com.tasima.ida.daprazuar.eventman.models.Evento;

public class EventoRepositoryH2 {
	
NamedParameterJdbcTemplate jdbcTemplate;
	
	public EventoRepositoryH2(DataSource dataSouce) {

		JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setURL("jdbc:h2:./dpz");
		dataSource.setUser("sa");
		dataSource.setPassword("");
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Evento> findAll() {
		
		String selectSql = "select * from evento";
		
		List<Evento> events = jdbcTemplate.query(selectSql, new RowMapper<Evento>() {
			@Override
			public Evento mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Evento( 
						rs.getLong("id"), 
						rs.getString("nome"), 
						rs.getDate("data"));
			}
		});
		
		return events;
	}
	
	public Evento find(int id) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		String sql = "select * from evento where id = :id";
		
		Evento evento = jdbcTemplate.queryForObject(sql, params, new RowMapper<Evento>() {
			@Override
			public Evento mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new Evento(
						rs.getLong("id"),
						rs.getString("nome"),
						rs.getDate("data")
						);
			}
		});
		return evento;
	}
	
	public Evento find(String name) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nome", name);
		String sql = "select * from evento where nome = :nome";
		
		Evento evento = jdbcTemplate.queryForObject(sql, params, new RowMapper<Evento>() {
			@Override
			public Evento mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new Evento(
						rs.getLong("id"),
						rs.getString("nome"),
						rs.getDate("data")
						);
			}
		});
		return evento;
	}
	
	public void insert(Evento ev) {
		
		String sql = "insert into evento (nome, data) values (:nome, :data)";
		
		//System.out.println("explodiu");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nome", ev.getNome());
		params.put("data", ev.getData());
		//System.out.println("explodiu 2");
		
		jdbcTemplate.update(sql, params);
	}
	
	public void update(Evento ev) {
		String sql = "update evento set nome = :nome, data = :data where id = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nome", ev.getNome());
		params.put("data", ev.getData());
		jdbcTemplate.update(sql, params);
	}
	
	public void delete(long id) {
		String sql = "delete from evento where id = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id",id);
		jdbcTemplate.update(sql, params);
	}

}
