
package cajeroatm;

/**
 *
 * @author MASB
 */
public class SolicitudSaldo {
    private int numeroCuenta;
    private BaseDatosBanco baseDatosBanco;

    //public SolicitudSaldo(int numeroCuenta, BaseDatosBanco baseDatosBanco) {
        //this.numeroCuenta = numeroCuenta;
        //this.baseDatosBanco = baseDatosBanco;
   // }

    public SolicitudSaldo(int numeroCuenta, BaseDatosBanco baseDatosBanco) {
        this.numeroCuenta = numeroCuenta;
        this.baseDatosBanco = baseDatosBanco;
    }

    public int obtenerNumeroCuenta() {
        return numeroCuenta;
    }

    public BaseDatosBanco obtenerBaseDatosBanco() {
        return baseDatosBanco;
    }

    public String consultar() {
        BaseDatosBanco baseDatosBanco = obtenerBaseDatosBanco();
        double saldoDisponible = baseDatosBanco.
                obtenerSaldoDisponible(obtenerNumeroCuenta());
        String saldo= String.valueOf(saldoDisponible);
        return saldo;
    }
    
}
