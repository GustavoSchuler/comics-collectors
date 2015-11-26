package br.feevale;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ControleMensagens {
	
	private String[] mensagens = { "As aves que aqui gorjeiam nao gorjeiam como l�",
								   "Quem no perigo vai no perigo perece",
								   "Quem com ferro fere com ferro ser� ferido",
								   "Pimenta nos olhos dos outros � col�rio",
								   "�gua morna em perna dura vale mais que dois voando" }; 
	private String mensagemDoDias;
	
	public ControleMensagens() {
		
		mensagemDoDias = mensagens[ (int) ( Math.random() * mensagens.length ) ];
	}
	
	public String getMensagemDoDias() {
		return mensagemDoDias;
	}
}