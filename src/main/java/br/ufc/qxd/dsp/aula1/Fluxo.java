package br.ufc.qxd.dsp.aula1;

import java.io.*;
import java.util.Scanner;

public class Fluxo {

    private static final String ARQUIVO_READ = "/home/flycher/Documentos/intellij/persistencia/files/aula1_read.txt";
    private static final String ARQUIVO_WRITE = "/home/flycher/Documentos/intellij/persistencia/files/aula1_write.txt";
    private static final String ARQUIVO_EXERCICIO = "/home/flycher/Documentos/intellij/persistencia/files/aula1_exercicio.txt";

    private static void readWithBuffer() throws IOException {
        InputStream inputStream = new FileInputStream(ARQUIVO_READ);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        while (bufferedReader.ready()) {
            String s = bufferedReader.readLine();

            System.out.println(s);
        }

        bufferedReader.close();
    }

    private static void readWithScanner() throws IOException {

        try (Scanner scanner = new Scanner(new FileInputStream(ARQUIVO_READ))) {
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                System.out.println(s);
            }
        }
    }

    private static void writeWithBuffer() throws IOException {
        OutputStream outputStream = new FileOutputStream(ARQUIVO_WRITE, true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        bufferedWriter.write("Java");
        bufferedWriter.newLine();

        bufferedWriter.close();
    }

    private static void writeWithPrint() throws IOException {

        try (PrintStream printStream = new PrintStream(ARQUIVO_WRITE)) {
            printStream.println("Python");
        }
    }

    private static void readKeyboardWriteFile() throws IOException {
        InputStream inputStream = System.in;
        Scanner scanner = new Scanner(inputStream);

        PrintStream printStream = new PrintStream(ARQUIVO_EXERCICIO);

        String s;
        System.out.print("> ");
        s = scanner.nextLine();
        while (!s.isEmpty()) {
            printStream.println(s);
            System.out.print("> ");
            s = scanner.nextLine();
        }

        scanner.close();
        printStream.close();
    }

    public static void main(String[] args) {

        try {

//            readWithBuffer();
//            readWithScanner();
//
//            writeWithBuffer();
//            writeWithPrint();

            readKeyboardWriteFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
