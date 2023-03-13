package entities;

import najah.edu.Login;
import najah.edu.Order;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
public class Data {
    private Data(){}
    static Logger logger = Logger.getLogger(Data.class.getName());
    public static List<Login> users(){
        List<Login> list = new ArrayList<>();
        try ( RandomAccessFile raf =new RandomAccessFile("src/main/resources/Back/Login.txt", "rw")){
            raf.seek(0);
            String s;
            while ((s = raf.readLine()) != null) {
                String[] arr = s.split(" ");
            Login login=new Login(arr[0],arr[1],arr[2]);
            list.add(login);
            }
        }
        catch (Exception ignored){
        }

        return list;
    }
    public static Customer getCustomerById(int id){
        Customer customer=new Customer();
        for (Customer custom:getCustomers()){
            if(custom.getId()==id){
                customer=custom;
                break;
            }
        }
        return customer;
    }
    public static List<Customer> getCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();
        try ( RandomAccessFile raf =new RandomAccessFile("src/main/resources/Back/Customer.txt", "rw")){
            raf.seek(0);
            String s;
            while ((s = raf.readLine()) != null) {
                String[] arr = s.split(",");
                Customer customer=new Customer(Integer.parseInt(arr[0]),arr[1], arr[2], arr[3], arr[4],arr[5]);
                customers.add(customer);
            }
        }
        catch (Exception ignored){
        }

        return customers;
    }
    public static List<Order> getOrders(){
        List<Order> orders = new ArrayList<>();
        List<String>strings=new ArrayList<>();
        try ( RandomAccessFile raf =new RandomAccessFile("src/main/resources/Back/Orders.txt", "rw")){
            raf.seek(0);
            String s;
            while ((s = raf.readLine()) != null) {
                strings.add(s);
            }
        }
        catch (Exception ignored){
        }
        for (String s:strings){
            ArrayList<Product>products=new ArrayList<>();
            String[] arr = s.split(",");
            Order order=new Order();
            order.setId(Integer.parseInt(arr[0]));
            Customer customer=getCustomerById(Integer.parseInt(arr[1]));
                order.setDate(LocalDate.parse(arr[2]));
                order.setCustomer(customer);
                order.setStatus(arr[4]);
            String[]product=arr[5].split(" ");
            for (String value : product) {
                Product prod = ProductFile.getProductByName(value);
                products.add(prod);
            }
               order.setProducts(products);
            orders.add(order);
        }
        return orders;
    }
    public static int getId(){
        List<Customer>customers=getCustomers();
        int id=customers.get(customers.size()-1).getId();
        return id+1;
    }
    public static Customer getCustomerBy(String email) {
        Customer foundCustomer=new Customer();
        for(Customer customer:getCustomers()){
            if(customer.getEmail().equals(email) || customer.getFullName().equalsIgnoreCase(email)){
                foundCustomer=customer;
                break;
            }
        }
        return foundCustomer;
    }
    public static void updateCustomers(List<Customer>customers){
        try (RandomAccessFile raf = new RandomAccessFile("src/main/resources/Back/Customer.txt", "rw");
             BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/Back/Customer.txt"))
        ){
            writer.write("");
            writer.flush();
            raf.seek(0);
            for (Customer customer : customers) {
                raf.writeBytes(customer.getId() + "," +customer.getFullName() + "," + customer.getEmail() + "," + customer.getPhone() + "," +
                        customer.getAddress()+","+customer.getPassword() +"\r\n");

            }
        }
        catch(Exception e){
            logger.info("Error");
        }
    }
    public static void updateOrders(List<Order> orders) {
        try (RandomAccessFile raf = new RandomAccessFile("src/main/resources/Back/Orders.txt", "rw");
             BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/Back/Orders.txt"))
        ){
            writer.write("");
            writer.flush();
            raf.seek(0);
            for (Order order : orders) {
                raf.writeBytes(order.getId()+","+order.getCustomer().getId()+","+order.getDate()+","+order.getTotal()+","+order.getStatus()+ "," );
                for(Product product:order.getProducts()){
                    raf.writeBytes(product.getName()+" ");
                }
                raf.writeBytes("\r\n");
            }
        }
        catch(Exception e){
            logger.info("Error");
        }
    }
    public static Order getOrderByID(int id){
        Order order=new Order();
        for (Order order1:getOrders()){
            if(order1.getId()==id){
                order=order1;
                break;
            }
        }
        return order;
    }
    public static Order getOrderByCustomer(Customer customer){
        Order order=new Order();
        for (Order order1:getOrders()){
            if(order1.getCustomer().equals(customer)){
                order=order1;
                break;
            }
        }
        return order;
    }
}


