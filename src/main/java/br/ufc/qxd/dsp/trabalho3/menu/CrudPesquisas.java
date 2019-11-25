package br.ufc.qxd.dsp.trabalho3.menu;

import br.ufc.qxd.dsp.trabalho3.dao.PesquisadorDAO;
import br.ufc.qxd.dsp.trabalho3.dao.PesquisasDAO;
import br.ufc.qxd.dsp.trabalho3.dao.ProjetoDAO;
import br.ufc.qxd.dsp.trabalho3.dao.morphia.PesquisadorMorphiaDAO;
import br.ufc.qxd.dsp.trabalho3.dao.morphia.PesquisasMorphiaDAO;
import br.ufc.qxd.dsp.trabalho3.dao.morphia.ProjetoMorphiaDAO;
import br.ufc.qxd.dsp.trabalho3.model.Pesquisador;
import br.ufc.qxd.dsp.trabalho3.model.Pesquisas;
import br.ufc.qxd.dsp.trabalho3.model.Projeto;
import br.ufc.qxd.dsp.trabalho3.morphia.MorphiaUtil;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import javax.swing.*;
import java.util.List;

public class CrudPesquisas {
    private Pesquisas pesqs;
    private  final PesquisadorDAO pDao = new PesquisadorMorphiaDAO();
    private final ProjetoDAO projDao = new ProjetoMorphiaDAO();
    private final PesquisasDAO pesqsDao = new PesquisasMorphiaDAO();

    public CrudPesquisas() {
    }

    public void AddPesquisas() {
        String pesquisador = JOptionPane.showInputDialog("Digite o Nome do Pesquisador");
        String projeto = JOptionPane.showInputDialog("Digite o Nome do Projeto");

        Pesquisador pesq = (Pesquisador) pDao.findByNome(pesquisador, Pesquisador.class);
        Projeto proj =  projDao.findByNome(projeto);

        if (pesq != null && proj != null) {
            int horas = Integer.parseInt(JOptionPane.showInputDialog("Digite Quantidade de horas"));
            pesqs = new Pesquisas(proj, pesq, horas);
            pesqsDao.save(pesqs);
            JOptionPane.showMessageDialog(null, "Pesquisas Adicionado!!");
        } else {
            if(pesq == null) JOptionPane.showMessageDialog(null, "Pesquisas não existe!!");
            if(proj == null) JOptionPane.showMessageDialog(null, "Projeto não existe!!");
            return;
        }
    }
    public void UpdatePesquisas() {
        String pesquisador = JOptionPane.showInputDialog("Digite o Nome do Pesquisador");
        String projeto = JOptionPane.showInputDialog("Digite o Nome do Projeto");
        Pesquisador pesq = (Pesquisador) pDao.findByNome(pesquisador, Pesquisador.class);
        Projeto proj =  projDao.findByNome(projeto);

        Query<Pesquisas> query = MorphiaUtil.getDatastore().createQuery(Pesquisas.class)
                .field("pesqusador").equal(pesq).field("projeto").equal(proj);
        pesqs = query.get();
        boolean a = (pesqs != null);
        JOptionPane.showMessageDialog(null, a ? pesqs : "Nenhuma Pesquisa encontrado");

        if (a) {
            UpdateOperations<Pesquisas> updates = MorphiaUtil.getDatastore().createUpdateOperations(Pesquisas.class)
                    .set(JOptionPane.showInputDialog("Campo a ser atualizado"), JOptionPane.showInputDialog("Preencha"));
            MorphiaUtil.getDatastore().update(query, updates);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar!!");
            return;
        }
    }

    public void DeletePesquisas() {
        String pesquisador = JOptionPane.showInputDialog("Digite o Nome do Pesquisador");
        String projeto = JOptionPane.showInputDialog("Digite o Nome do Projeto");
        Pesquisador pesq = (Pesquisador) pDao.findByNome(pesquisador, Pesquisador.class);
        Projeto proj =  projDao.findByNome(projeto);
        if (pesq != null && proj != null) {
            Query<Pesquisas> query  = MorphiaUtil.getDatastore().createQuery(Pesquisas.class).field("pesquisador")
                    .equal(pesq)
                    .field("projeto")
                    .equal(proj);

            MorphiaUtil.getDatastore().delete(query);
            JOptionPane.showMessageDialog(null, "Apagado com sucesso");
        } else {
            if(pesq == null) JOptionPane.showMessageDialog(null, "Pesquisas não existe!!");
            if(proj == null) JOptionPane.showMessageDialog(null, "Projeto não existe!!");
            return;
        }
    }
    public void FindByHoras(int horas) {
        List<Pesquisas> pesqs = pesqsDao.findByHoras(horas);
        StringBuilder listagem = new StringBuilder();
        for (Pesquisas d : pesqs) {
            listagem.append(d).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Vazio" : listagem);
    }
}