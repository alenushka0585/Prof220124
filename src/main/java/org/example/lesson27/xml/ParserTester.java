package org.example.lesson27.xml;

/*
    XML - Extensible Markup Language
    XML Schema - возможность проверки соответствия документа синтаксису
    XPath - возможность посылать запросы как в базу данных
    XSLT - для трансформации документа
    JAXB и SimpleXML - для аннотированияя полей класса для прозрачной сириализации
        объекта класса в xml документ и обратно
    Parser - специальная программа, которая служит для построения структуры документа
        DOM - Document Object Model - строится полное дерево по документу
        SAX - потоковый парсер - вызывает колбэки - не строит дерево
 */

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class ParserTester {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        // DOM parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Document - дерево из элементов и атрибутов в памяти
        Document doc = builder.parse(new File("plants.xml"));
        // корневой элемент документа
        Element root = doc.getDocumentElement();
        // набор узлов

        //список узлов с именем PRICE
        NodeList priceNodeList = root.getElementsByTagName("PRICE");
        for (int i = 0; i < priceNodeList.getLength(); i++) {
            Node priceNode = priceNodeList.item(i);
            System.out.println(
                    priceNode.getFirstChild().getTextContent()
            );
        }


        //список узлов с именем ZONE
        int sum = 0;
        NodeList zoneNodeList = root.getElementsByTagName("ZONE");
        for (int i = 0; i < zoneNodeList.getLength(); i++) {
            Node zoneNode = zoneNodeList.item(i);
            sum += Integer.parseInt(
                    zoneNode.getFirstChild().getTextContent()
            );
        }
        System.out.println(sum);

        // обращение к атрибуту по имени
        System.out.println(root.getAttribute("name"));
    }
}
