package com.tag.templates;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.tag.util.HibernateUtil;



 /**
 * @author Rajasekhara
 *
 * @param <T>
 */
public class HibernateTemplate {

	
	
	public  Serializable save(Object object){
		Serializable id = null;
        Transaction transaction = null;
       Session session = HibernateUtil.getSessionFactory().openSession();
      
       try {
         transaction = session.beginTransaction();
         id = session.save(object);
         transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
              transaction.rollback();
             
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return  id;
		
	}
	
	 public Object update(Object entity) {
	        Transaction transaction = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            transaction = session.beginTransaction();
	            session.update(entity);
	            transaction.commit();
	        } catch (RuntimeException e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.flush();
	            session.close();
	        }
	        return entity;
	    }
	    
	    public Object findById(Serializable id, Class<?> clas) {
	    	Session  session = HibernateUtil.getSessionFactory().openSession();
	        return session.get(clas, id);
	    }
	    
	    public void delete(Object object ) {
	    	Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = null;
	        try {              
	            transaction = session.beginTransaction();
	            session.delete(object);
	            transaction.commit();
	        } catch (HibernateException e) {
	            transaction.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
	    
	    public List<?> findAll(Class<?> clas) {
	    	Session session = HibernateUtil.getSessionFactory().openSession();
	        Query query = session.createQuery( "from " + clas.getName());  
	        query.setCacheable(true);
	        return query.list();
	    }
	    
	    
	    public List<?> findAllByQueryName(String namedQuery) {
	    	Session session = HibernateUtil.getSessionFactory().openSession();
	        Query query = session.getNamedQuery(namedQuery) ;    
	        return query.list();
	    }
	    
	    public  void persist(Object object){
			
	        Transaction transaction = null;
	       Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	          transaction = session.beginTransaction();
	            session.save(object);
	            transaction.commit();
	        } catch (RuntimeException e) {
	            if (transaction != null) {
	              transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.flush();
	            session.close();
	        }
	        
	       
		}
	    
	    public Iterator<?> findAllWithIterator(Class<?> clas) {
	    	Session session = HibernateUtil.getSessionFactory().openSession();
	    	Query query=session.createQuery( "from " + clas.getName());
	    	return query.iterate();
	    }
	    
	    
	    public List<?> findWithCriteris(Class<?> clas){
	    	
	    	Session session=HibernateUtil.getSessionFactory().openSession();
	    //	session.enableFilter("salTest").setParameter("sal", "10000");
	    	
	    	Criteria c=session.createCriteria(clas);
	    	c.setCacheable(true);
	       	c.setCacheRegion("test");
	    	c.addOrder(Order.asc("projName"));
	    	//c.add(Restrictions.sizeEq("developersSet", 2));//filter objects which has equal to the specefied size
	    	//c.add(Restrictions.between("projId", 2, 4)); //does between operation in sql
	    	//c.add(Restrictions.like("projName", "h%")); //like comparision but care senstive
	    	//c.add(Restrictions.ilike("projName", "H%")); //like comparision but not care senstive
	    	//c.add(Restrictions.idEq(new Integer(3)));
	    	//c.add(Restrictions.in("projName", new String[]{"hyd","bang"})); //do in operation similar to sql
	    	//Criterion ct=Restrictions.isNotEmpty("developersSet"); //return only mapped objects
	     	//c.add(ct);
	    	//c.add(Restrictions.not(Restrictions.idEq(new Integer(6))));
	    	//SimpleExpression l=Restrictions.eq("projName", new String("bang"));
	    	//c.add(l);
	    	
	    	return c.list();
	    	
	    }
	    
	    
	    
}
