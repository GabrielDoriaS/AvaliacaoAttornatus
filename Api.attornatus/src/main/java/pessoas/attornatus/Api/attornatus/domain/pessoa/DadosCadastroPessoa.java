package pessoas.attornatus.Api.attornatus.domain.pessoa;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import pessoas.attornatus.Api.attornatus.domain.endereco.Endereco;

public record DadosCadastroPessoa(
    @NotBlank
    String nome,
    @NotBlank
    LocalDateTime dataNascimento,
    @NotBlank
    List<Endereco> enderecos
) {

    public DadosCadastroPessoa(Pessoa pessoa) {
        this(pessoa.getNome(),pessoa.getDataNascimento(),pessoa.getEnderecos());
    }

}
