package infraestructura;

import java.io.Serializable;

public class Prestacion implements Serializable {
private String prestacion;
private double valor,subtotal;
private int cantidad;

/**Constructor de Prestacion
 * @param prestacion: Parametro de tipo string.
 * @param valor: Parametro de tipo double.
 * @param cantidad: Parametro de tipo entero.
 */
public Prestacion(String prestacion, double valor,int cantidad) {
	this.prestacion = prestacion;
	this.valor = valor;
	this.cantidad = cantidad;
}


public double getValor() {
	return valor;
}


public void setValor(double valor) {
	this.valor = valor;
}


public int getCantidad() {
	return cantidad;
}


public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}


public String getPrestacion() {
	return prestacion;
}


public double getSubtotal() {
	return subtotal;
}


public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}


@Override
public String toString() {
	return prestacion + "      " + valor + "        " + cantidad + "      "
			+ subtotal;
}



}
