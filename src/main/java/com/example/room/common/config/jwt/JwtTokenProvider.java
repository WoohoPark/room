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
import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final AuthUserService authUserService;

    private String HEADER_NAME = JwtProperties.HEADER_NAME;
    private String TOKEN_PREFIX = JwtProperties.TOKEN_PREFIX;
    private String SECRET_KEY = JwtProperties.SECRET;
    private long EXPIRED_TIME = JwtProperties.EXPIRED_TIME;

    private Key key;

    @PostConstruct
    protected void init(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String createToken(AuthUserDetails authUserDetails) {
        // TODO : authUserDetails null check
        return TOKEN_PREFIX+Jwts.builder()
                .setSubject(authUserDetails.getNickName())
                .claim("userName",authUserDetails.getUsername())
                .claim("userId",authUserDetails.getId())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRED_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

    }

    public String getNickname(String token){
        // TODO : 유효성검사
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
//        return Jwts.parser().setSigningKey(K).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest req){
        return req.getHeader(HEADER_NAME);
    }

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

    public Authentication getAuthentication(String token){
        AuthUserDetails userDetails = authUserService.loadUserByUsername(this.getNickname(token));
        return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }

    public String getHeaderName(){
        return HEADER_NAME;
    }
}
