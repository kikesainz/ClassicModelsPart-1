package com.kike.classicmodels.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.kike.classicmodels.controllers.ClientesController;
import com.kike.classicmodels.dtos.ClienteDTO;
import com.kike.classicmodels.utils.MiScanner;

public class VistaClientes {
	
	public void menuGeneralCliente() throws ClassNotFoundException, SQLException {
	
			Scanner sc = MiScanner.getInstance();
			int n=0;
			do{
				System.out.println("Introduzca la operaci�n que desee realizar: ");
				
			    System.out.println("       MEN� PRINCIPAL PARA LA GESTI�N DE CLIENTES");
			    System.out.println("===============================================");
			    System.out.println("1. Buscar cliente por nombre");
			    System.out.println("2. Buscar cliente por nombre, tel�fono o pa�s");
			    System.out.println("3. Insertar cliente ");
			    System.out.println("4. Actualizar cliente ");
			    System.out.println("5. Borrar cliente");
			    System.out.println("6. Volver al men� principal");
			    System.out.println("===============================================");
			    
			    n = Integer.parseInt(sc.nextLine());
		    
	            if (n == 6){
	                
	                return;
	            }
		    	
	            if (n>6||n<1){
	                System.out.print("Elecci�n invalida, int�ntalo otra vez...");
	                continue;
	            }
	            if ( n == 1) {
	            	menuRecuperaNombreTelefono();
	            	continue;
	            }
		    	
		    } while(n!=6);
		
	}

	
	public void menuRecuperaNombreTelefono() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el nombre del cliente: ");
		
		String nombreEmpleado = sc.nextLine();
		
		ClientesController controladorClientes = new ClientesController();
		List <ClienteDTO> listaClientes = controladorClientes.recuperaNombreTelefono(nombreEmpleado);
		
		for (ClienteDTO cliente : listaClientes) {
			System.out.println(cliente.getNombre() + " " + cliente.getTelefono());

		}
		
	}
	
	public void menuRecuperaNombreTelefonoFiltrando() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el nombre del empleado a buscar: ");
		
		String nombreEmpleado = sc.nextLine();
		
		System.out.println("Introduzca por favor el tel�fono del empleado a buscar: ");
		
		String telefonoEmpleado = sc.nextLine();
		
		System.out.println("Introduzca por favor el pa�s del empleado a buscar: ");
		
		String paisEmpleado = sc.nextLine();
		
		ClientesController controladorClientes = new ClientesController();
		List <ClienteDTO> listaClientes = controladorClientes.recuperaNombreTelefono(nombreEmpleado, telefonoEmpleado, paisEmpleado);
		
		for (ClienteDTO cliente : listaClientes) {
			System.out.println(cliente.getNombre() + " " + cliente.getTelefono());

		}
		
	}
	
	public void menuInsertaCliente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el n�mero del cliente: ");
		int  numeroCliente = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca por favor el nombre del cliente: ");
		String nombreCliente = sc.nextLine();		
		System.out.println("Introduzca por favor el apellido del contacto: ");
		String apellidoContacto = sc.nextLine();		
		System.out.println("Introduzca por favor el nombre del contacto: ");
		String nombreContacto = sc.nextLine();		
		System.out.println("Introduzca por favor el tel�fono del cliente: ");
		String telefono = sc.nextLine();		
		System.out.println("Introduzca por favor la direcci�n del cliente: ");
		String direccion1 = sc.nextLine();		
		System.out.println("Introduzca por favor la direcci�n 2 del cliente: ");
		String direccion2 = sc.nextLine();		
		System.out.println("Introduzca por favor la ciudad del cliente: ");
		String ciudad = sc.nextLine();		
		System.out.println("Introduzca por favor el estado del cliente: ");
		String estado = sc.nextLine();		
		System.out.println("Introduzca por favor el c�digo postal del cliente: ");
		String codigoPostal = sc.nextLine();		
		System.out.println("Introduzca por favor el pais: ");
		String pais = sc.nextLine();		
		System.out.println("Introduzca por favor el id del representante: ");
		int representante = 0;
		try {
		    representante = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
		    System.out.println("No se ha introducido n�mero de representante de ventas");
		}
		System.out.println("Introduzca por favor cr�dito (n�mero con decimales): ");
		Double credito = 0.0;
		try {
			credito = Double.parseDouble(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido cr�dito");
		}

		
		ClientesController controladorClientes = new ClientesController();
		int resultado = controladorClientes.insertarCliente(numeroCliente, 
											nombreCliente, 
											apellidoContacto, 
											nombreContacto, 
											telefono, 
											direccion1, 
											direccion2, 
											ciudad, 
											estado, 
											codigoPostal, 
											pais, 
											representante, 
											credito);
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con �xito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
		
	}
	
	public void menuActualizaCliente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el n�mero del cliente a actualizar: ");
		int  numeroCliente = Integer.parseInt(sc.nextLine());		
		System.out.println("Introduzca por favor el nombre del cliente: ");
		String nombreCliente = sc.nextLine();		
		System.out.println("Introduzca por favor el apellido del contacto: ");
		String apellidoContacto = sc.nextLine();		
		System.out.println("Introduzca por favor el nombre del contacto: ");
		String nombreContacto = sc.nextLine();		
		System.out.println("Introduzca por favor el tel�fono del cliente: ");
		String telefono = sc.nextLine();		
		System.out.println("Introduzca por favor la direcci�n del cliente: ");
		String direccion1 = sc.nextLine();		
		System.out.println("Introduzca por favor la direcci�n 2 del cliente: ");
		String direccion2 = sc.nextLine();		
		System.out.println("Introduzca por favor la ciudad del cliente: ");
		String ciudad = sc.nextLine();		
		System.out.println("Introduzca por favor el estado del cliente: ");
		String estado = sc.nextLine();		
		System.out.println("Introduzca por favor el c�digo postal del cliente: ");
		String codigoPostal = sc.nextLine();		
		System.out.println("Introduzca por favor el pais: ");
		String pais = sc.nextLine();		
		System.out.println("Introduzca por favor el id del representante: ");
		int representante = 0;
		try {
		    representante = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
		    System.out.println("No se ha introducido n�mero de representante de ventas");
		}
		System.out.println("Introduzca por favor cr�dito (n�mero con decimales): ");
		Double credito = 0.0;
		try {
			credito = Double.parseDouble(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido cr�dito");
		}
		
		ClientesController controladorClientes = new ClientesController();
		int resultado = controladorClientes.actualizarCliente(numeroCliente, 
											nombreCliente, 
											apellidoContacto, 
											nombreContacto, 
											telefono, 
											direccion1, 
											direccion2, 
											ciudad, 
											estado, 
											codigoPostal, 
											pais, 
											representante, 
											credito);
		if (resultado == 1) {
			System.out.println("Se ha actualizado el cliente con el n�mero: " + numeroCliente +" con �xito");
		} else {
			System.out.println("Se ha producido un error al actualizar el cliente con el n�mero: "+ numeroCliente);
		}
		
	}
	
	public void menuBorraCliente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el n�mero del cliente a borrar: ");
		int  numeroCliente = Integer.parseInt(sc.nextLine());	
		
		ClientesController controladorClientes = new ClientesController();
		int resultado = controladorClientes.borrarCliente(numeroCliente);
		
		if (resultado == 1) {
			System.out.println("Se ha borrado el cliente con el n�mero: " + numeroCliente +" con �xito");
		} else {
			System.out.println("Se ha producido un error al borrar el cliente con el n�mero: "+ numeroCliente);
		}
	
	}
	
	
}
