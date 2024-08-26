package med.voll.api.medicos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.Endereco;

public record DadosCadastroMedicos(

        @NotBlank //para nao deixar vazio
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade,
        @NotNull @Valid // validar o que esta dentro de endereço
        Endereco endereco) {
}
