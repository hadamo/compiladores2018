package comandoAltoNivel;

import geradorCodigo.Expressao;

public abstract class ComandoCondicional extends ComandoAltoNivel{
	
	ListaComandosAltoNivel listaComandosAltoNivelTrue;
	Expressao expressao;
	
	public ComandoCondicional(Expressao expressao, ListaComandosAltoNivel listaComandosAltoNivelTrue) {
		this.expressao = expressao;
		this.listaComandosAltoNivelTrue = listaComandosAltoNivelTrue;
	}

	@Override
	public String toString() {
	     return null;
	 }

}
