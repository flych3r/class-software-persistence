package br.ufc.qxd.dsp.trabalho1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LinesParser {

    public static List<Line> lines() {
        Map<Integer, City> cities = CitiesParser.cities();
        ReaderCSV reader = new ReaderCSV();
        reader.readAll("/home/flycher/Documentos/intellij/persistencia/files/trabalho1/lines.csv", 1);
        List<String[]> lines = reader.getAllData();
        List<Line> linesList = new ArrayList<Line>();

        for (String[] line : lines) {
            Integer id = Integer.parseInt(line[0]);
            Integer cityId = Integer.parseInt(line[1]);
            City city = cities.get(cityId);
            String name = line[2];
            String urlName = line[3];
            String color = line[4];

            Line newLine = new Line(id, city, name, urlName, color);
            linesList.add(newLine);

        }

        return linesList;

    }


}
