package banco;
import java.util.Scanner;
import java.util.ArrayList;
public class Operaciones {

	public static boolean InicioSesion(Scanner sc, ArrayList<usuario> cuentas ) {
		boolean verificado=false;
		System.out.println("-------Inicio de sesion-------");
		System.out.println("Introduzca su usuario: ");
		String usuario=sc.next();
		int i;
		for( i=0; i<cuentas.size();i++) {
			if(usuario.equals(cuentas.get(i).getNombre()))
				break;
		}
		while (verificado==false) {
			
			System.out.println("Introduce la contraseña: ");
			String contrasena=sc.next();
			if(contrasena.equals(cuentas.get(i).getContrasena())) {
				verificado=true;		
				Menu.u=cuentas.get(i);

			}
			else
				System.out.println("Contrasena incorrecta.");
		}
		return verificado;
		
	}
	
	public static void CrearCuenta(Scanner sc, ArrayList<usuario> usuarios) {
		System.out.println("Introduzca el nombre del titular:");
		String nombre=sc.next();
		
		System.out.println("Introduzca su contrasena:");
		String contrasena=sc.next();
		
		System.out.println("Introduzca el saldo de su cuenta:");
		float saldo=sc.nextFloat();
		
		usuario u1=new usuario(nombre,contrasena,saldo);
		
		System.out.println("El nuevo usuario ha sido creado.");
		
		usuarios.add(u1);

	}
	
	public static void VerSaldo(Scanner sc, usuario u1) {
		System.out.println("Tiene "+u1.getSaldo()+" € en la cuenta");
	}
	
	public static void Retirar(Scanner sc, usuario u1) {
		boolean valido =false;
		while(!valido) {
			System.out.println("Introduzca la cantidad que desea retirar: ");
			float cantidad=sc.nextFloat();
			if(cantidad>0) {
				valido=true;
				if(cantidad>u1.getSaldo()) {
				System.out.println("No hay saldo suficiente en la cuenta");
				}
				else {
					
					u1.setSaldo(u1.getSaldo()-cantidad);
					System.out.println("Se han retirado "+ cantidad+ " € de la cuenta. Quedan "+u1.getSaldo()+" € en la cuenta.");
				}
			}
			else
				System.out.println("La cantidad introducida no es valida. ");
		}
		
			
			 
	}
	
	public static void Deposito(Scanner sc, usuario u1) {
		boolean valido =false;
		while(!valido) {
		System.out.println("Introduzca la cantidad que desea ingresar: ");
		float cantidad=sc.nextFloat();
		if(cantidad>0) {
			u1.setSaldo(u1.getSaldo()+cantidad);
			System.out.println("Se han ingresado "+ cantidad+ " € en la cuenta.El saldo actual es de  "+u1.getSaldo()+" €.");
			valido=true;
		}
		else {
			System.out.println("La cantidad introducida no es valida");
		}
		
		}
		
	}
	
	public static void Transferencia (Scanner sc, usuario u1,ArrayList<usuario> cuentas) {
		boolean encontrado=false;
		boolean valido=false;
		float cantidad;
		while(!encontrado) {
			System.out.println("Introduzca el nombre del destinatario: ");
		String destinatario=sc.next();
		int i;
		for (i=0;i<cuentas.size();i++) {
			if(destinatario.equals(cuentas.get(i).getNombre())) {
			 break;
			}
		}
		if(i==cuentas.size()) {
			System.out.println("No se ha encontrado la cuenta.");
		}else {
			encontrado=true;
			while(!valido) {
				System.out.println("Introduzca la cantidad que desee enviar: ");
				cantidad=sc.nextFloat();
				if(cantidad>0) {
					valido=true;
					cuentas.get(i).setSaldo(cuentas.get(i).getSaldo()+cantidad);
			
					u1.setSaldo(u1.getSaldo()-cantidad);
					System.out.println("La transferencia se ha realizado.");
			}
				else {
					System.out.println("La cantidad introducida no es valida.");
				}
			}
			
			
		}
		
		}
		
	}
}
