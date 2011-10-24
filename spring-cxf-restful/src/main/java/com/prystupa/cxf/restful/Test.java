package com.prystupa.cxf.restful;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Test {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
