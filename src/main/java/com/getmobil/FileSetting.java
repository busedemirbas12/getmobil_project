package com.getmobil;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class FileSetting {

    String FILE_NAME = "pom.xml";

    private String isRemot;
    private String environment;
    private final HashMap<String, String> xmlPropertyMap = new HashMap<>();

    public FileSetting() {
        getPropertyInXml();
        getConfigProp();
    }

    public void getPropertyInXml() {
        File pomXml = new File(FILE_NAME);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(pomXml);
            doc.getDocumentElement().normalize();

            Element properties = (Element) doc.getElementsByTagName("properties").item(0);

            Element isRemote = (Element) properties.getElementsByTagName("isRemote").item(0);
            Element environment2 = (Element) properties.getElementsByTagName("environment").item(0);

            isRemot = isRemote.getTextContent();
            environment = environment2.getTextContent();

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }


    public void getConfigProp() {
        try {
            String path = "config.properties";
            FileOutputStream outputStrem = new FileOutputStream(path);
            File file = new File("config.properties");
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.put("isRemote", isRemot);
            properties.put("environment", environment);
            properties.load(fileInput);
            properties.store(outputStrem, "This is a sample properties file");

            fileInput.close();
            Enumeration<Object> enuKeys = properties.keys();
            while (enuKeys.hasMoreElements()) {
                String key = (String) enuKeys.nextElement();
                String value = properties.getProperty(key);
                if (key.equals("environment")) {
                    if (value.equals("dev")) {
                        xmlPropertyMap.put(key, "https://dev.getmobil.com/");
                    } else if (value.equals("prod")) {
                        xmlPropertyMap.put(key, "https://getmobil.com/");
                    }
                } else {
                    xmlPropertyMap.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    /* -------------------------------- GETTER SETTER ----------------------------*/

    public HashMap<String, String> getXmlPropertyMap() {
        return xmlPropertyMap;
    }


}
