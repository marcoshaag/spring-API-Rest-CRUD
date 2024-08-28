package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.infra.dadosTokenJWT;
import med.voll.api.model.infra.security.TokenService;
import med.voll.api.model.usuario.DadosAutenticacao;
import med.voll.api.model.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {


    // tem que configurar no SecurityConfigurations
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    // processo para autenticar a senha e login, para authenticar esta no AutenticacaoService e o token TokenService
    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        Authentication token = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        Authentication authenticatin = manager.authenticate(token);

        String tokenJWT = tokenService.generateToken((Usuario) authenticatin.getPrincipal());
        return ResponseEntity.ok(new dadosTokenJWT(tokenJWT));
    }


}
