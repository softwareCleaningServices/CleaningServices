package najah.edu;

import entities.Customer;
import entities.Data;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class CustomerLogin {
    private Customer customer;
    Logger logger = Logger.getLogger(CustomerLogin.class.getName());
    public void menu(){
        logger.info("If you want to add new order enter number 1");
        logger.info("If you want to see your orders enter number 2");
        logger.info("If you want to see your information enter number 3");
        logger.info("If you want to logout enter number 4");


    }
    public void takeOrder(){
        AdminLogin admin=new AdminLogin();
        Order order=admin.takeOrder();
        order.setCustomer(this.customer);
        logger.info("The total is:"+order.getTotal());
        logger.info("The new total with discount is:");//TODO
        admin.addOrder(order);
    }

    public void customerPage(){
        Scanner in=new Scanner(System.in);
        while (true){
            menu();
            try {
                int option = in.nextInt();
                if(option==1){
                    takeOrder();
                } else if (option==2) {

                    for (Order order: Data.getOrderByCustomer(customer)){
                        System.out.println(order);
                    }

                } else if(option==3){
                    System.out.println(customer);
                }
                else if(option==4){
                    break;
                }
            }
            catch (InputMismatchException e){
                logger.info("please enter a valid number ");
                customerPage();
            }
        }

    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
