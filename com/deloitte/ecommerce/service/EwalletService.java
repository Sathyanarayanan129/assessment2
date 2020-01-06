package com.deloitte.ecommerce.service;

import java.util.Set;

import com.deloitte.ecommerce.entities.CustomerWallet;

public interface EwalletService {
	void newCustomer(CustomerWallet cw);
    void addBalance(CustomerWallet cw,double amount);
    void transferMoney(CustomerWallet c1,CustomerWallet c2,double money);
    CustomerWallet getUserByUsername(String number);
    Set<CustomerWallet> allCustomers();
}
