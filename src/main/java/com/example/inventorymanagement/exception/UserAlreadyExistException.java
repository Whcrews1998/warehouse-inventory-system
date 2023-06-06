package com.example.inventorymanagement.exception;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String message) {super(message);}
}
