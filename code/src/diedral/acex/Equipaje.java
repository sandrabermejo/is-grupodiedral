/*
 * Equipaje.java - ACE Gesti�n Externa - Grupo diedral 2013
 */

package diedral.acex;


/**
 * Esta clase representa un equipaje.
 *
 * <p>Contiene el peso y el n�mero de bultos
 */
public abstract class Equipaje implements java.io.Serializable {
	// CONSTRUCTOR
	
	/**
	* Crea un Equipaje con los datos asociados.
	*
	* @param peso El peso del equipaje.
	* @param noBultos el n�mero de bultos.
	*/
	public Equipaje(double peso, int noBultos){ //Valores no negativos.
		_peso = peso; 
		_noBultos = noBultos;
	}

	
	//	M�TODOS P�BLICOS
	
	/**
	* Establece el peso del equipaje.
	* @param peso El peso.
	*/
	public void	fijarPeso(double peso){
		_peso = peso;
	}
	
	/**
	* Obtiene el peso del equipaje.
	* @return El peso.
	*/
	public double damePeso(){
		return _peso;
	}

	/**
	* Establece el n�mero de bultos del equipaje.
	* @param noBultos El n�mero de bultos.
	*/
	public void	fijarBultos(int noBultos){
		_noBultos = noBultos;
	}
	
	/**
	* Obtiene el n�mero de bultos del equipaje.
	* @return La cantidad de bultos.
	*/
	public int dameBultos(){
		return _noBultos;
	}	
	// ATRIBUTOS PRIVADOS
	
	/**
	 * Peso del equipaje en Kg (SI) .
	 */
	private double _peso;
	
	/**
	* Cantidad de bultos del equipaje.
	*/
	private int _noBultos;
	private static final long serialVersionUID = 1337693133758363391L;
}