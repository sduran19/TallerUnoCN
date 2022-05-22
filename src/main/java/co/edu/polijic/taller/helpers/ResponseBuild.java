package co.edu.polijic.taller.helpers;

import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Component
public class ResponseBuild {

    public co.com.helpers.Response success() {
        return co.com.helpers.Response.builder()
                .data(OK)
                .code(OK.value()).build();
    }

    public co.com.helpers.Response success(Object data) {
        return co.com.helpers.Response.builder()
                .data(data)
                .code(OK.value()).build();
    }

    public co.com.helpers.Response created(Object data) {
        return co.com.helpers.Response.builder()
                .data(data)
                .code(CREATED.value()).build();
    }

    public co.com.helpers.Response failed(Object data) {
        return co.com.helpers.Response.builder()
                .data(data)
                .code(BAD_REQUEST.value()).build();
    }

    public co.com.helpers.Response notFound() {
        return co.com.helpers.Response.builder()
                .data(NOT_FOUND)
                .code(NOT_FOUND.value()).build();
    }



}
