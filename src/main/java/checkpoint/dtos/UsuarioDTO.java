package checkpoint.dtos;

import java.time.LocalDate;

import checkpoint.entities.UsuarioEntity;

public class UsuarioDTO {

	private Long id;
	private String nome;
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

	public UsuarioDTO(Long id, String nome, String email, String nomeMae, String senha, String telefone,
			LocalDate dataNascimento, String enderecoCompleto, String cpf, String rg, Boolean politicamenteExposto,
			Double rendaMensal, Double patrimonio, LocalDate dataCadastro, LocalDate dataAtualizacao) {
		super();
		this.id = id;
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
	}

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(UsuarioEntity usuario) {
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.nomeMae = usuario.getNomeMae();
		this.senha = usuario.getSenha();
		this.telefone = usuario.getTelefone();
		this.dataNascimento = usuario.getDataNascimento();
		this.enderecoCompleto = usuario.getEnderecoCompleto();
		this.cpf = usuario.getCpf();
		this.rg = usuario.getRg();
		this.politicamenteExposto = usuario.getPoliticamenteExposto();
		this.rendaMensal = usuario.getRendaMensal();
		this.patrimonio = usuario.getPatrimonio();
		this.dataCadastro = usuario.getDataCadastro();
		this.dataAtualizacao = usuario.getDataAtualizacao();
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

	public Boolean getPep() {
		return politicamenteExposto;
	}

	public void setPep(Boolean politicamenteExposto) {
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

}
