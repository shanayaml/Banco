package banco;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static ArrayList <usuario> cuentas=new ArrayList<usuario>();
	
	public static void llenar_cuentas() {
		usuario u1= new usuario("Shanaya","1234",100);
		cuentas.add(u1);
		
		usuario u2=new usuario("Javier","5678",200);
		cuentas.add(u2);
	}
	
	public static void Menu_principal(Scanner sc) {
		llenar_cuentas();
		boolean continuar=true;
		boolean creacion_cuenta=false;
		boolean valido=true;
		while (!creacion_cuenta) {
			
		System.out.println("¿Desea crear una cuenta?");
		String resp=sc.next();
		
		if(resp.equals("si")) {
			Operaciones.CrearCuenta(sc, cuentas);
			creacion_cuenta=true;
		}	
		else if(resp.equals("no")) {
			creacion_cuenta=true;
		}
		else
			System.out.println("Respuesta no valida");	
		}
		
		
		System.out.println("-------Inicio de sesion-------");
		System.out.println("Introduzca su usuario: ");
		String usuario=sc.next();
		int i;
		for( i=0; i<cuentas.size();i++) {
			if(usuario.equals(cuentas.get(i).getNombre()))
				break;
		}
		if(Operaciones.InicioSesion(sc,cuentas.get(i))) {
			while(continuar) {
				while(valido) {
				opciones_menu();
				int opc=sc.nextInt();
				
				switch(opc) {
				
				case 1:
					Operaciones.VerSaldo(sc,cuentas.get(i));
					break;
				case 2:
					Operaciones.Retirar(sc, cuentas.get(i));
					break;
				case 3:
					Operaciones.Deposito(sc, cuentas.get(i));
					break;
				case 4:
					Operaciones.Transferencia(sc, cuentas.get(i), cuentas);
					break;
				case 5:
					while(continuar) {
						System.out.println("¿Esta seguro que deea cerrar sesion?");
						String respuesta=sc.next();
						if(respuesta.equals("si")) {
							continuar=false;
							valido=false;
							break;
						}
						else if(respuesta.equals("no"))
							break;
						else 
							System.out.println("Respuesta no valida");
							break;
					}
					
					
				default:
					
					break;
				}
			}
			if(continuar) {
				System.out.println("¿Desea continuar?");
				String respuesta=sc.next();
				if(respuesta.equals("no"))
					continuar=false;
				
			}
			
		}
			
			}
	}
	
	public static void opciones_menu() {
		System.out.println("Elija la opcion que desee:");
		System.out.println("1. Consutar saldo");
		System.out.println("2. Retirar");
		System.out.println("3. Ingresar");
		System.out.println("4. Transferencia");
		System.out.println("5. Cerrar sesion");
		
	}
}
