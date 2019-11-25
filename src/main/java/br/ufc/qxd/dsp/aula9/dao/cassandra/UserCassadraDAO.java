package br.ufc.qxd.dsp.aula9.dao.cassandra;

import java.util.ArrayList;
import java.util.List;

import br.ufc.qxd.dsp.aula9.cassandra.CassandraUtil;
import br.ufc.qxd.dsp.aula9.dao.UserDAO;
import br.ufc.qxd.dsp.aula9.model.User;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

public class UserCassadraDAO implements UserDAO {
	
	private CqlSession session;
	
	public UserCassadraDAO() {
		this.session = CassandraUtil.getSession();
	}

	@Override
	public void insert(User user) {
		PreparedStatement stmt = session.prepare(""
				+ "INSERT INTO users "
				+ "(id, nome, emails, top_places, coisas_a_fazer) "
				+ "VALUES (?, ?, ?, ?, ?);");
		BoundStatement bound = stmt.bind(user.getId(), user.getNome(),
				user.getEmails(), user.getTopPlaces(), 
				user.getCoisasAFazer());
		session.execute(bound);
	}

	@Override
	public void update(User user) {
		PreparedStatement stmt = session.prepare(""
				+ "UPDATE users SET "
				+ "nome=?, emails=?, top_places=?, coisas_a_fazer=? "
				+ "WHERE id=?;");
		BoundStatement bound = stmt.bind(user.getNome(),
				user.getEmails(), user.getTopPlaces(), 
				user.getCoisasAFazer(), user.getId());
		session.execute(bound);
	}

	@Override
	public void delete(User user) {
		delete(user.getId());
	}

	@Override
	public void delete(Object id) {
		PreparedStatement stmt = session.prepare(
				"DELETE FROM users WHERE id=?;");
		BoundStatement bound = stmt.bind(id);
		session.execute(bound);
	}

	@Override
	public User find(Object id) {
		PreparedStatement stmt = session.prepare("SELECT * FROM users"
				+ " WHERE id=?; ");
		BoundStatement bound = stmt.bind(id);
		ResultSet rs = session.execute(bound);
		Row row = rs.one();
		User user = User.fromRow(row);
		return user;
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		String cql = "SELECT * FROM users;";
		ResultSet rs = session.execute(cql);
		List<Row> rows = rs.all();
		for(Row row : rows) {
			users.add(User.fromRow(row));
		}
		return users;
	}

	@Override
	public void close() {
		CassandraUtil.closeSession();
	}

}
