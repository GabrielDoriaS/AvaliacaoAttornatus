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
import pessoas.attornatus.Api.attornatus.domain.pessoa.DadosAtualizarPessoa;
import pessoas.attornatus.Api.attornatus.domain.pessoa.DadosCadastroPessoa;
import pessoas.attornatus.Api.attornatus.domain.pessoa.DadosDetalhamentoPessoa;
import pessoas.attornatus.Api.attornatus.domain.pessoa.DadosListagemPessoa;
import pessoas.attornatus.Api.attornatus.domain.pessoa.ListarEnderecosDaPessoa;
import pessoas.attornatus.Api.attornatus.domain.pessoa.Pessoa;
import pessoas.attornatus.Api.attornatus.domain.pessoa.PessoaRepository;

@RestController
@RequestMapping("pessoa")
public class PessoaController {
    
    @Autowired
    private PessoaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder) {
        var pessoa = new Pessoa(dados);
        repository.save(pessoa);

        var uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPessoa(pessoa));
    }

    @GetMapping
    public ResponseEntity<DadosListagemPessoa> listar() {
        repository.findAll();
        return ResponseEntity.ok().body(null);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarPessoa dados) {
        var pessoa = repository.getReferenceById(dados.id());
        pessoa.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListarEnderecosDaPessoa> listarEnderecosDaPessoa(@PathVariable Long id) {
        repository.findById(id).map(ListarEnderecosDaPessoa::new);
        return ResponseEntity.ok().build();
    }

}
