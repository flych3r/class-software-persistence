package br.ufc.qxd.dsp.aula1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Propriedades {

    private static final String PROPRIEDADES = "/home/flycher/Documentos/intellij/persistencia/files/propriedades.properties";

    private static Properties createProperties() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("aluno", "luis");
        properties.setProperty("faculdade", "ufc");
        properties.setProperty("salario", "10000");

        return properties;
    }

    private static void saveProperties() throws IOException {
        Properties properties = createProperties();
        properties.store(new FileOutputStream(PROPRIEDADES), "comentario");
    }

    private static void readProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(PROPRIEDADES));

        String aluno = properties.getProperty("aluno");
        String faculdade = properties.getProperty("faculdade");
        double salario = Double.parseDouble(properties.getProperty("salario"));

        System.out.println(aluno);
        System.out.println(faculdade);
        System.out.println(salario);

    }

    public static void main(String[] args) {
        try {
            saveProperties();
            readProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
