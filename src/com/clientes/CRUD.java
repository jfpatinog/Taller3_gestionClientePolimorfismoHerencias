package com.clientes;

public class CRUD {

	public static final String INGRESAR = "*Ingresar " ;
	public static final String CLIENTE = "CLIENTE " ;
	
	public Object Crear() {
		System.out.println("Crear desde el crud");
		return null;
	}
	
	public void MostrarMensaje(String data) {
		System.out.println("Mensaje desde el crud");
	}
	
	public static String NO_ENCONTRADO() {
		return  "CLIENTE NO ENCONTRADO";
	}
	
}
