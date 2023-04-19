package com.example.room.common.config.jwt;

import com.example.room.common.config.auth.AuthUserDetails;
import com.example.room.user.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
import java.io.InputStream;

@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper om = new ObjectMapper();

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        setFilterProcessesUrl(JwtProperties.LOGIN_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        log.info(" 로그인인증필터좀타라!!!!!!");

        // TODO : NULL CHECK
        UserDto userDto = new UserDto();

        try {
            InputStream inputStream = request.getInputStream();
            userDto = om.readValue(inputStream, UserDto.class);
        } catch (MismatchedInputException e) {
            throw new IllegalArgumentException("로그인 정보가 올바르게 입력되지 않았습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(
                                                            userDto.getId(),
                                                            userDto.getPassword());

        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        AuthUserDetails authUserDetails = (AuthUserDetails) authResult.getPrincipal();
        String bToken = jwtTokenProvider.createToken(authUserDetails);
        String header = jwtTokenProvider.getHeaderName();
        response.addHeader(header,bToken);
    }

}
