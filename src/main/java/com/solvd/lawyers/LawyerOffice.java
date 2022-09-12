package com.solvd.lawyers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.lawyers.characteristic.Client;
import com.solvd.lawyers.characteristic.Lawyer;
import com.solvd.lawyers.characteristic.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "lawyerOffice")
@XmlAccessorType(XmlAccessType.FIELD)
public class LawyerOffice {

    private static final Logger LOGGER = LogManager.getLogger(LawyerOffice.class);

    @XmlAttribute
    private String name;

    @XmlElementWrapper
    @XmlElement(name = "service")
    @JsonProperty("services")
    private List<Service> services;

    @XmlElementWrapper
    @XmlElement(name = "client")
    @JsonProperty("clients")
    private List<Client> clients;

    @XmlElementWrapper
    @XmlElement(name = "lawyer")
    @JsonProperty("lawyers")
    private List<Lawyer> lawyers;

    public LawyerOffice(List<Lawyer> lawyers, List<Client> clients, List<Service> services) {
        this.lawyers = lawyers;
        this.clients = clients;
        this.services = services;
    }

    public LawyerOffice() {
    }

    public void startCase() {
        LOGGER.info("Case waiting");
    }

    public void startCase(boolean lawyerAvailable) {
        LOGGER.info("Case waiting");
        if (lawyerAvailable) {
            LOGGER.info("Start case");
        }
    }

    public int countClients() {
        int counter = 0;
        for (Client client : clients) {
            LOGGER.info("Client: " + " Name " + " " + client.getClientCase());
            counter++;
        }
        return counter;
    }

    public void showServices() {
        for (Service service : services) {
            LOGGER.info("Show service: " + service.getDescriptionOfService());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lawyer> getLawyers() {
        return lawyers;
    }

    public void setLawyers(List<Lawyer> lawyers) {
        this.lawyers = lawyers;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "LawyerOffice{" +
                "name='" + name + '\'' +
                ", services=" + services +
                ", clients=" + clients +
                ", lawyers=" + lawyers +
                '}';
    }
}

