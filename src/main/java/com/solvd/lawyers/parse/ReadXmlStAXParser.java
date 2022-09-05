package com.solvd.lawyers.parse;

import com.solvd.lawyers.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;

public class ReadXmlStAXParser {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void printXml(Path path) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        xmlInputFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        xmlInputFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");

        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(path.toFile()));

        // event iterator

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            if (event.isStartElement()) {
                StartElement element = event.asStartElement();

                switch (element.getName().getLocalPart()) {
                    case "address":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("Address : " + event.asCharacters().getData());
                        }
                        break;
                    case "country":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("Country : " + event.asCharacters().getData());
                        }
                        break;
                    case "city":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("City : " + event.asCharacters().getData());
                        }
                        break;
                    case "houseNumber":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("House number : " + event.asCharacters().getData());
                        }
                        break;
                    case "staff":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("Staff : " + event.asCharacters().getData());
                        }
                        break;
                    case "lawyers":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("Lawyers : " + event.asCharacters().getData());
                        }
                        break;
                    case "lawyer":
                        Attribute name = element.getAttributeByName(new QName("name"));
                        LOGGER.info("Lawyer name : " + name.getValue());
                        break;
                    case "birth":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("Birth : " + event.asCharacters().getData());
                        }
                        break;
                    case "dateOfBirth":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("DateOfBirth : " + event.asCharacters().getData());
                        }
                        break;
                    case "servicesList":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("Services : " + event.asCharacters().getData());
                        }
                        break;
                    case "service1":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("Service1 : " + event.asCharacters().getData());
                        }
                        break;
                    case "visitTime":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("Visit time : " + event.asCharacters().getData());
                        }
                        break;
                    case "minutes":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("Minutes : " + event.asCharacters().getData());
                        }
                        break;
                    case "hours":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("Hours : " + event.asCharacters().getData());
                        }
                        break;
                    case "service2":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("Service2 : " + event.asCharacters().getData());
                        }
                        break;
                    case "descriptionOfServices":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("Description of services : " + event.asCharacters().getData());
                        }
                        break;
                    case "service3":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("Service3 : " + event.asCharacters().getData());
                        }
                        break;
                    case "clientsList":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("ClientsList : " + event.asCharacters().getData());
                        }
                        break;
                    case "client1":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("Client1 : " + event.asCharacters().getData());
                        }
                        break;
                    case "clientCase":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("ClientCase : " + event.asCharacters().getData());
                        }
                        break;
                    case "description":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("Description : " + event.asCharacters().getData());
                        }
                        break;
                    case "money":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("Money : " + event.asCharacters().getData());
                        }
                        break;
                    case "client2":
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            LOGGER.info("Client2: " + event.asCharacters().getData());
                        }
                        break;
                }
            }

            if (event.isEndElement()) {
                EndElement endElement = event.asEndElement();
                // if </address>
                if (endElement.getName().getLocalPart().equals("lawyers")) {
                    System.out.printf("%n%s%n%n", "---");
                } else if (endElement.getName().getLocalPart().equals("lawyer")) {
                    System.out.printf("%n%s%n%n", "---");
                } else if (endElement.getName().getLocalPart().equals("servicesList")) {
                    System.out.printf("%n%s%n%n", "---");
                } else if (endElement.getName().getLocalPart().equals("clientsList")) {
                    System.out.printf("%n%s%n%n", "---");
                }
            }
        }
    }
}