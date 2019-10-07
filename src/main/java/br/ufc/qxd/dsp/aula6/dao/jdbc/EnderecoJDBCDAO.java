package br.ufc.qxd.dsp.aula6.dao.jdbc;

import br.ufc.qxd.dsp.aula6.dao.EnderecoDAO;
import br.ufc.qxd.dsp.aula6.model.Endereco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EnderecoJDBCDAO extends GenericJDBCDAO<Endereco> implements EnderecoDAO {

    public EnderecoJDBCDAO() {
        super("endereco");
    }

    @Override
    protected Endereco fromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String rua = rs.getString("rua");
        int numero = rs.getInt("numero");
        String bairro = rs.getString("bairro");
        String cidade = rs.getString("cidade");
        Endereco e = new Endereco(id, rua, numero, bairro, cidade, new ArrayList<>());
        return e;
    }

    @Override
    protected PreparedStatement prepareToInsert(Endereco e) throws SQLException {
        String sql = "INSERT INTO endereco VALUES (default, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, e.getRua());
        stmt.setInt(2, e.getNumero());
        stmt.setString(3, e.getBairro());
        stmt.setString(4, e.getCidade());
        return stmt;
    }

    @Override
    protected PreparedStatement prepareToUpdate(Endereco e) throws SQLException {
        String sql = "UPDATE endereco SET rua=?, numero=?, bairro=?, cidade=? WHERE id=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, e.getRua());
        stmt.setInt(2, e.getNumero());
        stmt.setString(3, e.getBairro());
        stmt.setString(4, e.getCidade());
        stmt.setInt(5, e.getId());
        return stmt;
    }

    @Override
    public List<Endereco> findByClientId(int clienteId) {
        try {
            List<Endereco> l = new ArrayList<Endereco>();

            String sql = "SELECT e.* FROM endereco e, cliente_endereco ce"
                    + " WHERE ce.endereco_id=e.id AND ce.cliente_id=?;";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, clienteId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                l.add(this.fromResultSet(rs));
            }
            return l;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
