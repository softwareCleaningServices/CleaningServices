package najah.edu;



import entities.Customer;
import entities.Data;
import entities.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerLogin {
    private Customer customer;
    public void menu(){
        System.out.println("If you want to add new order enter number 1");
        System.out.println("If you want to see your orders enter number 2");
        System.out.println("If you want to see your information enter number 3");
        System.out.println("If you want to logout enter number 4");


    }
    public void takeOrder(){
        Scanner in=new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        AddOrder order;
        while (true) {
            System.out.print("Enter the product category ");
            String category = in.nextLine();
            System.out.print("Enter the product name ");
            String name = in.nextLine();
            System.out.print("Enter short description about the product ");
            String description = in.nextLine();
            products.add(new Product(category, name, description));
            System.out.println("Do you want to add another product to this order? \"yes or no\"");
            String ans = in.nextLine();
            if (ans.equalsIgnoreCase("no")) {
                break;
            }
        }
        order=new AddOrder(products,"waiting");
        order.setCustomer(this.customer);
        AdminLogin admin=new AdminLogin();
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
                    for (AddOrder order: Data.getOrders()){
                        if(order.getCustomer().getId()==this.customer.getId()){
                            System.out.println(order);
                        }
                    }

                } else if(option==3){
                    System.out.println(customer);
                }
                else if(option==4){
                    break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("please enter a valid number ");
                customerPage();
            }
        }

    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
