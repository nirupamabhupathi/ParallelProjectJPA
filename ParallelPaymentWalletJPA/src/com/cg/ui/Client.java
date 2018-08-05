package com.cg.ui;

import com.cg.Exception.PaymentException;
import com.cg.bean.Account;
import com.cg.service.IWalletService;
import com.cg.service.WalletServiceImpl;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IWalletService service =new WalletServiceImpl();
		Account acc=new Account();
		acc.setName("Deepu");
		acc.setEmail("deepu@gmail.com");
		acc.setphoneNumber("9848468242");
		acc.setBalance(1200);
		
		try {
			
			String m=service.CreateAccount(acc);
			System.out.println(m);
		} catch (PaymentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	Account acc=new Account();
		/*IWalletService service =new WalletServiceImpl();
		
		try {
			double d=service.ShowBalance("7995229030");
			System.out.println(d);
		} catch (PaymentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
		
		/*try {
			 acc=service.withdraw("9989336633", 10);
			 System.out.println(acc.getBalance());
		} catch (PaymentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		/*try {
			Account acc=new Account();
			service.FundTransfer("9246110777","9989336633", 10);
			
			
		} catch (PaymentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//Account acc=new Account();
		/*try {
			service.printDetails("7995229030");
			System.out.println(acc.getBalance());
		} catch (PaymentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	}
}
