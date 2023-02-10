package modelo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Dispositivos {
	private int id;
	private String nombre;
	private String codigo;
	private List<Metrica> lsMetricas;
	private Empresa empresa;
	
	public Dispositivos(String nombre,String codigo,Empresa empresa, int id)throws Exception {
		this.nombre=nombre;
		this.empresa=empresa;
		this.lsMetricas=new ArrayList<Metrica>();
		this.setId(id);
		if(!this.validarCodigo(codigo))throw new Exception("error codigo");
		this.setCodigo(codigo);
		
	}

	@Override
	public String toString() {
		return "ID: "+id+
				" "+nombre+
				" codigo "+codigo+
				" empresa: "+empresa+
				" lsMetricas "+lsMetricas+
				"\n";
	}
	public boolean equals(String codigo) {
		return (this.codigo==codigo);
	}
	public boolean agregarMetrica(int valor,LocalDate fecha,LocalTime hora) {
		Metrica m1=new Metrica(valor,fecha,hora);
		return lsMetricas.add(m1);
	}
	public Metrica traerMetrica(LocalDate fecha,LocalTime hora) {
		Metrica m1=null;
		int i=0;
		while(i<lsMetricas.size() && m1==null) {
			if((lsMetricas.get(i).getFecha().equals(fecha)) && (lsMetricas.get(i).getHora().equals(hora))) {
				m1=lsMetricas.get(i);
			}
			i++;
		}
		return m1;
	}
	public List<Metrica> traerMetricas(LocalDate desde, LocalDate hasta) {
		List<Metrica> lsMetricasFecha=new ArrayList<Metrica>();
		LocalDate aux;
		for(int i=0;i<lsMetricas.size();i++) {
			aux=lsMetricas.get(i).getFecha();
			if(aux.isAfter(desde) && aux.isBefore(hasta)) {
				lsMetricasFecha.add(lsMetricas.get(i));
			}
			if(aux.equals(desde) || aux.equals(hasta)) {
				lsMetricasFecha.add(lsMetricas.get(i));
			}
			
		}
		return lsMetricasFecha;
		
	};
	public boolean validarCodigo(String codigo)throws Exception {
		int[] numA=new int[4];
		int suma=0;
		char letra=codigo.charAt(0);
		int longi=codigo.length();
		if(longi<5 || longi>5)throw new Exception("codigo error: longitud");
		//if(letra!='A')throw new Exception("codigo error: no es A ni B");
		for(int i=1;i<longi;i++) {
			numA[i-1]=codigo.charAt(i);
		}
		if(letra=='A') {
			for(int i=0;i<4;i++) {
				suma=suma+numA[i];
			}
			return (suma % 2==0);
		}
		else {
			for(int i=0;i<4;i++) {
				suma=suma+numA[i];
			}
			return (suma % 2!=0);
		}
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo=codigo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public List<Metrica> getLsMetricas() {
		return lsMetricas;
	}
	public void setLsMetricas(List<Metrica> lsMetricas) {
		this.lsMetricas = lsMetricas;
	}
	
}
