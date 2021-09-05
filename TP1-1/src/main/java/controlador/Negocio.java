package modelo;

public class Negocio
{
	public void abrirLocal(int cantMesas) {
		try{
			if (cantMesas>1)
				BeerHouse.abrirLocal(cantMesas);
			else
				System.out.println("se necesitan mas mesas para abrir");
		}catch(errorExeption e){
			
		}
	}
	
	public void cerrarMesa(int nroMesa) {
		try{
			if (nroMesa>1)
				BeerHouse.cerrarMesa(nroMesa);
			else
				System.out.println("el numero de mesa no existe");
		}catch(errorExeption e){
			//exep
		}	
	}
	
	public void ocuparMesa(int nroMesa) {
		try{
			if (nroMesa>1)
				BeerHouse.ocuparMesa(nroMesa);
			else
				System.out.println("el numero de mesa no existe");
		}catch(errorExeption e){
			
		}	
	}
}
