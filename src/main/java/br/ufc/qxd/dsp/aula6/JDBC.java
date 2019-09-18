package br.ufc.qxd.dsp.aula6;

import java.sql.*;

public class JDBC {

    private static String driver = "org.postgresql.Driver";
    private static String url = "jdbc:postgresql://localhost/dsp_atividade1";
    private static String user = "flycher";
    private static String password = "winston1984";

    public static void main(String[] args) {
        try {
            Class.forName(driver);
            Connection con =
                    DriverManager.getConnection(url, user, password);
            System.out.println("Conectado");

            String query = "select * from clientes order by nome";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                System.out.println("Nome: " + nome);
            }

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
