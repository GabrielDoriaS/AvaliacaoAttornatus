package pessoas.attornatus.Api.attornatus.domain.endereco;

public record DadosDetalhamentoEndereco(
    long id,
    String logradouro,
    String CEP,
    int numero,
    String cidade,
    boolean principal 
) {
    public DadosDetalhamentoEndereco(Endereco endereco){
        this(endereco.getId(), endereco.getLogradouro(), endereco.getCEP(), endereco.getNumero(), endereco.getCidade(), endereco.isPrincipal());
    }
}
