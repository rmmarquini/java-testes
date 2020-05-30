package br.unicamp.ic.inf318.labs;

public class PacotesConta implements TiposConta {

	public static String tipoConta;
	public static int qtdeMaxLanc;
	public static float mensalidade;
	public static float custoConsulta;
	public static float custoSaque;
	public static float custoTransferencia;
	
	@Override
	public TiposConta PacotePremium() {
		this.tipoConta = "Pacote Premium";
		this.qtdeMaxLanc = 999999;
		
		return PacotePremium();
	}

	@Override
	public TiposConta PacoteBasico() {
		// TODO Auto-generated method stub
		return PacoteBasico();
	}

	@Override
	public TiposConta CobrancaPorOperacao() {
		// TODO Auto-generated method stub
		return CobrancaPorOperacao();
	}
	
	

}
