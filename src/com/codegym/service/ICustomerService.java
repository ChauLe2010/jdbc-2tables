package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> listCustomer();
    String getCustomerNameById(int id);
    void save(Customer customer);
    void update(int id,Customer newCustomer);
    void delete(int id);
}
