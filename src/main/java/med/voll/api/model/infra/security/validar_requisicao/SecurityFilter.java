package med.voll.api.model.infra.security.validar_requisicao;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenKWT = recuperarToken(request);

        System.out.println(tokenKWT);
        filterChain.doFilter(request, response);
    }


    //recuperar token para poder logar e acessar api o mesmo é usada para o front;

    private String recuperarToken(HttpServletRequest request) {
        var authorizarHeader = request.getHeader("Authorization");
        if (authorizarHeader == null) {
            throw new RuntimeException("Token invalido");
        }

        return authorizarHeader.replace("Bearer ", "");
    }
}
