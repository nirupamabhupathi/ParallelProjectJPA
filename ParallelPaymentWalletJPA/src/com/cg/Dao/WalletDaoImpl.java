package com.cg.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.Exception.PaymentException;
import com.cg.bean.Account;

public class WalletDaoImpl implements IWalletDao {

	//private static HashMap<String, Account> AccountMap= AccountDb.getAccountEntry();
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("java");

	EntityManager em = emf.createEntityManager();

	public String CreateAccount(Account account) throws PaymentException {
//		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();
		return account.getPhoneNumber();
		
		
	}

	public double ShowBalance(String mobileNo) throws PaymentException {
		
		String strQuery="select a from Account a where a.phoneNumber=?";
	System.out.println(mobileNo);
		TypedQuery<Account> query=em.createQuery(strQuery,Account.class);
		query.setParameter(1,mobileNo);
		Account ac= query.getSingleResult();
		System.out.println(ac.getBalance());
		if(mobileNo.equals(ac.getPhoneNumber()))
		{
			return ac.getBalance();
		}
		else {
			throw new PaymentException("number does not exist");
		}
		
		
	}

	public Account deposit(String mobileNo, double deposit) throws PaymentException {
		em.getTransaction().begin();
		String strQuery="select a from Account a where a.mobileno=:g";
		TypedQuery<Account> query=em.createQuery(strQuery,Account.class);
		query.setParameter(1,mobileNo);
		Account ac=query.getSingleResult();
		if(ac==null) {
		throw new PaymentException("does not exists");
		}
		double d=ac.getBalance()+deposit;
		ac.setBalance(d);
		em.merge(ac);
		 
		 
		em.getTransaction().commit();
		return ac;
	
	
	}

	public Account withdraw(String mobileNo, double withdraw) throws PaymentException {
		em.getTransaction().begin();
		String strQuery="select a from Account a where a.mobileno=:g";
		TypedQuery<Account> query=em.createQuery(strQuery,Account.class);
		query.setParameter(1,mobileNo);
		Account ac=query.getSingleResult();
		if(ac==null) {
		throw new PaymentException("does not exists");
		}
		double d=ac.getBalance()-withdraw;
		ac.setBalance(d);
		em.merge(ac);
		 
		 
		em.getTransaction().commit();
		return ac;
	}

	public Account FundTransfer(String mobileNo1, String mobileNo2,double transferAmt) throws PaymentException
	{em.getTransaction().begin();
		String strQuery="select a from Account a where a.mobileno=:g";
		TypedQuery<Account> query=em.createQuery(strQuery,Account.class);
		TypedQuery<Account> query1=em.createQuery(strQuery,Account.class);
		query.setParameter("g",mobileNo1);
		query1.setParameter("g", mobileNo2);
		Account ac=query.getSingleResult();
		Account ac1=query1.getSingleResult();
		if(ac==null || ac1==null) {
			throw new PaymentException("number doesnot exists");
			
		}else {
			IWalletDao dao=new WalletDaoImpl();
			dao.withdraw(mobileNo1, transferAmt);
			dao.deposit(mobileNo2, transferAmt);
			
			em.getTransaction().commit();
			return ac;
			
			
			
		
		}
		
		
	}

	public Account printDetails(String mobileNo) throws PaymentException {
		String strQuery="select a from Account a where a.mobileno=:g";
		TypedQuery<Account> query=em.createQuery(strQuery,Account.class);
		query.setParameter("g",mobileNo);
		Account ac=query.getSingleResult();
		if(ac==null) {
		return ac;
		}else {
		throw new PaymentException("number doesnot exists");
		}
		}
		
	}
		
		
	


