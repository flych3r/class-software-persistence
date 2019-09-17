package br.ufc.qxd.dsp.trabalho1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CitiesParser {

    public static Map<Integer, City> cities() {
        ReaderCSV reader = new ReaderCSV();
        reader.readAll("/home/flycher/Documentos/intellij/persistencia/files/trabalho1/cities.csv", 1);
        List<String[]> cities = reader.getAllData();
        Map<Integer, City> citiesMap = new HashMap<Integer, City>();

        for(String[] city: cities) {
            Integer id;
            try {
                id = Integer.parseInt(city[0]);
            } catch (Exception e) {
                id = null;
            }
//            Integer id = Integer.parseInt(city[0]);
            String name = city[1];
            String coords = city[2];
            Integer startYear;
            try {
                startYear = Integer.parseInt(city[3]);
            } catch (Exception e) {
                startYear = null;
            }
            String urlName = city[4];
            String country = city[5];
            String countryState = city[6];

            City newCity = new City(id, name, coords, startYear, urlName, country, countryState);
            citiesMap.put(id, newCity);

        }

        return citiesMap;

    }


}
