package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.usuario.DadosAutenticacao;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private AuthenticationManager manager;

    // processo para autenticar a senha e login
    @PostMapping
    public void efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        Authentication token = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        Authentication authenticatin = manager.authenticate(token);
    }


}
