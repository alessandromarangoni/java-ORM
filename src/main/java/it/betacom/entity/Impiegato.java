package it.betacom.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Impiegato
 *
 */
@Entity
@Table(name = "tabella_impiegato")
public class Impiegato implements Serializable {

	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;
	private double salario;
	private String titolo;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 * @param nome
	 * @param salario
	 * @param titolo
	 */

	public Impiegato() {
		super();
	}

	public Impiegato(int id, String nome, double salario, String titolo) {
		super();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
		this.titolo = titolo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	@Override
	public String toString() {
		return "Impiegato [id=" + id + ", nome=" + nome + ", salario=" + salario + ", titolo=" + titolo + "]";
	}
   
}
