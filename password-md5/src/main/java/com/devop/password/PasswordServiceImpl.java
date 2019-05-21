package com.devop.password;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class PasswordServiceImpl implements PasswordService {

    @Override
    public String hash(String input) {
        return m5(input);
    }

    @Override
    public String algorithm() {
        return "md5";
    }

    private String m5(String input) {
        StringBuilder result = new StringBuilder();
        MessageDigest md;

        try {
            md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
            for (byte b : hashInBytes) {
                result.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
