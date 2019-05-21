package com.devop.password;

public interface PasswordService {
    String hash(String input);
    String algorithm();
}
