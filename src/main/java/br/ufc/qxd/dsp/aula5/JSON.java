package br.ufc.qxd.dsp.aula5;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSON {

    private static final String ARQUIVO_JSON = "/home/flycher/Documentos/intellij/persistencia/files/contatos.json";

    private static void saveJSON() {

        List<Contato> contatos = new ArrayList<Contato>();
        contatos.add(new Contato(1, "Mauricio", "mauricio@ufc.br"));
        contatos.add(new Contato(2, "Mary", "mary@gmail.com"));
        contatos.add(new Contato(3, "Kelly", "kelly@hotmail.com"));

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(ARQUIVO_JSON), contatos);
            System.out.println("Deu bom!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readJSON() {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Contato>> mapType = new TypeReference<List<Contato>>() {
        };
        try {
            List<Contato> contatos = mapper.readValue(new File(ARQUIVO_JSON), mapType);

            for (Contato c : contatos) {
                System.out.println(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        saveJSON();
        readJSON();
        /*
            Criar classe endereço com rua, bairro e número.
            Adicionar atributo do tipo endereço a contato.
            Adicionar atributo telefones (lista de strings) a contato.
            Criar contatos preenchendo todas as informações, salvando e lendo em json.
        */
    }

}
