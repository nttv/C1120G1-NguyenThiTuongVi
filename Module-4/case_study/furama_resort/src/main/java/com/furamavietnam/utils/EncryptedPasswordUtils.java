package com.furamavietnam.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptedPasswordUtils {

    // Encrypted Password with BCryptPasswordEncoder
    public static String encryptedPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "123";
        String encryptedPassword = encryptedPassword(password);

        System.out.println("Encrypted Password: " + encryptedPassword);
    }

}
