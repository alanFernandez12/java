package Test;

import modelo.Dispositivos;
import modelo.Empresa;

public class TestValidarCodigo {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Empresa e=new Empresa("nombre",2);
		try {
			Dispositivos d=new Dispositivos("nombre","A2020",e,1);
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2.getMessage());
		}
		
		
	}

}
