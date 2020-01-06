package com.deloitte.ecommerce.dao;

import java.util.Set;

import com.deloitte.ecommerce.entities.CustomerWallet;

public interface Ewalletdao {
    void addNewCustomer(CustomerWallet cw);

    void addBalance(CustomerWallet cw, double amount);

    void transferMoney(CustomerWallet c1, CustomerWallet c2, double money);

    CustomerWallet getUserByUsername(String number);

    Set<CustomerWallet> allCustomers();
} 
