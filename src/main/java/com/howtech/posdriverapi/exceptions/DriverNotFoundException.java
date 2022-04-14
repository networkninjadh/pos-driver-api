package com.howtech.posdriverapi.exceptions;

/**
 *
 * @author Damond Howard
 * @apiNote Exception to be thrown when a driver is not found in the database
 *
 */
public class DriverNotFoundException extends RuntimeException {

    private final String ERROR_MESSAGE;

    public DriverNotFoundException(Long id) {
        ERROR_MESSAGE = "There is no drier found with id " + id;
    }

    public DriverNotFoundException(String username) {
        ERROR_MESSAGE = "There is no driver found with username " + username;
    }

    @Override
    public String toString() {
        return ERROR_MESSAGE;
    }
}
