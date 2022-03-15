package com.hrp.springboot.model;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private final String msg;

    public AuthenticationResponse(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
