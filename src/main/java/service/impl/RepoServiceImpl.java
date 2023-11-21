package service.impl;

import entity.CustomerRepo;
import service.RepoService;

public class RepoServiceImpl implements RepoService {
    @Override
    public void show() {
        CustomerRepo.getCustomerRepo().forEach((key, value) ->{
            System.err.println(CustomerRepo.getCustomerRepo().get(key).toString());
        });
    }
}
