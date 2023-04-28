package najah.edu;

import entities.Customer;
import entities.Data;
import entities.ProductFile;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class CustomerLogin {
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    Logger logger = Logger.getLogger(CustomerLogin.class.getName());
    public void menu(){
        logger.info("If you want to add new order enter number 1");
        logger.info("If you want to see your orders enter number 2");
        logger.info("If you want to see your information enter number 3");
        logger.info("If you want to Update your information enter number 4");
        logger.info("If you want to logout enter number 5");


    }
    public void takeOrder(){
        AdminLogin admin=new AdminLogin();
        Order order=admin.takeOrder();
        order.setCustomer(this.customer);
        logger.info("The total is:"+order.getTotal());
        String tmp= "The new total with discount is:" + ProductFile.totalAfterDiscount(order);
        logger.info(tmp);
        admin.addOrder(order);
    }

    public void customerPage(){
        logger.info("Welcome To The Customer Dashboard ");
        Scanner in=new Scanner(System.in);
        while (true){
            menu();
            try {
                int option = in.nextInt();
                if(option==1){
                    takeOrder();
                }
                else if (option==2) {
                    logger.info("Order ID\tCustomer Name\t\tOrder Date\t\t\tTotal Coast\t\tOrder Status\t\tPaid \nProducts: ");
                    for (Order order: Data.getOrderByCustomer(customer)){
                        logger.info(order.getString());
                    }

                } else if(option==3){
                    logger.info(()->String.valueOf(customer));
                } else if (option==4) {
                    updateInfo();
                } else if(option==5){
                    break;
                }
            }
            catch (InputMismatchException e){
                logger.info("please enter a valid number ");
                customerPage();
            }
        }

    }

    private void updateInfo() {
        logger.info("If you want to update your Phone enter number 1");
        logger.info("If you want to update your Address enter number 2");
        logger.info("If you want to update your Password enter number 3");
        Scanner in=new Scanner(System.in);
        int option;
        try {
             option = in.nextInt();
             updateOptions(option);
        }catch (InputMismatchException e){
            logger.info("Enter a valid option number");
            updateInfo();
        }
        int id =customer.getId();
        List<Customer>customers=Data.getCustomers();
        for (Customer customer1:customers){
            if(customer1.getId()==id){
                customer1.setAddress(customer.getAddress());
                customer1.setPassword(customer.getPassword());
                customer1.setPhone(customer.getPhone());
                break;
            }
        }

        Data.updateCustomers(customers);
    }

    public void updateOptions(int option) {
        Scanner in = new Scanner(System.in);
        String attribute="";
        String value="";
        if (option == 1) {

            logger.info("Enter New Phone Number");
            value = in.nextLine();
            attribute="phone";
        } else if (option == 2) {
            logger.info("Enter New Address");
            value = in.nextLine();
            attribute="address";
        } else if (option == 3) {
            while (true) {
                logger.info("Enter the current password");
                String oldPass = in.nextLine();
                if (oldPass.equals(customer.getPassword())) {
                    logger.info("Enter new Password");
                    value = in.nextLine();
                    attribute="password";

                    break;
                } else {
                    logger.info("Mismatch password try again");
                }
            }
        }
     updateInfo(attribute,value);
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void updateMsg() {
        logger.info("Your Information Updated Successfully");
    }

    public void updateInfo(String attribute, String value) {
        if(attribute.equalsIgnoreCase("address")){
            customer.setAddress(value);
        } else if (attribute.equalsIgnoreCase("phone")) {
            customer.setPhone(value);
        }
        else if (attribute.equalsIgnoreCase("password")){
            customer.setPassword(value);
            List<Login>loginList=Data.users();
            for (Login login:loginList){
                if(login.getEmail().equals(customer.getEmail())){
                    login.setPassword(value);
                    break;
                }
            }
            Data.updateLogin(loginList);

        }

    }
}
