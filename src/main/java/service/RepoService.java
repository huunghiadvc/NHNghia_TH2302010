package service;

import entity.Customer;

public interface RepoService {
    void show();
    Customer findByName(String name);
    boolean checkNameExist(String name);
}
