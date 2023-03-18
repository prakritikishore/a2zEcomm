package com.prakritikishore.a2zEcomm.service;

import com.prakritikishore.a2zEcomm.common.AuthenticationRequest;
import com.prakritikishore.a2zEcomm.common.AuthenticationResponse;
import com.prakritikishore.a2zEcomm.common.RegisterRequest;
import org.springframework.web.bind.annotation.RequestBody;


public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest registerRequest);

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

}
