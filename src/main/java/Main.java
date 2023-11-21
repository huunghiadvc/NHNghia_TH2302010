import entity.Customer;
import service.CustomerService;
import service.RepoService;
import service.impl.CustomerServiceImpl;
import service.impl.RepoServiceImpl;
import utils.GetInput;
import utils.Menu;

public class Main {
    public static void main(String[] args) {
        String userChoose;
        CustomerService customerService = new CustomerServiceImpl();
        RepoService repoService = new RepoServiceImpl();

        while (true){
            Menu.show();

            while (true){
                userChoose = GetInput.getString();
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
                        name = GetInput.getString();
                        if (!name.matches(".*[a-zA-Z].*")){
                            System.err.println("Invalid customer name, please try again!");
                            continue;
                        }
                        break;
                    }
                    Customer c = customerService.findByName(name);
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
                        userChoose = GetInput.getString();
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
}
