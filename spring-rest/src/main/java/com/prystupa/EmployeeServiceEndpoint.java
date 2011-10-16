package com.prystupa;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class EmployeeServiceEndpoint {

    @WebMethod
    public String getSix() {

        new HashCodeBuilder().toHashCode();
        new EqualsBuilder().isEquals();
        ToStringBuilder.reflectionToString(this);
        return "six";
    }


}
