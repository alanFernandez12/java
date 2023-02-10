package Test;

import modelo.Empresa;

public class TestEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empresa em=new Empresa("empresa 1",1);
		
		System.out.println(em.equals("empresa 1"));
	}

}
