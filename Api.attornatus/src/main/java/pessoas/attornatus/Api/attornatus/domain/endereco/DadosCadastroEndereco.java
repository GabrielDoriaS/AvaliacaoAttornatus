package pessoas.attornatus.Api.attornatus.domain.endereco;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroEndereco(
    @NotBlank
    String logradouro,
    
    @NotBlank
    String CEP,
    int numero,
    
    @NotBlank
    String cidade,
    
    boolean principal 
) {
    
}
