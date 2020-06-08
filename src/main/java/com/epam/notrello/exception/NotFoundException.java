package com.epam.notrello.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,
                reason = "It seems this page or resource does not exist.")
public class NotFoundException extends RuntimeException {
}
