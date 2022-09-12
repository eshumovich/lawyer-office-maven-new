package com.solvd.lawyers.parse;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

public class LocalDateAdapterJaxb extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String localDate) throws Exception {
        return LocalDate.parse(localDate);
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return localDate.toString();
    }
}
