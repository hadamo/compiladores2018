package semantico;
import java.util.*;

import apoio.ErroSemantico;
import parser.Token;

public class Tabela {
	static Simbolo simb;
	private int marcador; // armazena a �ltima refer�ncia
	
	public static HashMap<String, Simbolo> tab;
	
	public Tabela(){
		this.tab = new HashMap<String, Simbolo>();
		this.marcador = 1;
	}
	
	   // inclu�da na tabela
	public void incluiSimbolo(Token v, TipoDado tipo) throws ErroSemantico {
		if(this.tab.containsKey(v.image) == false) { //caso nao contenha a chave
  	  		this.simb = new Simbolo(v, tipo, incMarcador(tipo) );
	  		//simb.setNome(v.image); //salva o nome 
	  		//simb.setReferencia(incMarcador(t.image)); //calcula a referencia do pr�ximo e seta a minha referencia
			//if(t.image.equals(Tipo.NUMERO.getNome())) { simb.setTipo(Tipo.NUMERO); /*salva o tipo da variavel*/ }
			//if(t.image.equals(Tipo.PALAVRA.getNome())) { simb.setTipo(Tipo.PALAVRA); /*salva o tipo da variavel*/ }
	  		this.tab.put(v.image, simb); //salva o simbolo na tabela hashing
	  		System.out.println(this.tab);
	  		System.out.println("-----------------");
  	  	}else { //erro, chave ja adicionada
			//System.out.println("Erro: vari�vel "+v.image+" declarada novamente na linha "+v.endLine );
			throw new ErroSemantico("Vari�vel "+v.image+" declarada novamente na linha "+v.endLine );
  	  	}
	}
	
	public boolean verificaExistenciaSimbolo(Token v) throws ErroSemantico {
		if(this.tab.containsKey(v.image) == false) { //caso nao contenha a chave
			//System.out.println("Erro: vari�vel "+v.image+" n�o declarada na linha "+v.endLine );
			throw new ErroSemantico("Vari�vel "+v.image+" n�o declarada na linha "+v.endLine);
			//return false;
  	  	}
		return true;
	}
	
	public Simbolo consultaSimbolo(String nome) {
		if(this.tab.containsKey(nome)) { //caso exista simbolo		
			return tab.get(nome);
  	  	}
		return null;
	}
	
	public int incMarcador(TipoDado tipo) {
	   if(tipo == TipoDado.STR) {
		   marcador = marcador+1;
		   return marcador-1;
	   }else if(tipo == TipoDado.NUM) {
		   marcador = marcador+2;
		   return marcador-2;
	   }else {
		   return 0; //necessario? 
	   }
   }

	public int consultaReferencia(String nome) {
		if(tab.containsKey(nome)) { //caso exista simbolo		
			return tab.get(nome).getReferencia();
  	  	}
		return -1;
	}
	
	public TipoDado consultaTipo(String nome) {
		if(tab.containsKey(nome)) { //caso exista simbolo		
			return tab.get(nome).getTipo();
  	  	}
		return null;
	}
	
	public int getMarcador() {
		return marcador;
	}
	
	public void setMarcador(int marcador) {
		this.marcador = marcador;
	}
}
