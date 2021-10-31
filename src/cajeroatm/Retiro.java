
package cajeroatm;

/**
 *
 * @author MASB
 */
public class Retiro {
    private int numeroCuenta;
    private BaseDatosBanco baseDatosBanco;
    private double monto;

    public Retiro(int numeroCuenta, BaseDatosBanco baseDatosBanco) {
        this.numeroCuenta = numeroCuenta;
        this.baseDatosBanco = baseDatosBanco;
    }

    public int obtenerNumeroCuenta() {
        return numeroCuenta;
    }

    public BaseDatosBanco obtenerBaseDatosBanco() {
        return baseDatosBanco;
    }

    public boolean retirar(double monto) {
        double saldoDisponible;
        BaseDatosBanco baseDatosBanco = obtenerBaseDatosBanco();
        saldoDisponible = baseDatosBanco.obtenerSaldoDisponible(
                obtenerNumeroCuenta());

        if (monto <= saldoDisponible) {
            baseDatosBanco.cargar(obtenerNumeroCuenta(), monto);
            return true;
        } 
        else return false;
    }
    
}
