package com.letsgosportscards.letsGo_api.Oauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthControler {
    @GetMapping("/")
    public String helloHello() {
        return "Hello Wolrd";
    }

        @GetMapping("letsgo//restricted")
        public String restricted() {
            return "To see this ypu need to log in";
        }
    }
