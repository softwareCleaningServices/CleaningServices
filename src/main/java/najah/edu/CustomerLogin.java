package najah.edu;

import entities.Customer;
import entities.Data;
import entities.ProductFile;

import java.util.InputMismatchException;
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
        Order order=new Order();
        order.setCustomer(this.customer);
        logger.info("The total is:"+order.getTotal());
        String tmp= "The new total with discount is:" + ProductFile.totalAfterDiscount(order);
        logger.info(tmp);
    }

    public void customerPage(){
        logger.info("Welcome To The Customer Dashboard ");
        Scanner in=new Scanner(System.in);
        menu();
        try {
        int option = in.nextInt();

        while (true){
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
                }
                else if (option==4) {
                    men();
                    int x=in.nextInt();
                    String attribute="";
                    String value="";
                    if (x == 1) {
                        logger.info("Enter New Phone Number");
                        value = in.nextLine();
                        attribute="phone";
                    } else if (x == 2) {
                        logger.info("Enter New Address");
                        value = in.nextLine();
                        attribute = "address";
                    } else if (x == 3) {
                                logger.info("Enter new Password");
                                value = in.nextLine();
                                attribute="password";

                        }

                    updateInfo(attribute,value);
//                    updateInfo();
                }
                else if(option==5){
                    break;
                }
                menu();
                 option = in.nextInt();
            }
    }
        catch (InputMismatchException e){
            logger.info("please enter a valid number ");
        }
    }
public void men(){
    logger.info("If you want to update your Phone enter number 1");
    logger.info("If you want to update your Address enter number 2");
    logger.info("If you want to update your Password enter number 3");
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
        }
        else if (attribute.equalsIgnoreCase("password")) {
            customer.setPassword(value);
        }
        else if (attribute.equalsIgnoreCase("phone")) {
            customer.setPhone(value);
        }



    }
}