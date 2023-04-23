package checkpoint.entities;

//teste
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TB_USUARIO")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private Long id;
	private boolean ativo;
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
	private Boolean politicamenteExposto;
	private Double rendaMensal;
	private Double patrimonio;
	private LocalDate dataCadastro;
	private LocalDate dataAtualizacao;

	@OneToMany(mappedBy = "usuario")
	private List<ProdutoEntity> produtos;
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<PixEntity> chaves;
	@OneToOne(mappedBy = "usuario")
	@JoinColumn(name = "vl_saldo")
	private SaldoEntity saldo;

	public UsuarioEntity() {
	}

	public UsuarioEntity(Long id, boolean ativo, String nome, String email, String nomeMae, String senha, String telefone, LocalDate dataNascimento,
						 String enderecoCompleto, String cpf, String rg, Boolean politicamenteExposto, Double rendaMensal, Double patrimonio,
						 LocalDate dataCadastro, LocalDate dataAtualizacao, List<ProdutoEntity> produtos, List<PixEntity> chaves, SaldoEntity saldo) {
		this.id = id;
		this.ativo = ativo;
		this.nome = nome;
		this.email = email;
		this.nomeMae = nomeMae;
		this.senha = senha;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.enderecoCompleto = enderecoCompleto;
		this.cpf = cpf;
		this.rg = rg;
		this.politicamenteExposto = politicamenteExposto;
		this.rendaMensal = rendaMensal;
		this.patrimonio = patrimonio;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
		this.produtos = produtos;
		this.chaves = chaves;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public Boolean getPoliticamenteExposto() {
		return politicamenteExposto;
	}

	public void setPoliticamenteExposto(Boolean politicamenteExposto) {
		this.politicamenteExposto = politicamenteExposto;
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

	public List<ProdutoEntity> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoEntity> produtos) {
		this.produtos = produtos;
	}

	public List<PixEntity> getChaves() {
		return chaves;
	}

	public void setChaves(List<PixEntity> chaves) {
		this.chaves = chaves;
	}

	public SaldoEntity getSaldo() {
		return saldo;
	}

	public void setSaldo(SaldoEntity saldo) {
		this.saldo = saldo;
	}
}
