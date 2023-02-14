package pessoas.attornatus.Api.attornatus.domain.endereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarEndereco(
    @NotNull
    long id,
    String logradouro,
    String CEP,
    int numero,
    String cidade,
    boolean principal 
) {
    
}
