package com.betrybe.agrix.ebytr.staff.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

  private final Algorithm algorithm;

  public TokenService() {
    String secret = "secret";
    this.algorithm = Algorithm.HMAC256(secret);
  }

  public String validateToken(String token) {
    return JWT.require(algorithm)
        .withIssuer("agrixdb")
        .build()
        .verify(token)
        .getSubject();
  }

  public String generateToken(String username) {
    return JWT.create()
        .withSubject(username)
        .withExpiresAt(generateExpiration())
        .sign(algorithm);
  }

  private Instant generateExpiration() {
    return Instant.now()
        .plus(2, ChronoUnit.HOURS);
  }
}