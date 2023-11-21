package service;

import entity.Customer;

public interface CustomerService {
    void addCustomer();
    Customer findByName(String name);
}
