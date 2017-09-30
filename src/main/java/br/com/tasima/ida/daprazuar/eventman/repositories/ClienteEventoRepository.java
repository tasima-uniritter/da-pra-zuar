package br.com.tasima.ida.daprazuar.eventman.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import br.com.tasima.ida.daprazuar.eventman.models.ClienteEvento;

public class ClienteEventoRepository {
	
	NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<ClienteEvento> FindAll() {
		
		String selectSql = "select * from cliente_evento";
		
		List<ClienteEvento> clientes = jdbcTemplate.query(selectSql, new RowMapper<ClienteEvento>() {
			@Override
			public ClienteEvento mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new ClienteEvento( 
						rs.getLong("id"),
						rs.getString("email"), 
						rs.getString("nome"), 
						rs.getString("telefone"));
			}
		});
		
		return clientes;
	}
	
	public ClienteEvento Find(int id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		String sql = "select * from cliente_evento where id = :id";
		
		ClienteEvento cliente = jdbcTemplate.queryForObject(sql, params, new RowMapper<ClienteEvento>() {
			@Override
			public ClienteEvento mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new ClienteEvento(
						rs.getString("id"),
						rs.getString("nome"),
						rs.getString("data")
						);
			}
		});
		return cliente;
	}
	
	public ClienteEvento Find(String name) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nome", name);
		String sql = "select * from cliente_evento where nome = :nome";
		
		ClienteEvento cliente = jdbcTemplate.queryForObject(sql, params, new RowMapper<ClienteEvento>() {
			@Override
			public ClienteEvento mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new ClienteEvento(
						rs.getLong("id"),
						rs.getString("nome"),
						rs.getString("email"),
						rs.getString("telefone")
						);
			}
		});
		return cliente;
	}
	
	public void Insert(ClienteEvento cli) {
		
		String sql = "insert into cliente_evento (nome, email, telefone) values (:nome, :email, :telefone)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", cli.getNome());
		params.put("email", cli.getEmail());
		params.put("telefone", cli.getTelefone());
		
		jdbcTemplate.update(sql, params);
	}
}
