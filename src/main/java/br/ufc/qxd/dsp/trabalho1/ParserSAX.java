package br.ufc.qxd.dsp.trabalho1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParserSAX extends DefaultHandler {

    private List<Line> lines = new ArrayList<Line>();
    private Stack<String> elements = new Stack<>();
    private Stack<Line> lineStack = new Stack<>();
    private Stack<City> cityStack = new Stack<>();

    public List<Line> parse(String filePath) {

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            saxParser.parse(filePath, this);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }

        return this.lines;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Inicio de documento.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fim de documento.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elements.push(qName);
        if (qName.equals("line")) {
            Line line = new Line();
            line.setId(Integer.parseInt(attributes.getValue("id")));
            lineStack.push(line);
            lines.add(line);
        }
        if (qName.equals("city")) {
            City city = new City();
            city.setId(Integer.parseInt(attributes.getValue("city_id")));
            cityStack.push(city);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (elements.peek().equals("city")) {
            Line line = lineStack.peek();
            line.setCity(cityStack.peek());
        }
        elements.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        if (value.length() == 0) {
            return;
        }

        if (currentElement().equals("name")) {
            Line line = lineStack.peek();
            line.setName(value);
        } else if (currentElement().equals("url_name")) {
            Line line = lineStack.peek();
            line.setUrlName(value);
        } else if (currentElement().equals("color")) {
            Line line = lineStack.peek();
            line.setColor(value);
        } else if (currentElement().equals("city_name")) {
            City city = cityStack.peek();
            city.setName(value);
        } else if (currentElement().equals("coords")) {
            City city = cityStack.peek();
            city.setCoords(value);
        } else if (currentElement().equals("start_year")) {
            City city = cityStack.peek();
            city.setStartYear(Integer.parseInt(value));
        } else if (currentElement().equals("url_city_name")) {
            City city = cityStack.peek();
            city.setUrlName(value);
        } else if (currentElement().equals("country")) {
            City city = cityStack.peek();
            city.setCountry(value);
        } else if (currentElement().equals("country_state")) {
            City city = cityStack.peek();
            city.setCountryState(value);
        }
    }

    private String currentElement() {
        return elements.peek();
    }
}
