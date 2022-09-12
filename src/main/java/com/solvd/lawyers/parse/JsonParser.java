package com.solvd.lawyers.parse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.lawyers.LawyerOffice;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonParser implements IParse {

    @Override
    public LawyerOffice parse(String fileName) {
        LawyerOffice lawyerOffice;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            lawyerOffice = objectMapper.readValue(Paths.get(fileName).toFile(), LawyerOffice.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lawyerOffice;
    }
}
