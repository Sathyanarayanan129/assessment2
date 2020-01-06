package com.deloitte.ecommerce.ui;
import com.deloitte.ecommerce.entities.CustomerWallet;
import java.util.*;
import com.deloitte.ecommerce.dao.Ewalletdaoimp;
import com.deloitte.ecommerce.service.EwalletServiceImp;
public class WalletInterface {
    private EwalletServiceImp service = new EwalletServiceImp(new Ewalletdaoimp());
    
	public static void main(String[] args) {
		WalletInterface wi = new WalletInterface();
		wi.execute();
		
	}
	public void execute()
	{
		try
	{
		

		 Set<CustomerWallet> set= service.allCustomers();
		 print(set);
	
	}
	catch(Exception e)
		{
     System.out.println("Something went wrong");
		}
	}
	 public void print(Collection<CustomerWallet> customers)
	 {
	        for (CustomerWallet customer:customers)
	            System.out.println(customer.toString());
	        
}
}
