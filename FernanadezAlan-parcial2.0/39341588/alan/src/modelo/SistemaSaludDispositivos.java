package modelo;

import java.util.ArrayList;
import java.util.List;
import modelo.Empresa;

public class SistemaSaludDispositivos {
	private List<Empresa> lsEmpresa;
	private List<Dispositivos> lsDispositivos;
	
	public SistemaSaludDispositivos() {
		this.lsDispositivos=new ArrayList();
		this.lsEmpresa=new ArrayList();
	}
	
	public boolean agregarEmpresa(String nombre) {
		Empresa e;
		int idProx;
		if(lsEmpresa.size()==0) {
			return (lsEmpresa.add(e=new Empresa(nombre,1)));
		}
		idProx=lsEmpresa.get(lsEmpresa.size()-1).getId()+1;
		return (lsEmpresa.add(e=new Empresa(nombre,idProx)));
		
	}
	public Empresa traerEmpresa(String nombre) {
		Empresa emp=null;
		
		int i=0;
		while((i<lsEmpresa.size()) || (emp==null)) {
			if(lsEmpresa.get(i).equals(nombre)) {
				emp=lsEmpresa.get(i);
			}
			i++;
		}
		return emp;
	}
	public boolean agregarDispositivo(String nombre,String codigo,Empresa empresa)throws Exception {
		Dispositivos d1;
		int idProx;
		if(lsDispositivos.size()==0) {
			return(lsDispositivos.add(d1=new Dispositivos(nombre,codigo,empresa,1)));
		}
		idProx=lsDispositivos.get(lsDispositivos.size()-1).getId()+1;
		return (lsDispositivos.add(d1=new Dispositivos(nombre,codigo,empresa,idProx)));
	}
	
	public Dispositivos traerDispositivo(String codigo) {
		Dispositivos d1=null;
		int i=0;
		while(i<lsDispositivos.size() || d1==null) {
			if(lsDispositivos.get(i).equals(codigo)) {
				d1=lsDispositivos.get(i);
				
			}
			i++;
		}
		return d1;
	}
	
	public List<Empresa> getLsEmpresa() {
		return lsEmpresa;
	}

	public void setLsEmpresa(List<Empresa> lsEmpresa) {
		this.lsEmpresa = lsEmpresa;
	}

	public List<Dispositivos> getLsDispositivos() {
		return lsDispositivos;
	}

	public void setLsDispositivos(List<Dispositivos> lsDispositivos) {
		this.lsDispositivos = lsDispositivos;
	}
	
}
