package model;

public class Fornecedor {
	private String cnpj;
	private Integer id;
	private String nomeFantasia;
	private String nomeEmpresarial;
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getNomeEmpresarial() {
		return nomeEmpresarial;
	}
	public void setNomeEmpresarial(String nomeEmpresarial) {
		this.nomeEmpresarial = nomeEmpresarial;
	}
	@Override
	public String toString() {
		return "Fornecedor [cnpj=" + cnpj + ", id=" + id + ", nomeFantasia="
				+ nomeFantasia + ", nomeEmpresarial=" + nomeEmpresarial + "]";
	}
}
