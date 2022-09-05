package com.solvd.lawyers;

import com.solvd.lawyers.characteristic.*;
import com.solvd.lawyers.parse.ReadXmlStAXParser;
import com.solvd.lawyers.worktime.VisitTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;

public class Main {

    private static final String FILENAME = "src/main/resources/lawyerOffice.xml";

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Address address = new Address("Spain", "Madrid", 10);
        LOGGER.info(address.getCountry() + " " + address.getCity() + " " + address.getHouseNumber());

        Address address1 = new Address("Belarus", "Paris", 12);
        Address address2 = new Address("Belarus", "London", 101);
        Address address3 = new Address("Belarus", "Brest", 148);
        Address address4 = new Address("Belarus", "Porto", 101);

        Lawyer lawyer1 = new Lawyer("Rachel Green", address1, LocalDate.of(1990, 6, 2));
        lawyer1.setRating(9);
        Lawyer lawyer2 = new Lawyer("Monica Geller", address2, LocalDate.of(1986, 12, 8));
        lawyer2.setRating(8);
        Lawyer lawyer3 = new Lawyer("John", address3, LocalDate.of(1990, 11, 1));
        lawyer3.setRating(7);
        Lawyer lawyer4 = new Lawyer("Nikita", address4, LocalDate.of(2000, 3, 4));
        lawyer4.setRating(10);
        Lawyer lawyer5 = new Lawyer("Valentin", address4, LocalDate.of(2001, 2, 1));
        lawyer5.setRating(4);

        List<Lawyer> lawyers = new ArrayList<>();
        lawyers.add(lawyer1);
        lawyers.add(lawyer2);
        lawyers.add(lawyer3);
        LOGGER.info("Lawyers size: " + lawyers.size());

        Staff staff = new Staff(lawyers);
        staff.showAllLawyers(lawyers);

        staff.allLawyersBirthdays(lawyers);

        LOGGER.info("Quantity of available lawyers: " + Lawyer.getQuantityLawyers());

        ClientCase divorce = new ClientCase("Divorce process");
        LocalDate prevDate1 = LocalDate.of(2021, 5, 15);
        divorce.caseWaiting(prevDate1);
        ClientCase aliments = new ClientCase("Aliments");
        LocalDate prevDate2 = LocalDate.of(2019, 8, 10);
        aliments.caseWaiting(prevDate2);

        Client client1 = new Client(divorce, BigDecimal.valueOf(1500));
        Client client2 = new Client(aliments, BigDecimal.valueOf(1350));

        LOGGER.info("----------------------------------");
        lawyer1.setSalary(BigDecimal.valueOf(150));

        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        VisitTime visitTime = new VisitTime(30, 2);
        LOGGER.info("Required time for the case: " + visitTime.totalMinutes() + " min");

        Service service1 = new Service(visitTime);
        Service service2 = new Service("ASAP");
        Service service3 = new Service("ASAP");

        List<Service> services = new ArrayList<>();
        services.add(service1);
        services.add(service2);
        services.add(service3);

        LawyerOffice redClearing = new LawyerOffice(address, staff, clients, services);

        LOGGER.info("----------------------------------");
        redClearing.startCase();
        redClearing.startCase(true);
        redClearing.setClients(clients);

        LOGGER.info("Quantity of clients: " + redClearing.countClients());
        LOGGER.info(redClearing.getAddress());

        LOGGER.info("----------------------------------");
        redClearing.setServices(services);
        redClearing.showServices();

        ZonedDateTime now = ZonedDateTime.now();
        LOGGER.info(now);

        LOGGER.info("----------------------------------");

        Address addressCourtHouse = new Address("Italy", "Rome", 100);
        CourtHouse courtHouse = new CourtHouse();
        courtHouse.bookCourtHouse(LocalDateTime.of(2022, 12, 1, 7, 30));

        LawyerOfficeUtils.getBetterLawyer(redClearing);

        LOGGER.info("----------------------------------");

        Address addressItaly = new Address("Italy", "Rome", 1);

        Set<Lawyer> lawyers1 = new HashSet<>();
        lawyers1.add(lawyer1);
        lawyers1.add(lawyer2);
        lawyers1.add(lawyer3);
        LOGGER.info(lawyers1);
        for(Lawyer lawyer : lawyers1) {
            LOGGER.info("Finished the University");
        }

        LOGGER.info("----------------------------------");

        Lawyer lawyer = new Lawyer("Joey", address1, LocalDate.of(1991, 6, 2));
        lawyer.setRating(9);

        Map<String, Client> schedule = new HashMap<>();
        redClearing.setSchedule(schedule);
        schedule.put(client1.getClientCase().getDescription(), client1);
        schedule.put(client2.getClientCase().getDescription(), client2);
        redClearing.showSchedule();

        courtHouse.setDayOfWeek(CourtHouse.DayOfWeek.SUNDAY);
        LOGGER.info(courtHouse.getDayOfWeek());

        if(courtHouse.getDayOfWeek() == CourtHouse.DayOfWeek.SATURDAY || courtHouse.getDayOfWeek() == CourtHouse.DayOfWeek.SUNDAY) {
            LOGGER.info("Courthouse is closed");
        } else {
            LOGGER.info("Courthouse is open");
        }

        try {
            ReadXmlStAXParser.printXml(Paths.get(FILENAME));
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}



