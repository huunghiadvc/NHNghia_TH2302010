package entity;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepo {
    private static Map<String, Customer> customerRepo;
    public static Map<String, Customer> getCustomerRepo(){
        if (customerRepo == null){
            customerRepo = new HashMap<>();
        }
        return customerRepo;
    }
}
