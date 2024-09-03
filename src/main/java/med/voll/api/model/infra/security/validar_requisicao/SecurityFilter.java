package med.voll.api.model.infra.security.validar_requisicao;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.voll.api.model.infra.security.TokenService;
import med.voll.api.model.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenKWT = recuperarToken(request);

        // para liberar acesso a outras api
        if(tokenKWT != null) {
           String email = tokenService.pegarSubject(tokenKWT);
           var usuario = usuarioRepository.findByLogin(email);

           UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }


    //recuperar token para poder logar e acessar api o mesmo é usada para o front;

    private String recuperarToken(HttpServletRequest request) {
        String authorizarHeader = request.getHeader("Authorization");
        if (authorizarHeader != null) {
            return authorizarHeader.replace("Bearer ", "");
        }
        return null;
    }
}
