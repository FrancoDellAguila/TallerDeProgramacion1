package modelo;

public class BeerHouse {
	
	private int cantMesasLibres;
	private int cantMesasOcupadas;
	private int cantMesasDisponibles;
	private string local;
	private boolean estado; //true = abierto, false = cerrado
	
	
	public void abrirLocal(int cantMesas) {
			assert cantMesas >= 1 : "cantMesas invalida";
			assert BeerHouse.estado == false: "el local ya esta abierto";
			BeerHouse.estado = true;
			ArrayList<mesa> mesas = new ArrayList<mesa>();
			BeerHouse.cantMesasLibres = cantMesas;
			BeerHouse.cantMesasOcupadas = 0;
			assert cantMesasOcupadas == 0 : "fallo postcondición";
			assert cantMesasLibres == cantMesas : "fallo postcondición";
			assert invariante(): "fallo invariante";
			
	}
	
	private boolean invariante(){
		return BeerHouse.local != null;
	}
	
	public int cerrarMesa(int nroMesa) {
		assert nroMesa >= 1 : "nroMesa invalido";
		assert mesas[nroMesa].estado == "O" : "la mesa no esta ocupada"
		
		importe = mesas[nroMesa].importe;
		mesas[nroMesa].estado = "L";
		
		assert importe == mesas[nroMesa].importe : "fallo postcondición";
		assert invariante(): "fallo invariante";
		return importe;
	}
	public void ocuparMesa(int nroMesa) {
		assert nroMesa >= 1 : "nroMesa invalido";
		assert mesas[nroMesa].estado == "L" : "la mesa no esta libre"
		
		importe = mesas[nroMesa].importe;
		mesas[nroMesa].estado = "O";
		
		assert importe == mesas[nroMesa].importe : "fallo postcondición";
		assert invariante(): "fallo invariante";
		return importe;		
	}
}
