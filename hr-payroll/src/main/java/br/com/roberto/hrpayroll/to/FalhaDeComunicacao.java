package br.com.roberto.hrpayroll.to;

public class FalhaDeComunicacao {

	private String mensagem;
	private String descricao;

	public FalhaDeComunicacao(String mensagem, String descricao) {
		this.mensagem = mensagem;
		this.descricao = descricao;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
