package com.example.individual_backend.Config;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class PasswordEncoderUtil {
    private static final BCryptPasswordEncoder PASSWORD_ENCODER=new BCryptPasswordEncoder();
    private PasswordEncoderUtil(){
        throw new IllegalStateException("utility class");
    }

    public static BCryptPasswordEncoder getInstance() {

        return PASSWORD_ENCODER;
    }
}
