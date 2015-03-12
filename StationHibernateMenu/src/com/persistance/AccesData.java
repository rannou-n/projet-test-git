package com.persistance;
import com.metier.*;
import com.util.HibernateSession;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class AccesData {
	
	public static Session s = HibernateSession.getSession();
	public static Transaction trans= s.beginTransaction();
	// accesseurs sur listes d'objets
	public static List<TypeCharge> getListeTypeCharge() 	{
		return s.createQuery("from TypeCharge").list();
	}
	public static List<Station> getListeStation() 	{
		return s.createQuery("from Station").list();
	}
	public static List<Borne> getListeBorne() 	{
		return s.createQuery("from Borne").list();
	}
	public static List<Borne> getListeBorneStation(int idStation) 	{
		return s.createQuery("from Borne where idStation"+idStation).list();
	}
	public static TypeCharge getTypeCharge(int idType) 	{
		return (TypeCharge) s.get(TypeCharge.class,idType);
	}
	public static Station getStation(int idStation) 	{
		return (Station) s.get(Station.class,idStation);
	}
	public static Borne getBorne(int idBorne) 	{
		return (Borne) s.get(Borne.class,idBorne);
	}
	public static boolean addStation(Station station) 	{
		
		 try { 
			   trans.begin();
			   s.persist(station);
			   trans.commit();	  	
			   return true;
		   }	   
		   catch(HibernateException ex)
		   { 
			   return false;	   
		   }		
	}
	public static boolean deleteStation(Station station) 	{
	   
	   try { 
		   trans.begin();
		   s.delete(station);
		   trans.commit(); 	
		   return true;
	   }
	   
	   catch(HibernateException ex)
	   { 
		   return false;	   
	   }   
	}
	public static boolean updateStation(Station station) 	{
		 try { 
			   trans.begin();
			   s.saveOrUpdate(station);
			   trans.commit();		  	
			   return true;
		   }   
		   catch(HibernateException ex)
		   { 
			   return false;	   
		   }
	}
	public static boolean addBorne(Borne borne) 	{
		 try { 
			   trans.begin();
			   s.persist(borne);
			   trans.commit();		  	
			   return true;
		   }   
		   catch(HibernateException ex)
		   { 
			   return false;	   
		   }
	}
	public static boolean deleteBorne(Borne borne) 	{
		 try { 
			   trans.begin();
			   s.delete(borne);
			   trans.commit();		  	
			   return true;
		   }   
		   catch(HibernateException ex)
		   { 
			   return false;	   
		   }
	}
	public static boolean updateBorne(Borne borne) 	{
		 try { 
			   trans.begin();
			   s.saveOrUpdate(borne);
			   trans.commit();		  	
			   return true;
		   }   
		   catch(HibernateException ex)
		   { 
			   return false;	   
		   }
	}
	public static boolean updateTypeCharge(TypeCharge t)
	{
		 try { 
			   trans.begin();
			   s.saveOrUpdate(t);
			   trans.commit();		  	
			   return true;
		   }   
		   catch(HibernateException ex)
		   { 
			   return false;	   
		   }
	}
	public static boolean deleteTypeCharge(TypeCharge t) 	{
		 try { 
			   trans.begin();
			   s.delete(t);
			   trans.commit();		  	
			   return true;
		   }   
		   catch(HibernateException ex)
		   { 
			   return false;	   
		   }
	}
	public static boolean addTypeCharge(TypeCharge t) 	{
		 try { 
			   trans.begin();
			   s.persist(t);
			   trans.commit();		  	
			   return true;
		   }   
		   catch(HibernateException ex)
		   { 
			   return false;	   
		   }
	}
}
