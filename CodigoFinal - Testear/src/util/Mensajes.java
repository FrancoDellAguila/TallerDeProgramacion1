package util;

public enum Mensajes
{
    ERROR_MATRICULA_INCORRECTA("Matricula incorrecta");

    private String valor;

    private Mensajes(String valor)
    {
	this.valor = valor;
    }

    public String getValor()
    {
	return valor;
    }

    public void setValor(String valor)
    {
    	this.valor = valor;
    }
    

}
