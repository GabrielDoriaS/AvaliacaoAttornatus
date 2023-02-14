package pessoas.attornatus.Api.attornatus.domain.endereco;

public record DadosListagemEndereco(
    String logradouro,
    String CEP,
    int numero,
    String cidade,
    boolean principal 
) {
    
}
