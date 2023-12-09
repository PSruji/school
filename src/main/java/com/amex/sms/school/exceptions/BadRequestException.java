package com.amex.sms.school.exceptions;

/**
 * @author Mayukha
 * Created on 08 Dec, 2023
 * @project school
 */
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
    public BadRequestException(){
        super("Bad Request");
    }

}
