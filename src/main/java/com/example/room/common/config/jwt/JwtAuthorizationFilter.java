package com.example.room.common.config.jwt;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.room.common.config.auth.AuthUserDetails;
import com.example.room.user.entity.User;
import com.example.room.user.repository.UserRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final String HEADER_NAME = JwtProperties.HEADER_NAME;
    private static final String TOKEN_PREFIX = JwtProperties.TOKEN_PREFIX;
    private static final String SECRET_KEY = JwtProperties.SECRET;
    private final UserRepository userRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager,
        UserRepository userRepository) {
        super(authenticationManager);
        this.userRepository = userRepository;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain chain)
        throws IOException, ServletException {

        String header = request.getHeader(HEADER_NAME);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        String token = request.getHeader(HEADER_NAME).replace(TOKEN_PREFIX, "");

        Claims claims = null;
        try {
            claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        } catch (SignatureException e) {
            throw new IllegalArgumentException("올바르지 않은 인증토큰입니다.");
        } catch (ExpiredJwtException e) {
            throw new IllegalArgumentException("토큰 인증기간이 만료되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO : NULL CHECK
        String nickName = (String) Objects.requireNonNull(claims).get("sub");

        Optional.ofNullable(nickName)
            .orElseThrow(() -> new IllegalArgumentException("해당 닉네임이 존재하지 않습니다."));

        User user = userRepository.findByNickName(nickName);

        AuthUserDetails authUserDetails = new AuthUserDetails(user);
        Authentication authentication =
            new UsernamePasswordAuthenticationToken(
                authUserDetails,
                null,
                authUserDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response);
    }
}
