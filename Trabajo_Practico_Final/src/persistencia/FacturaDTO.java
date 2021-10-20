package persistencia;

import java.io.Serializable;
import java.util.TreeSet;

import infraestructura.Factura;

//Las facturas emitidas deberán conservarse para poder ser consultadas por rango de fechas.

public class FacturaDTO implements Serializable{
	 private TreeSet<Factura> facturas= new TreeSet<>();

	public TreeSet<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(TreeSet<Factura> facturas) {
		this.facturas = facturas;
	}
	 
}
