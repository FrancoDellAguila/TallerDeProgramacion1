package modelo;

public class Negocio
{
	public void abrirLocal(int cantMesas) {
		try{
			if (cantMesas>1)
				BeerHouse.abrirLocal(cantMesas);
			else
				//syso
		}catch{
			//exep
		}
	}
	
	public void cerrarMesa(int nroMesa) {
		try{
			if (nroMesa>1)
				BeerHouse.cerrarMesa(nroMesa);
			else
				system.out.prin
		}catch{
			//exep
		}	
	}
	
	public void ocuparMesa(int nroMesa) {
		try{
			if (nroMesa>1)
				BeerHouse.ocuparMesa(nroMesa);
			else
				//syso
		}catch{
			//exep
		}	
	}
}
