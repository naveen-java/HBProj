package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveObjTest {

	public static void main(String[] args) {

		// bootstaring/Activating the hibernate framework
		Configuration cfg=new Configuration();

		//setting up configuration file
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");

		//bulding sesssion factory having all the services configured in the confg file and mapping file
		SessionFactory factory= cfg.buildSessionFactory();

		//creating session object
		Session ses= factory.openSession();

		Transaction tx=null;
		try
		{
			tx= ses.beginTransaction();
			Product prod=new Product();
			prod.setPid(2167);
			prod.setPname("cooker2");
			prod.setPrice(543.34f);
			prod.setQty(4.0f);
			Integer idVal = (Integer) ses.save(prod);
			System.out.println("idValue is "+ idVal);
			tx.commit();
			
			System.out.println("Object is saved into the DATABASE System");

		}
		catch(HibernateException he){
			
			he.printStackTrace();
			tx.rollback();
			System.out.println("Object is not saved into the DATABASE System (record is not inserted into the DB )");
		}


	}

}
