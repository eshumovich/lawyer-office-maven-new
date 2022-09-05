package com.solvd.lawyers;

import com.solvd.lawyers.characteristic.Client;
import com.solvd.lawyers.characteristic.Service;
import com.solvd.lawyers.characteristic.Staff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class LawyerOffice  {

    private static final Logger LOGGER = LogManager.getLogger(LawyerOffice.class);

    private Address address;
    private Staff staff;
    private List<Service> services;
    private List<Client> clients;
    private Map<String, Client> schedule;

    public LawyerOffice(Address address, Staff staff, List<Client> clients, List<Service> services) {
        this.address = address;
        this.staff = staff;
        this.clients = clients;
        this.services = services;
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
            LOGGER.info("Client: " + " Name " + " " + client.getClientCase() );
            counter++;
        }
        return counter;
    }

    public void showServices() {
        for(Service service : services) {
            LOGGER.info("Show service: " + service.getDescriptionOfService());
        }
    }

    public void showSchedule() {
        for (Map.Entry<String, Client> entry : this.schedule.entrySet()) {
            LOGGER.info(entry.getKey() + "  :  " + entry.getValue());
        }
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
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

    public Map<String, Client> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, Client> schedule) {
        this.schedule = schedule;
    }
}

