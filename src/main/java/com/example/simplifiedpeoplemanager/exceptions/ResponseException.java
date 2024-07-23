package com.example.simplifiedpeoplemanager.exceptions;

import java.util.Date;

public record ResponseException(
        Date timestamp,
        String message,
        String details) {
}
