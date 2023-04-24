package com.example.room.common.config.jwt;

import com.example.room.common.config.auth.AuthUserDetails;
import com.example.room.common.config.auth.AuthUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private Key key;

    @PostConstruct
    protected void init() {
        byte[] keyBytes = Decoders.BASE64.decode(JwtProperties.SECRET);
        key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String createToken(AuthUserDetails authUserDetails) {
        // TODO : authUserDetails null check
        return JwtProperties.TOKEN_PREFIX + Jwts.builder()
            .setSubject(authUserDetails.getNickName())
            .claim("userName", authUserDetails.getUsername())
            .claim("userId", authUserDetails.getId())
            .setExpiration(new Date(System.currentTimeMillis() + JwtProperties.EXPIRED_TIME))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();

    }

    // TODO : refresh Token 생성필요함.

//    public boolean validateToken(String jwtToken, HttpServletRequest req) {
//        try {
//            if (jwtToken.isEmpty()) throw new IllegalArgumentException("EMPTY");
//            //Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
//            return true;
//        } catch (Exception e) {
////            if (jwtToken.isEmpty()) {
////                req.setAttribute("exception", CustomExceptionStatus.EMPTY_JWT.getMessage());
////            }
////            else req.setAttribute("exception", CustomExceptionStatus.INVALID_JWT.getMessage());
////            return false;
//        }
//    }

}
