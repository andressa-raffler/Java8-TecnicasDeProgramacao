package com.LetsCode.A5RegularExpressions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexStudy {
        final String CPFREGEX = "([\\d]{3}.[\\d]{3}.[\\d]{3}-[\\d]{2})|([\\d]{11})";
        final String CNPJREGEX = "^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}-\\d{2}$|^\\d{14}$";

    @Test
    public void testName() {
        final String NOMEREGEX = "([a-zA-Z]*[\\s][a-zA-Z]*)";
        Pattern pattern = Pattern.compile("Andressa Raffler");
        Matcher matcher  = pattern.matcher(NOMEREGEX);
        assertTrue(matcher.matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {"11122211133","111.111.111-11"})
    public void validateCPF(String CPF) {
        Pattern pattern = Pattern.compile(CPFREGEX);
        Matcher matcher = pattern.matcher(CPF);
        assertTrue(matcher.matches());
    }

@ParameterizedTest
    @ValueSource(strings = {"12.324.543/0001-23"})
    public void validateCNPJ(String CNPJ){
        Pattern pattern = Pattern.compile(CNPJREGEX);
        Matcher matcher = pattern.matcher(CNPJ);
        assertTrue(matcher.matches());
}
}
