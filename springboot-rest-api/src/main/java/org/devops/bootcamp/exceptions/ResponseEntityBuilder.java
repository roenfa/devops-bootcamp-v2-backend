package org.devops.bootcamp.exceptions;

import lombok.Builder;
import org.springframework.http.ResponseEntity;

//@Builder
public class ResponseEntityBuilder {
    public static ResponseEntity<Object> build(ErrorResponse errorResponse) {
        return new ResponseEntity<>(errorResponse, errorResponse.getStatusCode());
    }
}
