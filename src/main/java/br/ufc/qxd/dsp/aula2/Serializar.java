package br.ufc.qxd.dsp.aula2;

import java.io.*;

public class Serializar {

    private static final String PATH = "/home/flycher/Documentos/intellij/persistencia/files/";

    private static void serializeAndSave(Empregado empregado) throws IOException {

        OutputStream outputStream = new FileOutputStream(PATH + "empregado.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(empregado);

        objectOutputStream.close();

    }

    private static Empregado readAndDeserialize() throws IOException, ClassNotFoundException {

        InputStream inputStream = new FileInputStream(PATH + "empregado.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        Empregado empregado = (Empregado) objectInputStream.readObject();

        objectInputStream.close();

        return empregado;
    }

    public static void main(String[] args) {

        Empregado empregado = new Empregado("João", "Quixadá", 123, 526, true);

        try {
            System.out.println(empregado);
            serializeAndSave(empregado);

            Empregado empregado1 = readAndDeserialize();
            System.out.println(empregado1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
