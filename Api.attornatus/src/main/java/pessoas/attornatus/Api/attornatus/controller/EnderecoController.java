package pessoas.attornatus.Api.attornatus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import pessoas.attornatus.Api.attornatus.domain.endereco.DadosAtualizarEndereco;
import pessoas.attornatus.Api.attornatus.domain.endereco.DadosCadastroEndereco;
import pessoas.attornatus.Api.attornatus.domain.endereco.DadosDetalhamentoEndereco;
import pessoas.attornatus.Api.attornatus.domain.endereco.DadosListagemEndereco;
import pessoas.attornatus.Api.attornatus.domain.endereco.Endereco;
import pessoas.attornatus.Api.attornatus.domain.endereco.EnderecoRepository;

@RestController
@RequestMapping("endereco")
public class EnderecoController {
    
    @Autowired
    private EnderecoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroEndereco dados, UriComponentsBuilder uriBuilder) {
        var endereco = new Endereco(dados);
        repository.save(endereco);

        var uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(endereco.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoEndereco(endereco));
    }

    @GetMapping
    public ResponseEntity<DadosListagemEndereco> listar() {
        repository.findAll();
        return ResponseEntity.ok().body(null);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarEndereco dados) {
        var endereco = repository.getReferenceById(dados.id());
        endereco.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoEndereco(endereco));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
