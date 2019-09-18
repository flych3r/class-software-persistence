package br.ufc.qxd.dsp.trabalho1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ParserJSON {

    public void saveJSON(List<Line> lines, String filePath) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), lines);
            System.out.println("Deu bom!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Line> readJSON(String filePath) {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Line>> mapType = new TypeReference<List<Line>>() {
        };
        try {
            return mapper.readValue(new File(filePath), mapType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}
