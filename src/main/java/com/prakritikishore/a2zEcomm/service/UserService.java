package com.prakritikishore.a2zEcomm.service;

import com.prakritikishore.a2zEcomm.model.User;

public interface UserService {

    User loadUserByUsername(String email);
}
