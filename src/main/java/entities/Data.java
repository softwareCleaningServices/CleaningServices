package entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Data {
    static RandomAccessFile raf;
    public static ArrayList<Customer> getCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            raf = new RandomAccessFile("customer.txt", "rw");
            raf.seek(0);
            String s;
            while ((s = raf.readLine()) != null) {
                String[] arr = s.split(" ");
                customers.add(new Customer(1, arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]));
            }
            raf.close();
        }
        catch (Exception e){
            System.out.println("Error");
        }
        return customers;
    }
    public static void updateCustomers(ArrayList<Customer>customers){
        try {
            BufferedWriter     writer = new BufferedWriter(new FileWriter("Customer.txt"));
            writer.write("");
            writer.flush();
            writer.close();
            RandomAccessFile raf = new RandomAccessFile("Customer.txt", "rw");
            raf.seek(0);
            for (Customer customer : customers) {
                raf.writeBytes(customer.getfName() + " " + customer.getlName() + " " + customer.getEmail() + " " + customer.getPhone() + " " +
                        customer.getCity() + " " + customer.getStreet() +"\r\n");

            }
            raf.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }

}
