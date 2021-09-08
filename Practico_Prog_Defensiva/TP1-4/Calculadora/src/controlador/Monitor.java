package controlador;
package modelo;
import modelo.OperacionInvalida;
import modelo.ResultadoInvalido;

public class Monitor {
	private Calcular calculo;
	public void Calcular(int primerOperando, int segundoOperando, String operacion) {
		try(){
			
		}catch(OperacionInvalida e) {
			System.out.println("Operacion invalida");
		}catch(ResultadoInvalido e) {
			System.out.println("Resultado invalido");
		}
	}

}
