package cajeroatm;
/**
 *
 * @author MASB
 */
public class Cuenta {
    private int numeroCuenta; // número de cuenta
    private int nip; // NIP para autenticación
    private double saldoDisponible; // fondos disponibles para retirar
    private double saldoTotal; // fondos disponibles + depósitos pendientes

    
    // el constructor de Cuenta inicializa los atributos
    public Cuenta(int elNumeroDeCuenta, int elNIP,double elSaldoDisponible){
        numeroCuenta = elNumeroDeCuenta;
        nip = elNIP;
        saldoDisponible = elSaldoDisponible;
    } // fin del constructor de Cuenta
    
    // determina si un NIP especificado por el usuario coincide con el NIP en la Cuenta
    public boolean validarNIP(int nipUsuario){
        if (nipUsuario == nip){
            return true;
        } else{
            return false;
        }
    } // fin del método validarNIP
    
    // devuelve el saldo disponible
    public double obtenerSaldoDisponible() {
        return saldoDisponible;
    } // fin de obtenerSaldoDisponible

    // devuelve el saldo total


    // abona un monto a la cuenta
    public void abonar(double monto) {
        saldoDisponible += monto; // lo suma al saldo total
    } // fin del método abonar

    // carga un monto a la cuenta
    public void cargar(double monto) {
        saldoDisponible -= monto; // lo resta del saldo disponible
     } // fin del método cargar
 // devuelve el número de cuenta
    public int obtenerNumeroCuenta() {
        return numeroCuenta;
    } // fin del método obtenerNumeroCuenta
} // fin de la clase Cuenta
    

