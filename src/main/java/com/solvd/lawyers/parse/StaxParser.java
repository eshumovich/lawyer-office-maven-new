package com.solvd.lawyers.parse;

import com.solvd.lawyers.Address;
import com.solvd.lawyers.LawyerOffice;
import com.solvd.lawyers.Main;
import com.solvd.lawyers.characteristic.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StaxParser implements IParse {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    LawyerOffice lawyerOffice;
    Address address;
    List<Lawyer> lawyers = new ArrayList<>();
    List<Client> clients = new ArrayList<>();
    List<Service> services = new ArrayList<>();
    Lawyer lawyer;
    Client client;
    Service service;
    ClientCase clientCase;

    @Override
    public LawyerOffice parse(String fileName){
        try {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));

        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                switch (startElement.getName().getLocalPart()) {
                    case "lawyerOffice":
                        lawyerOffice = new LawyerOffice();
                        Attribute name = startElement.getAttributeByName(new QName("name"));
                        if (name != null) {
                            lawyerOffice.setName(name.getValue());
                        }
                        break;
                    case "address":
                        address = new Address();
                        lawyer.setAddress(address);
                        break;
                    case "lawyer":
                        lawyer = new Lawyer();
                        Attribute nameLawyer = startElement.getAttributeByName(new QName("name"));
                        if (nameLawyer != null) {
                            lawyer.setName(nameLawyer.getValue());
                        }
                        lawyerOffice.setLawyers(lawyers);
                        break;
                    case "client":
                        client = new Client();
                        lawyerOffice.setClients(clients);
                        break;
                    case "service":
                        service = new Service();
                        lawyerOffice.setServices(services);
                        break;
                    case "clientCase":
                        clientCase = new ClientCase();
                        client.setClientCase(clientCase);
                        break;
                    case "country":
                        nextEvent = reader.nextEvent();
                        address.setCountry(nextEvent.asCharacters().getData());
                        break;
                    case "city":
                        nextEvent = reader.nextEvent();
                        address.setCity(nextEvent.asCharacters().getData());
                        break;
                    case "houseNumber":
                        nextEvent = reader.nextEvent();
                        int houseNumber = Integer.parseInt(nextEvent.asCharacters().getData());
                        address.setHouseNumber(houseNumber);
                        break;
                    case "birthday":
                        nextEvent = reader.nextEvent();
                        String birthday = nextEvent.asCharacters().getData();
                        lawyer.setBirthday(LocalDate.parse(birthday));
                        break;
                    case "rating":
                        nextEvent = reader.nextEvent();
                        int rating = Integer.parseInt(nextEvent.asCharacters().getData());
                        lawyer.setRating(rating);
                        break;
                    case "salary":
                        nextEvent = reader.nextEvent();
                        String salaryContent = nextEvent.asCharacters().getData();
                        BigDecimal salary = new BigDecimal(salaryContent);
                        lawyer.setSalary(salary);
                        break;
                    case "descriptionOfService":
                        nextEvent = reader.nextEvent();
                        service.setDescriptionOfService(nextEvent.asCharacters().getData());
                        break;
                    case "description":
                        nextEvent = reader.nextEvent();
                        clientCase.setDescription(nextEvent.asCharacters().getData());
                        break;
                    case "money":
                        nextEvent = reader.nextEvent();
                        String moneyContent = nextEvent.asCharacters().getData();
                        BigDecimal money = new BigDecimal(moneyContent);
                        client.setMoney(money);
                        break;
                    default:
                        break;
                }
            }
            if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                if ("lawyer".equalsIgnoreCase(endElement.getName().getLocalPart())) {
                    lawyers.add(lawyer);
                } else if ("client".equalsIgnoreCase(endElement.getName().getLocalPart())) {
                    clients.add(client);
                } else if ("service".equalsIgnoreCase(endElement.getName().getLocalPart())) {
                    services.add(service);
                }
            }
        }
        } catch (FileNotFoundException | XMLStreamException e) {
            LOGGER.error(e);
        }
        return lawyerOffice;
    }
}