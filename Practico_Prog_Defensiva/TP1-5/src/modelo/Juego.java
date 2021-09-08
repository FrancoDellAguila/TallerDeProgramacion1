package modelo;

public class Juego {
	private int numeroadivinanza;
	private int cantint;
	private String estado;
	
	public void juego() {
		this.setNumeroadivinanza((int) (Math.floor(Math.random() * 100) +1));
		this.setCantint(0);
	}
	
	public void probar(int num) throws NumeroNoValidoException{
		verificarInvariante();
		this.cantint++;
		if (num == (int)num) {
			if (this.cantint < 10) {
				if (num < this.numeroadivinanza) {
					this.estado = "Bajo";
				}else {
					if (num > this.numeroadivinanza) {
						this.estado = "Alto";
					}else
						this.estado = "Acerto";
				}
			}else {
				if (this.cantint == 10) {
					if (num == this.numeroadivinanza) {
						this.estado = "Ganaste";
					}else
						this.estado = "perdiste";
				}
			}
			verificarPostcondiciones(num);
		}
		else {
			throw new NumeroNoValidoException();
		}
	}
	private void verificarPostcondiciones(int num) {
		// TODO Auto-generated method stub
		assert (this.estado == "Ganaste" && this.numeroadivinanza == num):"No ganaste";
		assert (this.estado == "Perdiste" && this.numeroadivinanza != num);
		
	}

	/*
	public int getCantint() {
		return cantint;
	}
	*/
	public void setCantint(int cantint) {
		this.cantint = cantint;
	}
	public int getNumeroadivinanza() {
		return numeroadivinanza;
	}
	public void setNumeroadivinanza(int numeroadivinanza) {
		this.numeroadivinanza = numeroadivinanza;
	}
	
	public int traerIntentos() {
		return this.cantint;
	}
	
	public String traerEstado() {
		return this.estado;
	}

	public String getEstado() {
		return estado;
	}
	
	private void verificarInvariante() {
		assert (this.numeroadivinanza >0 && this.numeroadivinanza <= 100);
		assert (this.estado != "perdiste" || this.estado != "Ganaste");
	}

	public int getCantint() {
		return cantint;
	}
	
}
