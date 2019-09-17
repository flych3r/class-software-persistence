package br.ufc.qxd.dsp.aula1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercicio {

    private static final String PATH = "/home/flycher/Documentos/intellij/persistencia/files/";

    private static String[][] csvToMatrix() throws IOException {

        ArrayList<String[]> sample = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream(PATH + "mySample.csv"))) {
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                String[] str = s.split(",");
                sample.add(str);
            }
        }

        return sample.toArray(new String[][]{});
    }

    private static String[][] transposeMatrix(String[][] sample) {

        int l = sample.length;
        int c = sample[0].length;

        String[][] transposta = new String[c][l];

        for (int i = 0; i < l; i++)
            for (int j = 0; j < c; j++)
                transposta[j][i] = sample[i][j];

        return transposta;
    }

    private static void matrixToCsv(String[][] matrix) throws IOException {
        try (PrintStream printStream = new PrintStream(PATH + "transposed.csv")) {
            for (String[] row : matrix) {
                List<String> list_row = Arrays.asList(row);

                String new_row = String.join(",", list_row);

                printStream.println(new_row);
            }
        }
    }

    public static void main(String[] args) {
        try {
            String[][] sample = csvToMatrix();
            matrixToCsv(transposeMatrix(sample));

//            for(int i = 0; i < 5; i++) {
//                for(int j = 0; j < sample[i].length; j++)
//                    System.out.print(sample[i][j] + " ");
//                System.out.println();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
