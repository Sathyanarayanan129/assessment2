package com.deloitte.ecommerce.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.deloitte.ecommerce.entities.CustomerWallet;

public class Ewalletdaoimp implements Ewalletdao {
    private Map<String, CustomerWallet> store = new HashMap<>();

    public Ewalletdaoimp() {
        CustomerWallet cw1 = new CustomerWallet("2348424809", "Sathya", 12000, "1234");
        CustomerWallet cw2 = new CustomerWallet("9872340812", "Aswin", 90900, "2345");
        store.put(cw1.getMobile(), cw1);
        store.put(cw2.getMobile(), cw2);
    }


    public void addNewCustomer(CustomerWallet cw) {
        store.put(cw.getMobile(), cw);
    }

    public void addBalance(CustomerWallet cw, double amount) {
        cw.addAmount(amount);
    }

    public void transferMoney(CustomerWallet c1, CustomerWallet c2, double money) {
        double balance1, balance2;
        balance1 = c1.getBalance();
        balance2 = c2.getBalance();
        c2.setBalance(balance2 + money);
        c1.setBalance(balance1 - money);
    }

    public CustomerWallet getUserByUsername(String number) {
        return store.get(number);
    }

    public Set<CustomerWallet> allCustomers() {
        Collection<CustomerWallet> collect = store.values();
        Set<CustomerWallet> set = new HashSet<>(collect);
        return set;
    }


}

