package najah.edu;

import entities.Customer;
import entities.Data;

import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Logger;

public class RecordCustomer {
    Logger logger = Logger.getLogger(RecordCustomer.class.getName());
    public void newCustomer(){
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
    }
    public void addNewCustomer(Customer customer) {

        try(RandomAccessFile raf = new RandomAccessFile("src/main/resources/Back/Customer.txt", "rw");
        RandomAccessFile rw=new RandomAccessFile("src/main/resources/Back/Login.txt", "rw")
        ){
            raf.seek(raf.length());
            raf.writeBytes(customer.getId()+","+customer.getFullName()+ "," + customer.getEmail() + "," + customer.getPhone() + "," +
                    customer.getAddress()+","+customer.getPassword() +"\r\n");
            rw.seek(rw.length());
            rw.writeBytes(customer.getEmail()+" "+customer.getPassword()+" customer"+"\r\n");
        }
        catch(Exception e){
            logger.info("Error");
        }

    }
    public void takenMsg() {
        logger.info("This email is already taken and this is the customer information ");
    }
}
