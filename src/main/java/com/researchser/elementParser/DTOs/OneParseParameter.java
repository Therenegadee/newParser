package com.researchser.elementParser.DTOs;

public class OneParseParameter implements AbstractParseParameter {

    private String parameter;

    public OneParseParameter (String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }

}
