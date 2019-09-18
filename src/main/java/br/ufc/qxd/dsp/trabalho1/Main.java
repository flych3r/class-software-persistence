package br.ufc.qxd.dsp.trabalho1;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String ARQUIXO_XML = "/home/flycher/Documentos/intellij/persistencia/files/trabalho1/lines.xml";
        String ARQUIXO_JSON = "/home/flycher/Documentos/intellij/persistencia/files/trabalho1/lines.json";

        List<Line> lines = LinesParser.lines();

        ParserDOM parserDOM = new ParserDOM();
        parserDOM.createXML(lines, ARQUIXO_XML);

        ParserSAX parserSAX = new ParserSAX();
        List<Line> newLines = parserSAX.parse(ARQUIXO_XML);

        ParserJSON parserJSON = new ParserJSON();
        parserJSON.saveJSON(newLines, ARQUIXO_JSON);

        List<Line> newNewLines = parserJSON.readJSON(ARQUIXO_JSON);

        for(Line line: newNewLines)
            System.out.println(line);
    }
}
