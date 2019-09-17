package br.ufc.qxd.dsp.aula1;

import java.io.*;
import java.util.zip.ZipInputStream;

public class Compressao {

    private static final String ZIPADOS = "/home/flycher/Documentos/intellij/persistencia/files/zipados.zip";

    private static void readZipFile() throws IOException {

        InputStream inputStream = new FileInputStream(ZIPADOS);
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(zipInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        while (zipInputStream.getNextEntry() != null) {
            while (bufferedReader.ready())
                System.out.println(bufferedReader.readLine());
        }

        bufferedReader.close();

    }

    public static void main(String[] args) {
        try {
            readZipFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}