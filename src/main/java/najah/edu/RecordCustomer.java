package najah.edu;



import entities.Customer;
import entities.Data;

import java.io.RandomAccessFile;
import java.util.Scanner;

public class RecordCustomer {
    public void newCustomer(){
        Scanner in=new Scanner(System.in);
        Customer customer = new Customer();
        System.out.print("Enter customer Name ");
        customer.setFullName(in.nextLine());
        System.out.print("Enter customer Email ");
        customer.setEmail(in.nextLine());
        System.out.print("Enter customer Phone ");
        customer.setPhone(in.nextLine());
        System.out.print("Enter customer Address ");
        customer.setAddress(in.nextLine());
        System.out.print("Enter customer Password ");
        customer.setPassword(in.nextLine());
        customer.setId(Data.getId());
        if(customer.isTakenEmail()){
            System.out.println("This email is already taken and this is his details");
            System.out.println(customer.getCustomerDetails());
            System.out.println("Enter new Email");
            customer.setEmail(in.nextLine());
        }
        addNewCustomer(customer);
    }
    public void addNewCustomer(Customer customer) {

        try{
            RandomAccessFile raf = new RandomAccessFile("src/main/resources/Back/Customer.txt", "rw");
            raf.seek(raf.length());
            raf.writeBytes(customer.getId()+","+customer.getFullName()+ "," + customer.getEmail() + "," + customer.getPhone() + "," +
                    customer.getAddress()+","+customer.getPassword() +"\r\n");

            raf.close();
            raf=new RandomAccessFile("src/main/resources/Back/Login.txt", "rw");
            raf.seek(raf.length());
            raf.writeBytes(customer.getEmail()+" "+customer.getPassword()+" customer"+"\r\n");
        }
        catch(Exception e){
            System.out.println("Error");
        }

    }
    public void takenMsg() {
        System.out.println("This email is already taken and this is the customer information ");
    }
}
