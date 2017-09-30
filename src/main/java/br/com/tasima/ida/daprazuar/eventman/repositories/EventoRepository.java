package br.com.tasima.ida.daprazuar.eventman.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.tasima.ida.daprazuar.eventman.models.Evento;

@Repository
public class EventoRepository {

	//private MemoryStorage memStorage;
	NamedParameterJdbcTemplate jdbcTemplate;
	
	public EventoRepository() {
		//memStorage = MemoryStorage.getInstance();
	}
	
	public List<Evento> FindAll() {
		//return memStorage.eventos;
		
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
	
	public Evento Find(int id) {
		/*if (id > memStorage.eventos.size()-1)
    		return null;
    	
    	return memStorage.eventos.get(id);*/
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
	
	public Evento Find(String name) {
		/*Evento found = null;
    	
    	for (Evento e : memStorage.eventos) {
			if (e.getNome().equalsIgnoreCase(name)) {
				found = e;
				break;
			}
		}
    	
    	return found;*/
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
	
	public void Insert(Evento ev) {
		//memStorage.eventos.add(ev);
		String sql = "insert into evento (nome, data) values (:nome, :data)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", ev.getNome());
		params.put("date", ev.getData());
		
		jdbcTemplate.update(sql, params);
	}
	
	public void Update(Evento ev) {
		//memStorage.eventos.remove(ev.getId());
		//memStorage.eventos.add(ev.getId(), ev);
	}
}
