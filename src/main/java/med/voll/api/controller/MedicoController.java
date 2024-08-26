package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medicos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastra(@RequestBody @Valid DadosCadastroMedicos dadosCadastroMedicos) {
        Medico medico = new Medico();
        medico.setNome(dadosCadastroMedicos.nome());
        medico.setEmail(dadosCadastroMedicos.email());
        medico.setCrm(dadosCadastroMedicos.crm());
        medico.setEndereco(dadosCadastroMedicos.endereco());
        medico.setEspecialidade(dadosCadastroMedicos.especialidade());

        medicoRepository.save(medico);
    }

    // Tipo uma lista, mas tem o Page(Paginação) e dentro dele é separada lista e objetos, por isso não se usa!
    @GetMapping("/lista")
    public Page<DadosListagemMedico> lista(Pageable paginacao) {
        return medicoRepository.findAll(paginacao).map(DadosListagemMedico::new);

    }


    // findAllByAtivoTrue method que o spring entendo usando as entidade
    @GetMapping()
    public Page<DadosListagemMedico> listarComAtivos(Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);

    }


    @GetMapping("/{id}")
    @Transactional
    public Medico buscar(@PathVariable Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicos dadosAtualizacaoMedicos){
        Medico medico = medicoRepository.getReferenceById(dadosAtualizacaoMedicos.id());
        medico.atualizarInformacoes(dadosAtualizacaoMedicos);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id){
        Medico medico = medicoRepository.findById(id).orElse(null);
        medico.setAtivo(Boolean.FALSE);
    }
}
