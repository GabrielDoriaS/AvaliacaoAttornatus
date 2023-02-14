package pessoas.attornatus.Api.attornatus.domain.pessoa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pessoas.attornatus.Api.attornatus.domain.endereco.Endereco;

@Table(name = "pessoa")
@Entity(name = "pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDateTime dataNascimento;
    
    @OneToMany
    private List<Endereco> enderecos = new ArrayList<>();
    
    public Pessoa(DadosCadastroPessoa dados) {
    
        this.dataNascimento = dados.dataNascimento();
        this.nome = dados.nome();
        this.enderecos = (List<Endereco>) new Pessoa(dados.enderecos());
    }

    public Pessoa(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void atualizarInformacoes(DadosAtualizarPessoa dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.dataNascimento() != null) {
            this.dataNascimento = dados.dataNascimento();
        }
        if (dados.enderecos() != null) {
            this.enderecos = dados.enderecos();
        }
    }
   
}
