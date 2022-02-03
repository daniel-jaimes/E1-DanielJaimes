package dao;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OutputDOM {
    private Document document;

    public OutputDOM(){
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factoria.newDocumentBuilder();
            document = builder.newDocument();
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }

    public Document getDocument() {
        return document;
    }

    public void generateXml(){
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Transformer transformer = factory.newTransformer();
            Source source = new DOMSource(document);
            PrintWriter pw = new PrintWriter("files/salida2.xml");
            Result result = new StreamResult(pw);
            transformer.transform(source, result);
        } catch (FileNotFoundException | TransformerException e) {
            System.out.println(e.getMessage());
        }
    }
}
