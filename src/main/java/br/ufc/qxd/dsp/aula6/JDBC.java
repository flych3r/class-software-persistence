package br.ufc.qxd.dsp.aula6;

import br.ufc.qxd.dsp.aula6.dao.ClienteDAO;
import br.ufc.qxd.dsp.aula6.dao.jdbc.ClienteJDBCDAO;
import br.ufc.qxd.dsp.aula6.model.Cliente;

import java.util.List;

public class JDBC {


    public static void main(String[] args) {
	
		/*Cliente c = new Cliente("Luis", "1000000");
		ClienteDAO cdao = new ClienteJDBCDAO();
		cdao.insert(c);
		cdao.closeConnection();
		
		System.out.println(c);
		*/

        ClienteDAO cdao = new ClienteJDBCDAO();
        List<Cliente> list = cdao.findAll();
        for (Cliente c : list) System.out.println(c);
        cdao.closeConnection();


        System.out.println("FIM");
    }
}



