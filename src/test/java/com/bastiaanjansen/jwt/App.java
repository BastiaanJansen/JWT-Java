package com.bastiaanjansen.jwt;

import com.bastiaanjansen.jwt.Algorithms.Algorithm;
import com.bastiaanjansen.jwt.Exceptions.JWTException;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;

public class App {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048, new SecureRandom());
        KeyPair pair = keyPairGenerator.generateKeyPair();

        Algorithm algorithm = Algorithm.HMAC512("secret");
        JWT.Builder builder = new JWT.Builder(algorithm);

        Calendar now = Calendar.getInstance();
        now.add(Calendar.SECOND, -10);

        builder
                .withIssuer("issuer")
                .withAudience("audience", "audience2")
                .withID("id")
                .withIssuedAt(new Date())
                .withNotBefore(now.getTime())
                .withClaim("username", "BastiaanJansen")
                .withHeader("test", "test");

        try {
            JWT jwt = builder.build();

//            JWT newJWT = JWT.fromRawJWT(algorithm, "eyJhbGciOiJIUzM4NCIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJpc3N1ZXIiLCJhdWQiOiJhdWRpZW5jZSIsImlhdCI6MTYxNDY3NjkyNjE3MiwianRpIjoiaWQifQ.ibsMduBXhE8Y1TkDAazH-J7BaAtcJTcwmHfzvQg9EWS6uKZFsA_7z4LYtSa-nnR1");

            jwt.validate();
//
//            System.out.println(jwt.sign());
//
//            JWTValidator verifier = new DefaultJWTValidator.Builder()
//                    .withType("JWT")
//                    .withNotBefore(now.getTime())
//                    .withOneOfAudience("audience")
//                    .withClaim("username", "BastiaanJansen"::equals)
//                    .withHeader("test", "test"::equals)
//                    .build();
//            verifier.validate(jwt);
//
//            Payload payload = jwt.getPayload();

        } catch (JWTException e) {
            e.printStackTrace();
        }
    }
}
