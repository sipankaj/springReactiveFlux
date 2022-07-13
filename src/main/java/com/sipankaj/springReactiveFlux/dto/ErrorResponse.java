package com.sipankaj.springReactiveFlux.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    int errorCode;
    String errorMessage;
}
