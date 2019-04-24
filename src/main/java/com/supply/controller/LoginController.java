package com.supply.controller;

import com.supply.core.KkbResponse;
import com.supply.core.KkbStatus;
import com.supply.domain.Form;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.KDCOptions;

@RestController
public class LoginController {

    @PostMapping("/login")
    public KkbResponse login(@RequestBody Form data) {
        if("shantong".equals(data.getUsername()) && "123".equals(data.getPassword())) {
            return new KkbResponse();
        }
        return new KkbResponse(KkbStatus.FAILURE);
    }
}
