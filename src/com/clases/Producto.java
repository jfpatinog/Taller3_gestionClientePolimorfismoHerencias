package com.clases;

import java.util.ArrayList;
import java.util.Scanner;

import com.clientes.CRUD;

public class Producto extends CRUD{
	
	
    private String nombre;
    private String carateristicas;
    private String idProducto;
    private String condiciones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarateristicas() {
        return carateristicas;
    }

    public void setCarateristicas(String carateristicas) {
        this.carateristicas = carateristicas;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }
    
    public Producto Crear() {
		Scanner in = new Scanner(System.in);
		String txt = "";
		
		Producto prod= new Producto();

		MostrarMensaje(INGRESAR + " el Nombre del producto:");
		prod.setNombre(in.nextLine());
		
		MostrarMensaje(INGRESAR + " el Identificador del Producto:");
		prod.setIdProducto(in.nextLine());
		
		MostrarMensaje(INGRESAR + " las Condiciones del Producto:");
		prod.setCondiciones(in.nextLine());
		
		MostrarMensaje(INGRESAR + " las Caracteristicas del Producto:");
		prod.setCarateristicas(in.nextLine());
		
		return prod;
    }
    
	public Producto Buscar(ArrayList<Producto> LtsProducto) {
		Scanner in = new Scanner(System.in);
		String txt = "";
		
		Producto per = new Producto();

		MostrarMensaje(INGRESAR + "el Identificador del producto: ");
		per.setIdProducto(in.nextLine());
		
		for (Producto bean: LtsProducto) {
			if(bean.getIdProducto().equals(per.getIdProducto())) {
				return bean;
			}
		}
		return null;
	}

	public String toString() {
		return "Producto [nombre=" + nombre + ", carateristicas=" + carateristicas + ", idProducto=" + idProducto
				+ ", condiciones=" + condiciones + "]";
	}
	
	//POLIMORFISMO DE SOBRE ESCRITURA
	public void MostrarMensaje(String data) {
		System.out.println(data);
	}
}
