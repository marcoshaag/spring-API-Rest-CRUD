package med.voll.api.model.infra.security.validar_requisicao;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.voll.api.model.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenKWT = recuperarToken(request);

        tokenService.pegarSubject(tokenKWT);

        filterChain.doFilter(request, response);
    }


    //recuperar token para poder logar e acessar api o mesmo é usada para o front;

    private String recuperarToken(HttpServletRequest request) {
        String authorizarHeader = request.getHeader("Authorization");
        if (authorizarHeader == null) {
            throw new RuntimeException("Token invalido");
        }

        return authorizarHeader.replace("Bearer ", "");
    }
}
