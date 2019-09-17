package br.ufc.qxd.dsp.aula3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class TiposDeDados {

    private static final String EXEMPLO_HTTP = "https://example.com";
    private static final String ARQUIVO_LOCAL = "/home/flycher/Documentos/intellij/persistencia/files/teste.html";

    private static void ConexaoRemotaJsoup() {
        try {
            Document doc = Jsoup.connect(EXEMPLO_HTTP).get();

            String title = doc.title();

            System.out.println(title);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ConexaoLocalJsoup() {

        File file = new File(ARQUIVO_LOCAL);
        try {
            Document doc = Jsoup.parse(file, "UTF-8");
            Elements links = doc.select("a[href]");

            for (Element link : links) {
                System.out.println(link.attr("href"));
            }

            Elements imagens = doc.select("img[src$=.png]");
            for (Element imagem : imagens) {
                System.out.println(imagem);
            }

            Elements divs = doc.select("div.classe1");
            for (Element div : divs) {
                System.out.println(div);
            }

            // Element primeiraDivDaClasse2 = doc.selectFirst("div.classe2");
            Element primeiraDivDaClasse2 = doc.select("div.classe2").first();
            System.out.println(primeiraDivDaClasse2);

            Element div3 = doc.selectFirst("div#div3");
            String classeDiv3 = div3.attr("class");
            System.out.println(classeDiv3);

            Elements resultLinks = doc.select("h3.r > a");

            for (Element link : resultLinks) {
                System.out.println(link);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//         ConexaoRemotaJsoup();
        ConexaoLocalJsoup();
    }
}