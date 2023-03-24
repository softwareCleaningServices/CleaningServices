package najah.edu;

import entities.Customer;
import entities.Data;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class CustomerLogin {
    private Customer customer;
    Logger logger = Logger.getLogger(CustomerLogin.class.getName());
    public void menu(){
        logger.info("If you want to add new order enter number 1");
        logger.info("If you want to see your orders enter number 2");
        logger.info("If you want to see your information enter number 3");
        logger.info("If you want to Update your information enter number 4");
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
                        logger.info(()->String.valueOf(order));
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

        if (option == 1) {
            logger.info("Enter New Phone Number");
            String phone = in.nextLine();
            customer.setPhone(phone);
        } else if (option == 2) {
            logger.info("Enter New Address");
            String address = in.nextLine();
            customer.setAddress(address);
        } else if (option == 3) {
            while (true) {
                logger.info("Enter the current password");
                String oldPass = in.nextLine();
                System.out.println(customer.getPassword());
                if (oldPass.equals(customer.getPassword())) {
                    logger.info("Enter new Password");
                    String password = in.nextLine();
                    customer.setPassword(password);
                    break;
                } else {
                    logger.info("Mismatch password try again");
                }
            }
        }
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
