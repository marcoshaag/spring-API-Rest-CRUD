package med.voll.api.model.medicos;

public record DadosListagemMedico(

        Long id,
        String nome,
        String email,
        Boolean ativo,
        Especialidade especialidade

) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getAtivo(), medico.getEspecialidade());

    }
}
