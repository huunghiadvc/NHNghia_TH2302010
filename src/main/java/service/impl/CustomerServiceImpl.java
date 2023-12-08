package service.impl;

import entity.Customer;
import entity.CustomerRepo;
import service.CustomerService;
import service.RepoService;
import utils.InputUtils;
import utils.ValidateUtils;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public void addCustomer() {
        String name;
        String email;
        String tel;
        RepoService repoService = new RepoServiceImpl();
        while (true){
            System.out.println("Please enter customer name: ");
            name = InputUtils.getString();
            if (ValidateUtils.nameValid(name) && repoService.checkNameExist(name)){
                System.err.println("Invalid customer name, please try again!");
                break;
            }
            System.err.println("Invalid customer name, please try again!");
        }

        while (true){
            System.out.println("Please enter customer email: ");
            email = InputUtils.getString();
            if (ValidateUtils.emailValid(email)){
                break;
            }
            System.out.println("Invalid email format!");
        }

        while (true){
            System.out.println("Please enter customer phone: ");
            tel = InputUtils.getString();
            if (!ValidateUtils.phoneValid(tel)){
                System.err.println("Invalid customer phone number!");
                continue;
            }
            if (tel.length() != 10){
                System.err.println("Phone number need 10 digits!");
                continue;
            }
            break;
        }
        Customer c = new Customer(name, email, tel);
        CustomerRepo.getCustomerRepo().put(c.getName(), c);
        System.out.println("ADD CUSTOMER SUCCESSFULLY!");
    }

}
