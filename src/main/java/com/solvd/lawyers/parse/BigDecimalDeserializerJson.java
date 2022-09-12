package com.solvd.lawyers.parse;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.math.BigDecimal;

public class BigDecimalDeserializerJson extends StdDeserializer<BigDecimal> {

    protected BigDecimalDeserializerJson() {
        super(BigDecimal.class);
    }

    @Override
    public BigDecimal deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return BigDecimal.valueOf(Long.parseLong(jsonParser.readValueAs(String.class)));
    }
}
