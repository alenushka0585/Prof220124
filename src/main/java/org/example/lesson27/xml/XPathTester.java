package org.example.lesson27.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

public class XPathTester {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        // DOM parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Document - дерево из элементов и атрибутов в памяти
        Document doc = builder.parse(new File("plants.xml"));
        // корневой элемент документа
        Element root = doc.getDocumentElement();

        /*
        /CATALOG
        //ZONE - все элементы ZONE в любом месте документа
        /CATALOG/PLANT - все элементы PLANT внутри CATALOG
        //MOVIE/ACTOR - все элементы ACTOR внутри элемента MOVIE
         */

        XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression expression = xPath.compile("//PLANT[@plantid='456']/PRICE");
        NodeList price = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);
        for (int i = 0; i < price.getLength(); i++) {
            System.out.println("price: " + price.item(i).getFirstChild().getTextContent());
        }
    }
}