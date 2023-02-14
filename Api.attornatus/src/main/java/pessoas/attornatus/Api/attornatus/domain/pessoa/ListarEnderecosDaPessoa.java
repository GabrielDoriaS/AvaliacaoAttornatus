package pessoas.attornatus.Api.attornatus.domain.pessoa;

import java.util.List;

import pessoas.attornatus.Api.attornatus.domain.endereco.Endereco;

public record ListarEnderecosDaPessoa(
    List<Endereco> enderecos
) {
    public ListarEnderecosDaPessoa(Pessoa pessoa) {
        this(pessoa.getEnderecos());
    }
}
