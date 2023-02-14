package pessoas.attornatus.Api.attornatus.domain.pessoa;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import pessoas.attornatus.Api.attornatus.domain.endereco.Endereco;

public record DadosAtualizarPessoa(
    @NotNull
    Long id,
    String nome,
    LocalDateTime dataNascimento,
    List<Endereco> enderecos
) {
    
}
