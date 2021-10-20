package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

import infraestructura.Factura;

//Las facturas emitidas deberán conservarse para poder ser consultadas por rango de fechas.

public class FacturaDTO implements Serializable{
	 private ArrayList<Factura> facturas= new ArrayList<Factura>();

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}



}
