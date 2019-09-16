
package veiculosonline.database.entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {
    
    private Long id; 
    private String email;
    private String nome;
    private String senha;
    private String cpf;
    private Boolean tipo;
    private String conta;
    private String agencia;
    private String banco;
    private Date data_nasc;
    private String status;
    private String endereco;
    private String telefone;

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
   
    public void setId(Long id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public String getConta() {
        return conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getBanco() {
        return banco;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public String getStatus() {
        return status;
    }
    

    public Usuario() {
    }

    public Usuario(String email, String nome, String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
    
    //Sobrescrever o método 'toString' da classe permite personalizar o que vai ser impresso quando fizermos
    //System.out.println(guest);
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + '}';
    }
    
    
}