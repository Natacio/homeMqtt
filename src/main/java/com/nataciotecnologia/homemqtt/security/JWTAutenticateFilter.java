package com.nataciotecnologia.homemqtt.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nataciotecnologia.homemqtt.data.UseDetailData;
import com.nataciotecnologia.homemqtt.modules.user.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAutenticateFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public static final int TOKEN_EXPIRATION = 600_000;
    public static final String SECRET = "efd07a99-82e0-406a-be6b-3aa0d6860e04";

    public JWTAutenticateFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        UseDetailData useDetailData = (UseDetailData) authResult.getPrincipal();

        String token = JWT.create()
                .withSubject(useDetailData.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION) )
                .sign(Algorithm.HMAC512(SECRET));
        response.getWriter().write(token);
        response.getWriter().flush();
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response)
            throws AuthenticationException {

        try {
            User user = new ObjectMapper().readValue(request.getInputStream(),User.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getUsername(),
                    user.getPassword(),
                    new ArrayList<>()
            ));
        } catch (IOException e) {
            throw new RuntimeException("Falha na autencitação",e);
        }

    }
}
