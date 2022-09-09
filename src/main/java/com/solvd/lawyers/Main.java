package com.solvd.lawyers;

import com.solvd.lawyers.parse.JaxbParser;
import com.solvd.lawyers.parse.JsonParser;
import com.solvd.lawyers.parse.StaxParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final String FILENAME = "src/main/resources/lawyerOffice.xml";
    private static final String FILENAME_JSON = "src/main/resources/lawyerOffice.json";

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        StaxParser readXmlStAXParser = new StaxParser();
        LawyerOffice lawyerOffice = readXmlStAXParser.parse(FILENAME);
        LOGGER.info("STAX: " + lawyerOffice);

        JaxbParser jaxBParser = new JaxbParser();
        LawyerOffice lawyerOffice1 = jaxBParser.parse(FILENAME);
        LOGGER.info("JAXB: " + lawyerOffice1);

        JsonParser jsonParser = new JsonParser();
        LawyerOffice lawyerOffice2 = jsonParser.parse(FILENAME_JSON);
        LOGGER.info("JSON: " + lawyerOffice2);
    }
}



