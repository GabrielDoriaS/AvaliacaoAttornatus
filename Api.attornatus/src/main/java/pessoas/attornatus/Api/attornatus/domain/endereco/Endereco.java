package pessoas.attornatus.Api.attornatus.domain.endereco;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "endereco")
@Entity(name = "endereco")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {

    
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String CEP;
    private int numero ;
    private String cidade;
    private boolean principal;

   
    public Endereco(DadosCadastroEndereco dados) {
        this.logradouro = dados.logradouro();
        this.CEP = dados.CEP();
        this.numero = dados.numero();
        this.cidade = dados.cidade();
        this.principal = dados.principal();
    }


    public void atualizarInformacoes(DadosAtualizarEndereco dados) {
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.CEP() != null) {
            this.CEP = dados.CEP();
        }
        if (dados.numero() != 0) {
            this.numero = dados.numero();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (!dados.principal()) {
            this.principal = dados.principal();
        }

    }
    

    
}
