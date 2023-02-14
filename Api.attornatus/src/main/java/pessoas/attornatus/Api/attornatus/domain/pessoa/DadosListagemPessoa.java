package pessoas.attornatus.Api.attornatus.domain.pessoa;

import java.time.LocalDateTime;
import java.util.List;

import pessoas.attornatus.Api.attornatus.domain.endereco.Endereco;

public record DadosListagemPessoa(
    String nome,
    LocalDateTime dataNascimento,
    List<Endereco> enderecos
) {
    
}
