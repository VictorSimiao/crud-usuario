package br.com.victorreis.crud.config.validacao;

public class ErroDeFormularioDto {
	
	private String campo;
	private String mensagemErro;
	
	public ErroDeFormularioDto(String campo, String erro) {
		this.campo = campo;
		this.mensagemErro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}
	
	

}