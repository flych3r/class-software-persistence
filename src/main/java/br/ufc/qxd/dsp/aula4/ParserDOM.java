package br.ufc.qxd.dsp.aula4;

import org.w3c.dom.*;
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

class ParserDOM {

    private Document document;

    private static Element criaLivro(String titulo, int ano,
                                     String isbn, String editora,
                                     String edicao,
                                     String[] nomesAutores,
                                     String[] enderecosAutores,
                                     Document doc) {

        Element livro = doc.createElement("livro");
        Attr attrAno = doc.createAttribute("ano");
        attrAno.setValue(String.valueOf(ano));
        livro.setAttributeNode(attrAno);

        Element tagTitulo = doc.createElement("título");
        tagTitulo.appendChild(doc.createTextNode(titulo));
        livro.appendChild(tagTitulo);

        Element tagIsbn = doc.createElement("isbn");
        tagIsbn.appendChild(doc.createTextNode(isbn));
        livro.appendChild(tagIsbn);

        Element tagEditora = doc.createElement("editora");
        tagEditora.appendChild(doc.createTextNode(editora));
        livro.appendChild(tagEditora);

        Element tagEdicao = doc.createElement("edição");
        tagEdicao.appendChild(doc.createTextNode(edicao));
        livro.appendChild(tagEdicao);

        Element tagAutores = doc.createElement("autores");

        for (int k = 0; k < nomesAutores.length; k++) {
            Element tagAutor = doc.createElement("autor");
            Element tagNomeAutor = doc.createElement("nome");
            Element tagEnderecoAutor = doc.createElement("endereço");
            tagNomeAutor.appendChild(doc.createTextNode(nomesAutores[k]));
            tagEnderecoAutor.appendChild(doc.createTextNode(enderecosAutores[k]));
            tagAutor.appendChild(tagNomeAutor);
            tagAutor.appendChild(tagEnderecoAutor);
            tagAutores.appendChild(tagAutor);
        }

        livro.appendChild(tagAutores);

        return livro;
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

    public void createXML(String ARQUIVO_XML_SAIDA) {

        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("livros");
            doc.appendChild(root);

            Element livro1 = criaLivro("título 1", 1, "1",
                    "Editora 1", "1ª",
                    new String[]{"Fernanda", "Maryzangela"},
                    new String[]{"São Paulo", "Piquet Carneiro"},
                    doc);
            root.appendChild(livro1);

            Element livro2 = criaLivro("título 2", 2, "2",
                    "Editora 2", "2ª",
                    new String[]{"Victor"},
                    new String[]{"Juatama"},
                    doc);
            root.appendChild(livro2);

            Element livro3 = criaLivro("título 3", 3, "3",
                    "Editora 3", "3ª",
                    new String[]{"Ronier", "Erica", "Jean"},
                    new String[]{"Quixadá", "Quixeramobim", "Quixadá"},
                    doc);
            root.appendChild(livro3);

            TransformerFactory transformerFactory
                    = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result
                    = new StreamResult(ARQUIVO_XML_SAIDA);
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

    private void printTree(Node node, int depth) {


        if (node.getNodeType() == Node.TEXT_NODE) {
            if (!node.getNodeValue().trim().isEmpty()) {
                System.out.println(node.getNodeValue());
            }
            return;
        }

        for (int i = 0; i < depth; i++)
            System.out.print("\t");
        System.out.print(node.getNodeName() + ": ");

        NamedNodeMap attributes = node.getAttributes();
        int qtdAttributes = attributes.getLength();

        for (int i = 0; i < qtdAttributes; i++) {
            Node n = attributes.item(i);
            System.out.println(n.getNodeName() + " = " + n.getNodeValue());
        }

        NodeList children = node.getChildNodes();
        int qtdChildren = children.getLength();

        for (int i = 0; i < qtdChildren; i++) {
            printTree(children.item(i), depth + 1);
        }
    }

    void printTree() {
        printTree(document.getDocumentElement(), 0);
    }
}
