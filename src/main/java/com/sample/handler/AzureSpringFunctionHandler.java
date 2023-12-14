package com.sample.handler;

import java.io.IOException;
import java.util.Optional;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AzureSpringFunctionHandler {

    @FunctionName("testFunction")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req",
                    methods = {
                            HttpMethod.GET },
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    route = "app_health_monitoring/test")
            HttpRequestMessage<Optional<String>> request,
            ExecutionContext context) {
        return buildHttpResponseMessage(request, HttpStatus.ACCEPTED, "success", context);
    }

    private HttpResponseMessage buildHttpResponseMessage(HttpRequestMessage<Optional<String>> request, HttpStatus httpStatus, String payload, ExecutionContext context) {
        return request
                .createResponseBuilder(httpStatus)
                .body(payload)
                .build();
    }
  
}
