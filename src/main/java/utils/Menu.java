package utils;

import entity.Customer;
import service.CustomerService;
import service.RepoService;
import service.impl.CustomerServiceImpl;
import service.impl.RepoServiceImpl;

public class Menu {
    public static void show(){
        System.out.println("SELECT OPTION BELOW:");
        System.out.println("    1. Add new customer.");
        System.out.println("    2. Find customer by name.");
        System.out.println("    3. Display all customer.");
        System.out.println("    4. Exist.");
        System.out.println("Please input option: ");
    }

    public static void controller(){
        String userChoose;
        CustomerService customerService = new CustomerServiceImpl();
        RepoService repoService = new RepoServiceImpl();
        while (true){
            userChoose = InputUtils.getString();
            if (!userChoose.matches(".*[0-9].*")){
                System.err.println("Please input integer");
                continue;
            }
            break;
        }

        switch (Integer.parseInt(userChoose)){
            case 1:
                customerService.addCustomer();
                break;

            case 2:
                String name;
                while (true){
                    System.out.println("Please enter customer name: ");
                    name = InputUtils.getString();
                    if (!ValidateUtils.nameValid(name)){
                        break;
                    }
                    System.err.println("Invalid customer name, please try again!");
                }
                Customer c = repoService.findByName(name);
                if (c != null) {
                    if (c.getTel() != null){
                        System.out.println(c);
                    } else {
                        System.err.println("Found customer but phone number of customer is empty!");
                    }
                } else {
                    System.err.println("Not found!");
                }
                break;

            case 3:
                repoService.show();
                break;

            case 4:
                do {
                    System.out.println("Input Y to confirm exist or N to cancel!");
                    userChoose = InputUtils.getString();
                    if (userChoose.equalsIgnoreCase("Y")) {
                        System.exit(0);
                    }
                } while (!userChoose.equalsIgnoreCase("N"));
                break;

            default:
                System.err.println("Please select option 1-4!");
        }
    }
}
