package com.test;
import java.util.List;
import com.util.*;
import com.metier.*;

public class HibernateTest {

	public HibernateTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				org.hibernate.Session s =  HibernateSession.getSession();
				List<TypeCharge> liste = s.createQuery("from TypeCharge").list();
				for(TypeCharge t : liste){
					System.out.println(t.toString());
				}
				TypeCharge tp = (TypeCharge) s.get(TypeCharge.class, 2);
				System.out.println(tp.toString());

	}

}
