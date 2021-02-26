package com.thoughtworks.capacity.gtb.mvc.error;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
