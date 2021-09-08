package modelo;

public class Calcular {
	private int primerOperando;
	private int segundoOperando;
	private String operacion;
	private int ultimoResultadoExitoso;
	
	
	public Calcular(int primerOperando, int segundoOperando, String operacion)throws OperacionInvalida,ResultadoInvalido {
		super();
		this.primerOperando = primerOperando;
		this.segundoOperando = segundoOperando;
		this.operacion = operacion;
		
		
		int resultado=-1;
		validarInvariantes();
		
		switch(operacion) {
		case "+": resultado =(this.primerOperando+this.segundoOperando);
				
		case "-": 
			
			if(this.segundoOperando< this.primerOperando) {
				resultado =(this.primerOperando-this.segundoOperando);
			}else {
				throw new ResultadoInvalido(); 
			}
				
		case "*": resultado = (this.primerOperando*this.segundoOperando);
				
		case "/": 
			if(this.segundoOperando!= 0) {
				resultado =(this.primerOperando/this.segundoOperando);
			}else {
				throw new OperacionInvalida(); 
			}
		}
		
		validarPostCondiciones(resultado);
		
		this.ultimoResultadoExitoso = resultado;
		
	}
	

	public int traerResultado() {
		return this.ultimoResultadoExitoso;
	}

	
	private void validarInvariantes() {
		assert (this.operacion=="+")||(this.operacion=="-")||(this.operacion=="*")||(this.operacion=="/"): "Operador invalido";
		assert (this.primerOperando == (int)this.primerOperando)||(this.primerOperando >0):"El primer operando no es un valor valido";
		assert (this.segundoOperando == (int)this.segundoOperando)||(this.segundoOperando >0):"El segundo operando no es un valor valido";
	}
	
	private void validarPostCondiciones(int resultado) {
		assert resultado>0:"Resultado invalido";
	}

}
