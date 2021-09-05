package surtidoDeCombustible;

public class Surtidor {
    private float cantidad_Combustible;
    private static float max=2000;
    private boolean manguera1Activa,mangueraA2ctiva;
    float acumuladoManguera1, acumuladoManguera2, ultimaventaManguera1, ultimaventaManguera2;
    private Manguera manguera1= new Manguera(),manguera2= new Manguera();

   
    public void inicializarSurtidor(float carga){
        this.cantidad_Combustible=carga;
        acumuladoManguera1=0; acumuladoManguera2=0; ultimaventaManguera1=0; ultimaventaManguera2=0;
        manguera1Activa=false;mangueraA2ctiva= false;
    }
    public void cargarSurtidor(float carga) throws DemasiadoCombustibleException{
        if(this.cantidad_Combustible + carga <= max)
            this.cantidad_Combustible+=carga;
        else throw new DemasiadoCombustibleException();
    }
    public void descargarManguera1(){
        float contLitros=0;
        if(!manguera1Activa){
            manguera1Activa=true;
            while(manguera1Activa){
                try{
                    this.vaciar();
                    contLitros++;
                }
                catch(SurtidorVacioException e){
                    manguera1Activa=false;
                }
            }
            ultimaventaManguera1=contLitros;
            acumuladoManguera1+=contLitros;
        }
    }
    public void descargarManguera2(){
        float contLitros=0;
        if(!manguera2Activa){
            manguera2Activa=true;
            while(manguera2Activa){
                try{
                    this.vaciar();
                    contLitros++;
                }
                catch(SurtidorVacioException e){
                    manguera2Activa=false;
                }
            }
            ultimaventaManguera=contLitros;
            acumuladoManguera2+=contLitros;
        }
    }

    public void vaciar(){
        if(cantidad_Combustible>0)
            this.cantidad_Combustible--;
        else throws new CombustibleAgotadoException();
    }
    
    public void activarMangera1(){
        if(!manguera1Activa)
            descargarManguera1();
        else throw new ImposibleActivarException();
    }
    public void activarMangera2(){
        if(!manguera2Activa)
            descargarManguera2();
        else throw new ImposibleActivarException();
    }

    public void desactivarManguera1(){
        manguera1Activada = false;
    }

    public void desactivarManguera2(){
        manguera2Activada = false;
    }
    public float getExistenciaDeposito(){
        return this.cantidad_Combustible;
    }
    public float getAcumuladoMangera1(){
        return this.acumuladoManguera1;
    }
    public float getAcumuladoMangera2(){
        return this.acumuladoManguera2;
    }
    public float getUltimaVentaMG1(){
        return this.ultimaventaManguera1;
    }
    public float getUltimaVentaMG2(){
        return this.ultimaventaManguera2;
    }
}
