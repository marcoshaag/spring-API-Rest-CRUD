package med.voll.api.model.endereco;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @NotBlank
    private String logradouro;

    @NotBlank
    private String bairro;

    @NotBlank
    @Pattern(regexp = "\\d{8}")

    private String cep;

    private String numero;

    private String complemento;

    @NotBlank
    private String cidade;

    @NotBlank
    private String uf;

    public void atualizarInformacoes(Endereco dados) {
        if (dados.getLogradouro() != null) {
            this.logradouro = dados.getLogradouro();
        }
        if (dados.getBairro() != null) {
            this.bairro = dados.getBairro();
        }
        if (dados.getCep() != null) {
            this.cep = dados.getCep();
        }
        if (dados.getUf() != null) {
            this.uf = dados.getUf();
        }
        if (dados.getCidade() != null) {
            this.cidade = dados.getCidade();
        }
        if (dados.getNumero() != null) {
            this.numero = dados.getNumero();
        }
        if (dados.getComplemento() != null) {
            this.complemento = dados.getComplemento();
        }
    }
}
