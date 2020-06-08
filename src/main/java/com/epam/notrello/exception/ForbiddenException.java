package com.epam.notrello.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN,
                reason = "Meow... it is forbidden resource.")
public class ForbiddenException extends RuntimeException {
}
