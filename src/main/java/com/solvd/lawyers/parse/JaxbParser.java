package com.solvd.lawyers.parse;

import com.solvd.lawyers.LawyerOffice;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbParser implements IParse {

    @Override
    public LawyerOffice parse(String fileName) {
        LawyerOffice lawyerOffice;
        File xmlFIle = new File(fileName);

        try {
            JAXBContext context = JAXBContext.newInstance(LawyerOffice.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            lawyerOffice = (LawyerOffice) unmarshaller.unmarshal(xmlFIle);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return lawyerOffice;
    }
}
