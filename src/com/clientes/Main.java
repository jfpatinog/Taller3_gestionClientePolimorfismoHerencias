package com.clientes;

import java.util.ArrayList;
import java.util.Scanner;

import com.clases.Clientes;
import com.clases.Producto;

//HERENCIA
public class Main extends CRUD{
	
	static ArrayList<Clientes> LtsClientes = new ArrayList<>();
	static ArrayList<Producto> LtsProductos = new ArrayList<>();

	public static void main(String[] args) {
		CargarMenu();
	}

	private static void CargarMenu() {
		String menu = "         * 1 Agregar cliente\n" 
					+ "         * 2 Editar cliente\n"
					+ "         * 3 Eliminar cliente\n" 
					+ "         * 4 Agregar productos\n"
					+ "         * 5 Consultar clientes con documento y tipo de documento \n"
					+ "         * 0 salir de la aplicacion";
		Scanner in = new Scanner(System.in);
		Integer opMenu = new Integer(0);

		do {
			System.out.println(menu);
			switch (in.nextLine()) {
			case "1":
				CrearCliente();
				break;
			case "2":
				EditarCliente();
				break;
			case "3":
				EliminarCliente();
				break;
			case "4":
				CrearProducto();
				break;
			case "5":
				BuscarClienteMenu();
				break;
			case "0":
				System.out.println("Muchas gracias por usar nuestra app, hasta luego");
				break;
			default:
				System.out.println("El valor ingresado no es una opcion de menu");
				CargarMenu();
				break;
			}
		} while (!opMenu.toString().equals("0"));
		in.close();

	}
	
	private static void CrearCliente() {
		Clientes cli = new Clientes();
		if(LtsProductos == null || LtsProductos.size() == 0)
			LtsClientes.add((Clientes) cli.Crear());
		else
			LtsClientes.add(cli.Crear(LtsProductos));
		
	    System.out.println(CLIENTE + " REGISTRADO!!");
		CargarMenu();
	}
	
	private static void BuscarClienteMenu() {
		Clientes bean = new Clientes().Buscar(LtsClientes);
		if(bean != null) {
			System.out.println(bean.toString());
		}else
		System.err.println(NO_ENCONTRADO());
		CargarMenu();
	}
	
	private static void EditarCliente() {
		Clientes bean = new Clientes().Buscar(LtsClientes);
		if(bean != null) {
			Clientes beanMod = new Clientes().Editar(bean, LtsProductos);
			if(beanMod != null) {
				LtsClientes.remove(bean);
				LtsClientes.add(beanMod);
				System.out.println(CLIENTE + " MODIFICADO");
			}else
			System.err.println("ERROR MODIFICANDO CLIENTE");
		}else
			System.err.println(NO_ENCONTRADO());
		
		CargarMenu();
	}
	
	private static void EliminarCliente() {
		Clientes bean = new Clientes().Eliminar(LtsClientes);
		if(bean != null) {
			LtsClientes.remove(bean);
			System.out.println(CLIENTE + "Eliminado");
		}else
			System.err.println(NO_ENCONTRADO());
		CargarMenu();
	}
	
	private static void CrearProducto() {
		Producto prod = new Producto();
		LtsProductos.add(prod.Crear());
	    System.out.println("PRODUCTO REGISTRADO!!");
		CargarMenu();
	}
}
