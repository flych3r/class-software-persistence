package br.ufc.qxd.dsp.trabalho1;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String ARQUIXO_XML = "/home/flycher/Documentos/intellij/persistencia/files/trabalho1/lines.xml";

        List<Line> lines = LinesParser.lines();

        ParserDOM parserDOM = new ParserDOM();
        parserDOM.createXML(lines, ARQUIXO_XML);

        ParserSAX parserSAX = new ParserSAX();
        parserSAX.parse(ARQUIXO_XML);
    }
}
