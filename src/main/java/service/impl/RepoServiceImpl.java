package service.impl;

import entity.Customer;
import entity.CustomerRepo;
import service.RepoService;

public class RepoServiceImpl implements RepoService {
    @Override
    public void show() {
        if (CustomerRepo.getCustomerRepo().isEmpty()){
            System.err.println("Customer list is empty");
        } else {
            CustomerRepo.getCustomerRepo().forEach((key, value) ->{
                System.out.println(CustomerRepo.getCustomerRepo().get(key).toString());
            });
        }
    }

    @Override
    public Customer findByName(String name) {
        return CustomerRepo.getCustomerRepo().get(name);
    }

    @Override
    public boolean checkNameExist(String name) {
        return CustomerRepo.getCustomerRepo().get(name) != null;
    }
}
