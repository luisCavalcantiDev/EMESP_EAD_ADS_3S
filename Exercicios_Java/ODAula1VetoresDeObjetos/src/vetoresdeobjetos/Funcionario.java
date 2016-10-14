/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vetoresdeobjetos;

/**
 *
 * @author marcelo.modolo 
 */
public class Funcionario {
	private String nome;
	private int matricula;
	private double salario;
	
	public Funcionario(){
		this.nome = "";
		this.matricula = 0;
		this.salario = 0;
	}
	
	public Funcionario(String nome, int matricula, double salario) {
		this.nome = nome;
		this.matricula = matricula;
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "nome = " + nome + ", matricula = " + matricula + ", salario = " + salario;
	}

}
