package br.ufc.qxd.dsp.trabalho1;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.List;

public class ReaderCSV {

    private List<String[]> allData = null;

    public List<String[]> getAllData() {
        return allData;
    }

    // Java code to illustrate reading a
    // all data at once
    public void readAll(String file, int start) {
        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);

            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(start).build();

            allData = csvReader.readAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] search(String column, String id) {
        int i = 0;
        for (String s : allData.get(0)) {
            if (s.equals(column))
                break;
            i++;
        }

        for (String[] linha : allData) {
            if (linha[i].equals(id))
                return linha;
        }

        return null;

    }

    public void showFile(int lines) {
        // print Data
        int actual = 0;
        for (String[] row : allData) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
            actual++;
            if (lines != 0 && actual > lines)
                break;
        }
    }

}
