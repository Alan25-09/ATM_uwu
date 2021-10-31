
package cajeroatm;

/**
 *
 * @author MASB
 */
public class Deposito {
    private int numeroCuenta;
    private BaseDatosBanco baseDatosBanco;
    private double monto;

    public Deposito(int numeroCuenta, BaseDatosBanco baseDatosBanco){
        this.numeroCuenta = numeroCuenta;
        this.baseDatosBanco = baseDatosBanco;
    }

    public int obtenerNumeroCuenta(){
        return numeroCuenta;
    }

    public BaseDatosBanco obtenerBaseDatosBanco(){
        return baseDatosBanco;
    }
    
    public void Depositar(double monto){
        BaseDatosBanco baseDatosBanco = obtenerBaseDatosBanco();
        baseDatosBanco.abonar( obtenerNumeroCuenta(), monto ); 
    }
    
}
