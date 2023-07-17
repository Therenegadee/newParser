package com.researchser.elementParser.htmlElementParser;

import com.researchser.elementParser.abstractInterfaces.AbstractParseParameter;

public class OneParseParameter implements AbstractParseParameter {

    private String parameter;

    public OneParseParameter (String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }

}
