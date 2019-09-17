package br.ufc.qxd.dsp.aula4;

public class XML {

    private static final String ARQUIVO_XML = "/home/flycher/Documentos/intellij/persistencia/files/livros.xml";
    private static final String ARQUIVO_XML_SAIDA = "/home/flycher/Documentos/intellij/persistencia/files/livros2.xml";

    private static ParserDOM parserDOM = new ParserDOM();

    private static ParserSAX parserSAX = new ParserSAX();

    public static void main(String[] args) {

        parserDOM.parse(ARQUIVO_XML);
        parserDOM.printTree();
//        parserSAX.parse(ARQUIVO_XML);
//        parserDOM.createXML(ARQUIVO_XML_SAIDA);
    }

}
