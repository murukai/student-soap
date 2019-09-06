package com.afrikateck.studentsoap.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(
        faultCode = FaultCode.CUSTOM,
        customFaultCode = "{" + StudentNotFoundException.NAMESPACE_URI + "}custom_fault",
        faultStringOrReason = "@faultString"
)
public class StudentNotFoundException extends Exception{

  private static final long serialVersionUID = 1L;
  public static final String NAMESPACE_URI = "http://www.afrikatech.com/exception";

  public StudentNotFoundException(String message) {
    super(message);
  }
}
