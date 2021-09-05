package modelo;

public class Negocio
{
	public void abrirLocal(int cantMesas) {
		try{
			if (cantMesas>1)
				BeerHouse.abrirLocal(cantMesas);
			else
				
		}catch(errorExeption e){
			
		}
	}
	
	public void cerrarMesa(int nroMesa) {
		try{
			if (nroMesa>1)
				BeerHouse.cerrarMesa(nroMesa);
			else
				//syso
		}catch(errorExeption e){
			//exep
		}	
	}
	
	public void ocuparMesa(int nroMesa) {
		try{
			if (nroMesa>1)
				BeerHouse.ocuparMesa(nroMesa);
			else
				
		}catch(errorExeption e){
			
		}	
	}
}
