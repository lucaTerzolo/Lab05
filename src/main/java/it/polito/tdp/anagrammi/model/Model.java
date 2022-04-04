package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

public class Model {

	/**
	 * Riceve una stringa e stampa tutti i suoi anagrammi
	 * @param s
	 */
	public Set<String> anagramma(String s) {
		Set<String> parole=new HashSet<String>();
		anagramma_ricorsiva("",0,s,parole); // Avvio della ricorsione
		return parole;
	}
	
	/**
	 * Data una soluzione parziale, stampa tutti gli anagrammi che iniziano in quel modo.
	 * @param parziale Soluzione parziale, iniziale, del mio anagramma. Avrà livello catatteristico
	 * @param livello Livello della ricorsione
	 * @param rimanenti I caratteri ancora da sistemare
	 */
	private void anagramma_ricorsiva(String parziale, int livello, String rimanenti,Set<String> anagrammi) {
		if(rimanenti.length()==0) { //caso terminale
			anagrammi.add(parziale);
		}else { /*caso normale*/
			// es: parziale="AC", livello=2, rimanenti="BD"
			for(int pos=0;pos<rimanenti.length();pos++) { // sto creando i sottoproblemi
				anagramma_ricorsiva(parziale+rimanenti.charAt(pos),
						livello++,rimanenti.substring(0,pos)+rimanenti.substring(pos+1),anagrammi);
			}
		}
		
	}
}