package com.adhocsensei.ahsedgeservice.exception;

import com.adhocsensei.ahsedgeservice.dto.User;

public class InvalidUserCredentialsException extends RuntimeException {
    public InvalidUserCredentialsException(User user) {super("Invalid username or password");}
}
