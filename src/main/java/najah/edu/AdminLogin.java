package najah.edu;

import entities.Admin;
import entities.Customer;
import entities.Data;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminLogin {
   Admin admin=new Admin();
    public void setPassword(String password) {
        this.admin.setPassword(password);
    }

    public void setEmail(String email) {
        this.admin.setEmail(email);
    }

    public boolean isCorrectInfo() {
        Admin actualAdmin=new Admin();
        try {
           RandomAccessFile raf = new RandomAccessFile("Admin.txt", "rw");
            raf.seek(0);
            String s;
            while ((s = raf.readLine()) != null) {
                String[] arr = s.split(" ");
             actualAdmin=new Admin(arr[0],arr[1]);

            }
            raf.close();
        }
        catch (Exception e){
            System.out.println("Error");
        }
        return actualAdmin.equals(admin);
    }
    public int menu(){
        System.out.println("To see all customers details enter number 1 ");
        System.out.println("To see all workers details enter number 2 ");
        System.out.println("To see all orders details enter number 3 ");
        System.out.println("To add new order enter number 4");
        System.out.println("To logout enter number 5");

         Scanner in=new Scanner(System.in);
        int x;
        try {
            x = in.nextInt();
            if(x<1 || x>5){
                System.out.println("Pleas enter valid number");
                x=menu();
            }
        }
        catch (InputMismatchException e){
            System.out.println("Pleas enter valid number");
            x=menu();
        }
        return x;
    }
    int customerMenu(){
        System.out.println("If you want to add new customer enter number 1");
        System.out.println("If you want to delete customer enter number 2");
        System.out.println("If you want to contact customer enter number 3");
        System.out.println("If you want to back enter number 4");
        Scanner in=new Scanner(System.in);
        int x;
        try {
             x=in.nextInt();
            if(x<1 || x>4){
                System.out.println("Enter valid number");
                x=customerMenu();
            }
        }
        catch (Exception ignored){
            System.out.println("Enter valid number");
            x=customerMenu();
        }
        return x;
    }
    void newCustomer(){
        Scanner in=new Scanner(System.in);
        Customer customer = new Customer();
        System.out.print("Enter customer First Name ");
        customer.setfName(in.nextLine());
        System.out.print("Enter customer Last Name ");
        customer.setlName(in.nextLine());
        System.out.print("Enter customer Email ");
        customer.setEmail(in.nextLine());
        System.out.print("Enter customer Phone ");
        customer.setPhone(in.nextLine());
        System.out.print("Enter customer City ");
        customer.setCity(in.nextLine());
        System.out.print("Enter customer Street ");
        customer.setStreet(in.nextLine());
        if(customer.isTakenEmail()){
            System.out.println("This email is already taken and this is his details");
            System.out.println(customer.getCustomerDetails());
            System.out.println("Enter new Email");
            customer.setEmail(in.nextLine());
        }
        customer.storeCustomer(customer);
        System.out.println("Customer added successfully");
    }
    void deleteCustomer() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the ID of the customer you want to delete ");
        int id = in.nextInt();
        ArrayList<Customer> customers = Data.getCustomers();
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customers.remove(customer);
                break;
            }
        }
        Data.updateCustomers(customers);
    }

    public void adminOptions() {
        while (true) {
            int option = menu();
            if (option == 1) {
                ArrayList<Customer> customers = Data.getCustomers();
                System.out.println("****************************************************Customers**********************************************************");
                System.out.println("First Name        Last Name               Email                       Mobile Number" +
                        "                City           Street          " +
                        "");
                for (Customer customer : customers) {
                    System.out.println(customer.getId() + "\t\t\t\t" +customer.getfName() + "\t\t\t\t" + customer.getlName() + "\t\t\t\t" + customer.getEmail() + "\t\t\t\t"
                            + customer.getPhone() + "\t\t\t\t" + customer.getCity() + "\t\t\t\t" + customer.getStreet()
                    );
                }

                while (true) {
                    int choice = customerMenu();
                    if (choice == 1) {
                    newCustomer();
                    } else if (choice==2) {
                        deleteCustomer();
                    } else if (choice==4) {
                        break;
                    }

                }
            }
            if (option==5){
                System.out.println("Goodbye");
                break;
            }
        }
    }
}
