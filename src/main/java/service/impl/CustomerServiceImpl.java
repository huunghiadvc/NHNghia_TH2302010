package service.impl;

import entity.Customer;
import entity.CustomerRepo;
import service.CustomerService;
import utils.GetInput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public void addCustomer() {
        String name;
        String email;
        String tel;
        while (true){
            System.out.println("Please enter customer name: ");
            name = GetInput.getString();
            if (!name.matches(".*[a-zA-Z].*")){
                System.err.println("Invalid customer name, please try again!");
                continue;
            }
            break;
        }

        while (true){
            System.out.println("Please enter customer email: ");
            email = GetInput.getString();
            String regex = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()){
                break;
            }
            System.out.println("Invalid email format!");
        }

        while (true){
            System.out.println("Please enter customer phone: ");
            tel = GetInput.getString();
            if (!tel.matches(".*[0-9].*")){
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

    @Override
    public Customer findByName(String name) {
        return CustomerRepo.getCustomerRepo().get(name);
    }

}
