package cajeroatm;
/**
 *
 * @author MASB
 */

import cajeroatm.Cuenta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BaseDatosBanco{
     private ArrayList<Cuenta> cuentas;
     File archivo= new File("BaseDatos.txt");
     int cuenta,nip;
     double saldo;
    
    // el constructor sin argumentos de BaseDatosBanco inicializa a cuentas
    public BaseDatosBanco() {
     cuentas= new ArrayList<Cuenta>();
     leerTexto();
       
    } // fin del constructor sin argumentos de BaseDatosBanco
    private void crearArchivo(){
try{
	if(archivo.createNewFile()){
		System.out.println("El archivo se ha creado correctamente");
}	
} catch(IOException ex){
    System.err.println("No se pudo crear el archivo"+ex);}

}

    
    // obtiene el objeto Cuenta que contiene el número de cuenta especificado
    private Cuenta obtenerCuenta(int numeroCuenta) {
        // itera a través de cuentas, buscando el número de cuenta que coincida
        for (Cuenta cuentaActual : cuentas) {
            // devuelve la cuenta actual si encuentra una coincidencia
            if (cuentaActual.obtenerNumeroCuenta() == numeroCuenta) {
                return cuentaActual;
            }
        } // fin de for
        return null; // si no se enontró una cuenta que coincida, devuelve null
    } // fin del método obtenerCuenta

    // determina si el número de cuenta y el NIP especificados por el usuario coinciden
    // con los de una cuenta en la base de datos
    public boolean autenticarUsuario(int numeroCuentaUsuario, int nipUsuario) {
        // trata de obtener la cuenta con el número de cuenta
        Cuenta cuentaUsuario = obtenerCuenta(numeroCuentaUsuario);

        // si la cuenta existe, devuelve el resultado del método validarNIP de Cuenta
        if (cuentaUsuario != null) {
            return cuentaUsuario.validarNIP(nipUsuario);
        } else {
            return false; // no se encontró el número de cuenta, por lo que devuelve false
        }
    } // fin del método autenticarUsuario

    // devuelve el saldo disponible de la Cuenta con el número de cuenta especificado
    public double obtenerSaldoDisponible(int numeroCuentaUsuario) {
        return obtenerCuenta(numeroCuentaUsuario).obtenerSaldoDisponible();
    } // fin del método obtenerSaldoDisponible

 
    // abona un monto a la Cuenta a través del número de cuenta especificador
    public void abonar(int numeroCuentaUsuario, double monto) {
        obtenerCuenta(numeroCuentaUsuario).abonar(monto);
    } // fin del método abonar

    // carga un monto a la Cuenta con el número de cuenta especificado
    public void cargar(int numeroCuentaUsuario, double monto) {
        obtenerCuenta(numeroCuentaUsuario).cargar(monto);
    }
    private void leerTexto(){
   String cadena;
   try{
	FileReader lector=new FileReader(archivo);
	BufferedReader lectura= new BufferedReader(lector);
	
	cadena=lectura.readLine();

	while(cadena !=null){
	String datos[]=cadena.split("-");
	cuenta=Integer.parseInt(datos[0]);
	nip=Integer.parseInt(datos[1]);
	saldo=Double.parseDouble(datos[2]);
	cadena=lectura.readLine();
	cuentas.add(new Cuenta(cuenta,nip,saldo)); 
}
	lectura.close();

      }catch(FileNotFoundException ex){
	 System.err.println("Error, "+ex);
	}catch(IOException ex){
	System.err.println("Error, "+ex);}

}
    
    public static void main(String[] args){
    BaseDatosBanco obj = new BaseDatosBanco();
    obj.crearArchivo();
        
        
    }
}