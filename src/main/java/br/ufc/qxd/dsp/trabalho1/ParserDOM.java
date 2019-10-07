package br.ufc.qxd.dsp.trabalho1;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ParserDOM {

    private Document document;

    private static Element createLine(Line lineObj, Document doc) {

        Element line = doc.createElement("line");
        Attr id = doc.createAttribute("id");
        id.setValue(String.valueOf(lineObj.getId()));
        line.setAttributeNode(id);

        Element name = doc.createElement("name");
        name.appendChild(doc.createTextNode(lineObj.getName()));
        line.appendChild(name);

        Element urlName = doc.createElement("url_name");
        urlName.appendChild(doc.createTextNode(lineObj.getUrlName()));
        line.appendChild(urlName);

        Element color = doc.createElement("color");
        color.appendChild(doc.createTextNode(lineObj.getColor()));
        line.appendChild(color);

        Element city = doc.createElement("city");
        Attr cityId = doc.createAttribute("city_id");
        cityId.setValue(String.valueOf(lineObj.getCity().getId()));
        city.setAttributeNode(cityId);

        Element cityName = doc.createElement("city_name");
        cityName.appendChild(doc.createTextNode(lineObj.getCity().getName()));
        city.appendChild(cityName);

        Element coords = doc.createElement("coords");
        coords.appendChild(doc.createTextNode(lineObj.getCity().getCoords()));
        city.appendChild(coords);

        Element startYear = doc.createElement("start_year");
        startYear.appendChild(doc.createTextNode(String.valueOf(lineObj.getCity().getStartYear())));
        city.appendChild(startYear);

        Element urlCityName = doc.createElement("url_city_name");
        urlCityName.appendChild(doc.createTextNode(lineObj.getCity().getUrlName()));
        city.appendChild(urlCityName);

        Element country = doc.createElement("country");
        country.appendChild(doc.createTextNode(lineObj.getCity().getCountry()));
        city.appendChild(country);

        Element countryState = doc.createElement("country_state");
        countryState.appendChild(doc.createTextNode(lineObj.getCity().getCountryState()));
        city.appendChild(countryState);

        line.appendChild(city);

        return line;
    }

    void parse(String filePath) {

        File xmlFile = new File(filePath);

        try {

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(xmlFile);

            document.normalize();

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

    }

    public void createXML(List<Line> lines, String filePath) {

        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("lines");
            doc.appendChild(root);

            for (Line line : lines) {
                root.appendChild(createLine(line, doc));
            }

            TransformerFactory transformerFactory
                    = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result
                    = new StreamResult(filePath);
            transformer.setOutputProperty(OutputKeys.INDENT,
                    "yes");
            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount",
                    "4");
            transformer.transform(source, result);

            System.out.println("XML criado.");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

}

