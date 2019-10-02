package br.ufc.qxd.dsp.atividade1;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Atividade {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {

        final Session session = getSession();

        try {
//            ClienteDAO clienteDAO = new ClienteDAO();
//            Cliente cliente = new Cliente();
//            cliente.setNome("Joao Antonio");
//            cliente.setCpf("99999999999");
//
//            List<Endereco> enderecos = new ArrayList<>();
//            Endereco endereco = new Endereco();
//            endereco.setRua("Rua A");
//            endereco.setNumero("1");
//            endereco.setBairro("Bairro B");
//            endereco.setCidade("Cidade C");
//            enderecos.add(endereco);
//            cliente.setEnderecos(enderecos);
//
//            List<Telefone> telefones = new ArrayList<>();
//            Telefone telefone = new Telefone();
//            telefone.setDdd("85");
//            telefone.setNumero("900000000");
//            telefones.add(telefone);
//            cliente.setTelefones(telefones);
//
//            clienteDAO.create(session, cliente);
        } finally {
            session.close();
        }
    }
}