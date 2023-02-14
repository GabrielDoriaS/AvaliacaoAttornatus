package pessoas.attornatus.Api.attornatus.domain.pessoa;

import java.time.LocalDateTime;
import java.util.List;

import pessoas.attornatus.Api.attornatus.domain.endereco.Endereco;

public record DadosDetalhamentoPessoa(
    Long id,
    String nome,
    LocalDateTime dataNascimento,
    List<Endereco> enderecos
) {
    
    public DadosDetalhamentoPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(),pessoa.getDataNascimento(),pessoa.getEnderecos());
    }
}
