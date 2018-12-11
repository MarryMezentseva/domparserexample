package com.maria.examples;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomApp {

    private static final String FILE_PATH = "src\\main\\resources\\example1.xml";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File file = new File(FILE_PATH);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);

        doc.getDocumentElement().normalize();

        String s1 = doc.getDocumentElement().getNodeName();
        System.out.println(s1);

        NodeList nList = doc.getElementsByTagName("staff");
        System.out.println("Text content: " + doc.getElementsByTagName("staff").item(0).getTextContent());

        for (int i = 0; i <nList.getLength(); i++) {
            Node node = nList.item(i);
            System.out.println(node.getNodeName());
            NamedNodeMap namedNodeMap = node.getAttributes();
            for (int j = 0; j < namedNodeMap.getLength(); j++) {
                Node attrNode = namedNodeMap.item(j);
                System.out.println(((Attr)attrNode).getName() + "=" + ((Attr)attrNode).getValue());
            }
            System.out.println("--------------------------------");
            Element eElement = (Element) node;

            System.out.println(eElement.getAttribute("id"));
            System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
            System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
            System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
            System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
            System.out.println("Text content: " + eElement.getTextContent());

        }

        System.out.println();
    }



}
