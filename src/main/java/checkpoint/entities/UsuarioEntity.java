package checkpoint.entities;
//teste
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_ck")

public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@Column(unique = true)
	private String email;
	private String nomeMae;
	private String senha;
	private String telefone;
	private LocalDate dataNascimento;
	private String enderecoCompleto;
	private String cpf;
	private String rg;
	private Boolean pep;
	private Double rendaMensal;
	private Double patrimonio;
	private LocalDate dataCadastro;
	private LocalDate dataAtualizacao;

	@OneToMany(mappedBy = "usuario")
	private List<ProdutoEntity> produtos;

	public UsuarioEntity() {
	}

	public UsuarioEntity(String nome, String email, String nomeMae, String senha, String telefone,
			LocalDate dataNascimento, String enderecoCompleto, String cpf, String rg, Boolean pep, Double rendaMensal,
			Double patrimonio, LocalDate dataCadastro, LocalDate dataAtualizacao, List<ProdutoEntity> produtos) {
		super();
		this.nome = nome;
		this.email = email;
		this.nomeMae = nomeMae;
		this.senha = senha;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.enderecoCompleto = enderecoCompleto;
		this.cpf = cpf;
		this.rg = rg;
		this.pep = pep;
		this.rendaMensal = rendaMensal;
		this.patrimonio = patrimonio;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
		this.produtos = produtos;
	}

	public List<ProdutoEntity> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoEntity> produtos) {
		this.produtos = produtos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}

	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(Double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public Double getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(Double patrimonio) {
		this.patrimonio = patrimonio;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Boolean getPep() {
		return pep;
	}

	public Boolean setPep(Boolean pep) {
		return this.pep = pep;
	}

}
