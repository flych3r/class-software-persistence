package br.ufc.qxd.dsp.trabalho2.util;

import br.ufc.qxd.dsp.trabalho2.dao.*;
import br.ufc.qxd.dsp.trabalho2.dao.jpa.*;
import br.ufc.qxd.dsp.trabalho2.model.*;

import javax.persistence.PersistenceException;
import javax.swing.*;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

public class Menu {

    private Limpeza limpeza;

    public Menu() {
    }


    public void chamaMenu() throws ParseException {

        String menu = "Escolha uma opção:\n1 - Menu Inserir \n2 - Menu Remover \n3  - Consultas\n4 - Sair";
        char opcao;
        do {
            Funcionario funcionario;
            List<Funcionario> funcionarioList;
            Dependente dependente;
            List<Dependente> dependenteList;
            Endereco endereco;
            Departamento departamento;
            List<Departamento> departamentoList;
            List<Limpeza> limpezaList;
            Pesquisador pesquisador;
            List<Pesquisador> pesquisadorList;
            Pesquisas pesquisas;
            List<Pesquisas> pesquisasList;
            Projeto projeto;
            List<Projeto> projetoList;
            Secretario secretario;
            List<Secretario> secretarioList;

            char opcaob;
            String submenu;
            DepartamentoDAO dDAO = new DepartamendoJPADAO();
            SecretarioDAO secDao = new SecretarioJPADAO();
            PesquisadorDAO pDAO = new PesquisadorJPADAO();
            LimpezaDAO lDAO = new LimpezaJPADAO();
            PesquisasDAO pesqDao = new PesquisasJPADAO();
            DependenteDAO depDao = new DependenteJPADAO();
            ProjetoDAO projDao = new ProjetoJPADAO();



            Calendar c = Calendar.getInstance();



            opcao = JOptionPane.showInputDialog(menu).charAt(0);
            switch (opcao) {

                case '1': // Menu inserir
//----------------------------------------------------------------------------------------------------------------
                    submenu = "Escolha uma opção:\n1 - Inserir Secretario\n2 - Inserir Limpeza\n3 - Inserir Pesquisador\n4 - Inserir um Departamento\n" +
                            "5 - Inserir um Dependente\n6 - Inserir um Projeto\n7 - Inserir uma Pesquisa\n8 - Inserir Um Supervisor De Limpezas\n 9 - Sair";

                    do {
                        opcaob = JOptionPane.showInputDialog(submenu).charAt(0);


                        switch (opcaob) {
                            // insere Secretario
                            case '1':

                                secretario = new Secretario();
                                endereco = new Endereco();


                                departamento = dDAO.find(Integer.parseInt(JOptionPane.showInputDialog("Digite o id do Departamento em qual queira adicionar", 1)));
                                JOptionPane.showMessageDialog(null, departamento == null ? "Nenhum Departamento encontrado" : departamento);

                                if(departamento != null) {
                                    secretario.setDepartamento(departamento);


                                    secretario.setEscolaridade(JOptionPane.showInputDialog("Digite a Escolaridade "));

                                    secretario.setNome(JOptionPane.showInputDialog("Digite o Nome"));
                                    secretario.setSexo(JOptionPane.showInputDialog("Digite o sexo "));


                                    c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(JOptionPane.showInputDialog("Digite o dia do aniversario ")));
                                    c.set(Calendar.MONTH, Integer.parseInt(JOptionPane.showInputDialog("Digite o mes do aniversario ")));
                                    c.set(Calendar.YEAR, Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do aniversario ")));
                                    secretario.setAniversario(c);


                                    secretario.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Digite o Salario")));

                                    endereco.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da casa")));
                                    endereco.setBairro(JOptionPane.showInputDialog("Digite o bairro"));
                                    endereco.setCidade(JOptionPane.showInputDialog("Digite a cidade "));
                                    endereco.setLogradouro(JOptionPane.showInputDialog("Digite o lagradouro "));
                                    endereco.setComplemento(JOptionPane.showInputDialog("Digite o complemento "));

                                    secretario.setEndereco(endereco);


                                    try {
                                        ;
                                        secDao.beginTransaction();
                                        secDao.save(secretario);
                                        secDao.commit();
                                        JOptionPane.showMessageDialog(null, secretario);

                                    } catch (IllegalStateException | PersistenceException e) {
                                        secDao.rollBack();
                                        e.printStackTrace();
                                    } finally {
                                        secDao.close();
                                    }
                                }


                                break;
                            // insere Limpeza
                            case '2':
                                limpeza = new Limpeza();
                                endereco = new Endereco();

                                departamento = dDAO.find(Integer.parseInt(JOptionPane.showInputDialog("Digite o id do Departamento em qual queira adicionar", 1)));
                                JOptionPane.showMessageDialog(null, departamento == null ? "Nenhum Departamento encontrado" : departamento);

                                if(departamento != null) {
                                    limpeza.setDepartamento(departamento);


                                    limpeza.setCargo(JOptionPane.showInputDialog("Digite o Cargo"));
                                    limpeza.setJornada(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de horas")));

                                    limpeza.setNome(JOptionPane.showInputDialog("Digite o Nome "));
                                    limpeza.setSexo(JOptionPane.showInputDialog("Digite o sexo "));


                                    c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(JOptionPane.showInputDialog("Digite o dia do aniversario ")));
                                    c.set(Calendar.MONTH, Integer.parseInt(JOptionPane.showInputDialog("Digite o mes do aniversario ")));
                                    c.set(Calendar.YEAR, Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do aniversario ")));

                                    limpeza.setAniversario(c);


                                    limpeza.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Digite o Salario ", 0.0)));

                                    endereco.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da casa ")));
                                    endereco.setBairro(JOptionPane.showInputDialog("Digite o bairro"));
                                    endereco.setCidade(JOptionPane.showInputDialog("Digite a cidade"));
                                    endereco.setLogradouro(JOptionPane.showInputDialog("Digite o lagradouro"));
                                    endereco.setComplemento(JOptionPane.showInputDialog("Digite o complemento"));

                                    limpeza.setEndereco(endereco);

                                    try {
                                        ;
                                        lDAO.beginTransaction();
                                        lDAO.save(limpeza);
                                        lDAO.commit();
                                        JOptionPane.showMessageDialog(null, limpeza);

                                    } catch (IllegalStateException | PersistenceException e) {
                                        lDAO.rollBack();
                                        e.printStackTrace();
                                    } finally {
                                        lDAO.close();
                                    }
                                }
                                break;


                            case '3':// inserir Pesquisador
                                pesquisador = new Pesquisador();

                                int idDep = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do Departamento em qual está o pesquisador", 1));
                                departamento = dDAO.find(idDep);
                                JOptionPane.showMessageDialog(null, departamento == null ? "Nenhum Departamento encontrado" : departamento);

                                if(departamento != null) {


                                    pesquisador.setDepartamento(departamento);


                                    pesquisador.setNome(JOptionPane.showInputDialog("Digite o nome do pesquisador"));
                                    pesquisador.setAtuacao(JOptionPane.showInputDialog("Digite a atuacao do pesquisador"));

                                    c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(JOptionPane.showInputDialog("Digite o dia do aniversario ")));
                                    c.set(Calendar.MONTH, Integer.parseInt(JOptionPane.showInputDialog("Digite o mes do aniversario ")));
                                    c.set(Calendar.YEAR, Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do aniversario ")));
                                    pesquisador.setAniversario(c);


                                    pesquisador.setSexo(JOptionPane.showInputDialog("Digite o sexo do Pesquisador"));
                                    pesquisador.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Digite o id do Departamento em qual está o pesquisador", 0.0)));

                                    endereco = new Endereco();
                                    endereco.setBairro(JOptionPane.showInputDialog("Digite o bairro"));
                                    endereco.setCidade(JOptionPane.showInputDialog("Digite a cidade"));
                                    endereco.setComplemento(JOptionPane.showInputDialog("Digite o complemento"));
                                    endereco.setLogradouro(JOptionPane.showInputDialog("Digite o lagradouro"));
                                    endereco.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da casa", 1)));
                                    pesquisador.setEndereco(endereco);

                                    try {
                                        ;
                                        pDAO.beginTransaction();
                                        pDAO.save(pesquisador);
                                        pDAO.commit();
                                        JOptionPane.showMessageDialog(null, pesquisador);

                                    } catch (IllegalStateException | PersistenceException e) {
                                        pDAO.rollBack();
                                        e.printStackTrace();
                                    } finally {
                                        pDAO.close();
                                    }
                                }


                                break;


                            //insere um Departamento
                            case '4':
                                    departamento = new Departamento();


                                    String nome = JOptionPane.showInputDialog("Digite o Nome do Departamento");
                                    int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do Departamento"));

                                    departamento.setNome(nome);
                                    departamento.setNumero(numero);

                                    try {
                                        dDAO.beginTransaction();
                                        dDAO.save(departamento);
                                        dDAO.commit();
                                        JOptionPane.showMessageDialog(null, departamento);

                                    } catch (IllegalStateException | PersistenceException e) {
                                        dDAO.rollBack();
                                        e.printStackTrace();
                                    } finally {
                                        dDAO.close();
                                    }


                                break;

                            //dependente
                            case '5':

                                    dependente = new Dependente();

                                    dependente.setFuncionario(pDAO.find(2));


                                    dependente.setNome(JOptionPane.showInputDialog("Digite o nome "));
                                    dependente.setSexo(JOptionPane.showInputDialog("Digite a sexo"));

                                    c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(JOptionPane.showInputDialog("Digite o dia do aniversario ")));
                                    c.set(Calendar.MONTH, Integer.parseInt(JOptionPane.showInputDialog("Digite o mes do aniversario ")));
                                    c.set(Calendar.YEAR, Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do aniversario ")));
                                    dependente.setAniversario(c);


                                    dependente.setGrau(JOptionPane.showInputDialog("Digite o grau de parentesco"));



                                    try {
                                        ;
                                        depDao.beginTransaction();
                                        depDao.save(dependente);
                                        depDao.commit();
                                        JOptionPane.showMessageDialog(null, dependente);

                                    } catch (IllegalStateException | PersistenceException e) {
                                        depDao.rollBack();
                                        e.printStackTrace();
                                    } finally {
                                        depDao.close();
                                    }



                                break;
                             //projeto
                            case '6':
                                projeto = new Projeto();


                                int idDep2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do departamento para inserir uma pesquisa", 1));
                                departamento = dDAO.find(idDep2);
                                JOptionPane.showMessageDialog(null, departamento == null ? "Nenhum Departamento encontrado" : departamento);

                                if(departamento  != null) {
                                    projeto.setDepartamento(departamento);
                                    projeto.setNome(JOptionPane.showInputDialog("Digite o nome "));
                                    projeto.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o numero")));

                                    c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(JOptionPane.showInputDialog("Digite o dia do incio ")));
                                    c.set(Calendar.MONTH, Integer.parseInt(JOptionPane.showInputDialog("Digite o mes do inicio ")));
                                    c.set(Calendar.YEAR, Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do inicio ")));
                                    projeto.setDataInicio(c);

                                    c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(JOptionPane.showInputDialog("Digite o dia do fim ")));
                                    c.set(Calendar.MONTH, Integer.parseInt(JOptionPane.showInputDialog("Digite o mes do fim ")));
                                    c.set(Calendar.YEAR, Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do fim ")));
                                    projeto.setDataFim(c);


                                    try {

                                        projDao.beginTransaction();
                                        projDao.save(projeto);
                                        projDao.commit();
                                        JOptionPane.showMessageDialog(null, projeto);

                                    } catch (IllegalStateException | PersistenceException e) {
                                        projDao.rollBack();
                                        e.printStackTrace();
                                    } finally {
                                        projDao.close();
                                    }
                                }
                                break;
                            //pesquisas
                            case '7':
                                pesquisas = new Pesquisas();



                                    pesquisas.setProjeto(projDao.find(2));
                                    pesquisas.setPesquisador(pDAO.find(2));

                                    pesquisas.setHoras(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de hora ")));



                                    try {

                                        pesqDao.beginTransaction();
                                        pesqDao.save(pesquisas);
                                        pesqDao.commit();
                                        JOptionPane.showMessageDialog(null, pesquisas);

                                    } catch (IllegalStateException | PersistenceException e) {
                                        pesqDao.rollBack();
                                        e.printStackTrace();
                                    } finally {
                                        pesqDao.close();
                                    }


                                break;
                            //supervisor limpeza
                            case '8':
                                limpeza = new Limpeza();


                                   limpeza = lDAO.find(7);
                                   limpeza.setSupervisor(lDAO.find(10));

                                    try {
                                        ;
                                        lDAO.beginTransaction();
                                        lDAO.save(limpeza);
                                        lDAO.commit();
                                        JOptionPane.showMessageDialog(null, limpeza);

                                    } catch (IllegalStateException | PersistenceException e) {
                                        lDAO.rollBack();
                                        e.printStackTrace();
                                    } finally {
                                        lDAO.close();
                                    }

                                break;


                            case '9':
                                break;


                            default:
                                JOptionPane.showMessageDialog(null, "Opção Inválida");
                                break;
                        }

                    } while (opcaob != '9');
                    break;
//--------------------------------------------------------------------------------------------------------------


                case '2':// Menu de Remocoes

                    submenu = "Escolha uma opção:\n1 - Remover Secretario\n2 - Remover Pesquisador\n3 - Remover Limpeza\n4 -Remover Departamento\n" +
                            "5 - Remover Pesquisas\n6 - Remover Dependentes\n7 - Remover Projeto\n8 - Sair";
                    JOptionPane.showMessageDialog(null, "Essa acao pode remover tudo vinculado !!");
                    do {

                        opcaob = JOptionPane.showInputDialog(submenu).charAt(0);
                        switch (opcaob) {
                            // remove Secretario
                            case '1':
                                Secretario sRemove = secDao.find(Integer.parseInt(JOptionPane.showInputDialog("Digite o Nome do Secretario")));

                                try {
                                    secDao.beginTransaction();
                                    secDao.delete(sRemove);
                                    secDao.commit();
                                } catch (IllegalStateException | PersistenceException e) {
                                    secDao.rollBack();
                                    e.printStackTrace();
                                } finally {
                                    pDAO.close();
                                }
                                break;
                            // remove Pesquisador
                            case '2':

                                Pesquisador pRemove = pDAO.find(Integer.parseInt(JOptionPane.showInputDialog("Digite o Nome do Pesquisador")));

                                try {
                                    pDAO.beginTransaction();
                                    pDAO.delete(pRemove);
                                    pDAO.commit();
                                } catch (IllegalStateException | PersistenceException e) {
                                    pDAO.rollBack();
                                    e.printStackTrace();
                                } finally {
                                    pDAO.close();
                                }

                                break;

                            case '3':// remove Limpeza
                                Limpeza lRemove = lDAO.find(Integer.parseInt(JOptionPane.showInputDialog("Digite o Nome do Limpeza")));

                                try {
                                    lDAO.beginTransaction();
                                    lDAO.delete(lRemove);
                                    lDAO.commit();
                                } catch (IllegalStateException | PersistenceException e) {
                                    lDAO.rollBack();
                                    e.printStackTrace();
                                } finally {
                                    lDAO.close();
                                }
                                break;

                            case '4':
                                Departamento dRemove = dDAO.find(Integer.parseInt(JOptionPane.showInputDialog("Digite o Nome do Departamento")));

                                try {
                                    dDAO.beginTransaction();
                                    dDAO.delete(dRemove);
                                    dDAO.commit();
                                } catch (IllegalStateException | PersistenceException e) {
                                    dDAO.rollBack();
                                    e.printStackTrace();
                                } finally {
                                    dDAO.close();
                                }
                                break;
                            case '5':
                                Pesquisas pesqRemove = pesqDao.find(Integer.parseInt(JOptionPane.showInputDialog("Digite o Nome da Pesquisa")));

                                try {
                                    pesqDao.beginTransaction();
                                    pesqDao.delete(pesqRemove);
                                    pesqDao.commit();
                                } catch (IllegalStateException | PersistenceException e) {
                                    pesqDao.rollBack();
                                    e.printStackTrace();
                                } finally {
                                    pesqDao.close();
                                }
                                break;

                            case '6':
                                Dependente depenRemove = depDao.find(Integer.parseInt(JOptionPane.showInputDialog("Digite o Nome do Dependente")));

                                try {
                                    depDao.beginTransaction();
                                    depDao.delete(depenRemove);
                                    depDao.commit();
                                } catch (IllegalStateException | PersistenceException e) {
                                    depDao.rollBack();
                                    e.printStackTrace();
                                } finally {
                                    depDao.close();
                                }
                                break;

                            case '7':
                                Projeto projRemove = projDao.find(Integer.parseInt(JOptionPane.showInputDialog("Digite o Nome do Dependente")));

                                try {
                                    projDao.beginTransaction();
                                    projDao.delete(projRemove);
                                    projDao.commit();
                                } catch (IllegalStateException | PersistenceException e) {
                                    projDao.rollBack();
                                    e.printStackTrace();
                                } finally {
                                    projDao.close();
                                }
                                break;

                            case '8':
                                break;


                            default:
                                JOptionPane.showMessageDialog(null, "Opção Inválida");
                                break;
                        }

                    } while (opcaob != '8');

                    break;
//--------------------------------------------------------------------------------------------------------------


                case '3':


                    submenu = "Escolha uma opção:\n1 - Vizualizar Funcionarios por Nome\n2 - Vizualizar atuacao Pesquisador \n" +
                            "3 - Vizualizar o nome do departmento \n4 - Vizualizar consultas Limpeza \n5 -Vizualizar Lista de funcionarios em um Departamento " +
                            "\n 6 - Sair";

                    do {
                        StringBuilder listagem;
                        opcaob = JOptionPane.showInputDialog(submenu).charAt(0);
                        switch (opcaob) {
                            //findbypartenome
                            case '1':
                                List<Funcionario> secs = secDao.findByParteNome(JOptionPane.showInputDialog("Digite o nome ou Parte do nome de um Funcionario"));
                                listagem = new StringBuilder();

                                for(Funcionario f: secs) {
                                    listagem.append(f).append("\n");
                                }

                                JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum Funcionario encontrado" : listagem);
                                break;

                            //find by atuacao
                            case '2':


                                List<Pesquisador> pesqs = pDAO.findByAtuacao(JOptionPane.showInputDialog("Digite a atuacao  do Pesquisador"));
                                listagem = new StringBuilder();

                                for(Pesquisador f: pesqs) {
                                    listagem.append(f).append("\n");
                                }

                                JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum Pesquisador encontrado" : listagem);


                                break;
                            case '3':


                                    List<Departamento> deps = dDAO.findByNome(JOptionPane.showInputDialog("Digite o nome do Departamento"));
                                    listagem = new StringBuilder();
                                    for (Departamento dep : deps) {
                                        listagem.append(dep).append("\n");
                                    }
                                    JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum Departamento encontrado" : listagem);


                                break;


                            case '4':
                                List<Funcionario> limps = pDAO.findByNome(JOptionPane.showInputDialog("Digite o nome do Limpeza"));
                                listagem = new StringBuilder();
                                for(Funcionario f: limps) {
                                    listagem.append(f).append("\n");
                                }
                                JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum Limpeza encontrado" : listagem);

                                break;

                                //Departamento
                            case '5':

                                    departamento = dDAO.find(Integer.parseInt(JOptionPane.showInputDialog("Digite o id do Departamento ", 1)));
                                    JOptionPane.showMessageDialog(null, departamento == null ? "Nenhum Departamento encontrado" : departamento);

                                    if(departamento != null) {
                                        List<Funcionario> funcionarioList1 = dDAO.findFuncionarios(departamento);
                                        listagem = new StringBuilder();
                                        for (Funcionario f : funcionarioList1) {
                                            listagem.append(f).append("\n");
                                        }

                                        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum Funcionario encontrado" : listagem);


                                    }
                                    break;




                            case '6':

                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opção Inválida");
                                break;
                        }

                    } while (opcaob != '6');
                    break;

                case '4': // Sair
                    break;

                default:

                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                    break;
            }

        } while (opcao != '4');


    }

}

