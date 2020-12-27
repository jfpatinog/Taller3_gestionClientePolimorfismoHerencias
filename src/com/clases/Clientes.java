package com.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clientes extends Personas{
    private String nombre;
    private String telefono;
    private String direccion;
    private String celular;
    private List<Producto> productos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	//POLIMORFISMO SOBRE CARGA
	public Clientes Crear() {
		return Crear(null);
	}
	
	//POLIMORFISMO SOBRE CARGA DE METODO
	public Clientes Crear(ArrayList<Producto> LtsProductos) {
		ArrayList<Producto> LtsProdCliente = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		String txt = "";
		
		Clientes cli = new Clientes();

		MostrarMensaje(INGRESAR + "el Tipo de Documento:");
		cli.setTipoDocumento(in.nextLine());
		
		MostrarMensaje(INGRESAR + "el Número de Documento:");
		cli.setDocumento(in.nextLine());
		
		MostrarMensaje(INGRESAR + "el Nombre:");
		cli.setNombre(in.nextLine());
		
		MostrarMensaje(INGRESAR + "el Teléfono:");
		cli.setTelefono(in.nextLine());
		
		MostrarMensaje(INGRESAR + "el Dirección:");
		cli.setDireccion(in.nextLine());
		
		MostrarMensaje(INGRESAR + "el Número de Celular: ");
		cli.setCelular(in.nextLine());
		
		if(LtsProductos == null || LtsProductos.size() == 0) {
			MostrarMensaje(" NO EXISTEN PRODUCTOS!!");
		}else {
			MostrarMensaje(" *DESEA INGRESAR PRODUCTOS?:Y/N ");
			while(in.nextLine().toUpperCase().equals("Y")) {
				Producto prod = new Producto().Buscar(LtsProductos);
				MostrarMensaje(prod.toString());
				MostrarMensaje("DESEA ADICIONAR EL PRODUCTO? Y/N ");
				if(in.nextLine().toUpperCase().equals("Y")) {
					LtsProdCliente.add(prod);
					MostrarMensaje("PRODUCTO ADICIONADO");
				}
				MostrarMensaje(" *DESEA INGRESAR PRODUCTOS? Y/N ");
			}
			cli.setProductos(LtsProdCliente);
		}		
		
		return cli;
	}
	
	public Clientes Buscar(ArrayList<Clientes> LtsClientes) {
		Scanner in = new Scanner(System.in);
		String txt = "";
		
		Personas per = new Personas();

		MostrarMensaje(INGRESAR + "el Tipo de Documento: ");
		per.setTipoDocumento(in.nextLine());
		
		MostrarMensaje(INGRESAR + "el Número de Documento: ");
		per.setDocumento(in.nextLine());
		
		for (Clientes bean: LtsClientes) {
			if(bean.getTipoDocumento().equals(per.getTipoDocumento()) && bean.getDocumento().equals(per.getDocumento())) {
				return bean;
			}
		}
		return null;
	}
    
	public Clientes Editar(Clientes bean, ArrayList<Producto> LtsProductos) {
		MostrarMensaje(bean.toString());
		return Crear(LtsProductos);
	}
	
	public Clientes Eliminar(ArrayList<Clientes> LtsClientes) {
		Clientes bean = Buscar(LtsClientes);
		if(bean != null) {
			return bean;
		}else 
			MostrarMensaje(NO_ENCONTRADO());
		
		return null;
	}
	
	private String ObtenerProductos() {
		StringBuffer result = new StringBuffer("");
		if(this.productos != null) {
			for (Producto prod: this.productos) {
				result.append(prod.toString())
					  .append(",");
			}
			return result.toString().substring(0, result.toString().length() - 1);
		}
		return "";
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", celular="
				+ celular + ", productos={" + ObtenerProductos() + "}]";
	}
	
	//POLIMORFISMO DE SOBRE ESCRITURA
	public void MostrarMensaje(String data) {
		System.out.println(data);
	}
	
}
