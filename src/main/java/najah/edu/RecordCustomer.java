package najah.edu;

import entities.Customer;
import entities.Data;
import java.util.Scanner;
import java.util.logging.Logger;

public class RecordCustomer {
    Logger logger = Logger.getLogger(RecordCustomer.class.getName());
    public Customer newCustomer(){
        Scanner in=new Scanner(System.in);
        Customer customer = new Customer();
        logger.info("Enter customer Name ");
        customer.setFullName(in.nextLine());
        logger.info("Enter customer Email ");
        customer.setEmail(in.nextLine());
        logger.info("Enter customer Phone ");
        customer.setPhone(in.nextLine());
        logger.info("Enter customer Address ");
        customer.setAddress(in.nextLine());
        logger.info("Enter customer Password ");
        customer.setPassword(in.nextLine());
        customer.setId(Data.getId());
        if(customer.isTakenEmail()){
            logger.info("This email is already taken and this is his details");
            logger.info(()->String.valueOf(customer.getCustomerDetails()));
            logger.info("Enter new Email");
            customer.setEmail(in.nextLine());
        }
        addNewCustomer(customer);
        return customer;
    }
    public void addNewCustomer(Customer customer) {
    Data.storeObject("Customer",customer);
    Login login=new Login();
    login.setEmail(customer.getEmail());
    login.setPassword(customer.getPassword());
    Data.storeObject("Login",login);

    }
    public void takenMsg() {
        logger.info("This email is already taken and this is the customer information ");
    }
}
