package med.voll.api.model.medicos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.endereco.Endereco;

public record DadosAtualizacaoMedicos(

        @NotNull
        Long id,
        String nome,
        String email,
        Endereco endereco
) {
}
