package com.clases;

import com.clientes.CRUD;

public class Personas extends CRUD{
    private String TipoDocumento;
    private String Documento;
	
    public Personas() {}
    
    public Personas(String tipoDocumento, String documento) {
		super();
		this.TipoDocumento = tipoDocumento;
		this.Documento = documento;
	}
	public String getTipoDocumento() {
		return TipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		TipoDocumento = tipoDocumento;
	}
	public String getDocumento() {
		return Documento;
	}
	public void setDocumento(String documento) {
		Documento = documento;
	}

	@Override
	public String toString() {
		return "Personas [TipoDocumento=" + TipoDocumento + ", Documento=" + Documento + "]";
	}

}
