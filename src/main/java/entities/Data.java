package entities;
import najah.edu.AddOrder;
import najah.edu.Login;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.ArrayList;
public class Data {
    static RandomAccessFile raf;
    public static ArrayList<Login> users(){
        ArrayList<Login> list = new ArrayList<>();
        try {
            raf = new RandomAccessFile("Back/Login.txt", "rw");
            raf.seek(0);
            String s;
            while ((s = raf.readLine()) != null) {
                String[] arr = s.split(" ");
            Login login=new Login(arr[0],arr[1],arr[2]);
            list.add(login);
            }
            raf.close();
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
    public static ArrayList<Customer> getCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            raf = new RandomAccessFile("Back/Customer.txt", "rw");
            raf.seek(0);
            String s;
            while ((s = raf.readLine()) != null) {
                String[] arr = s.split(",");
                Customer customer=new Customer(Integer.parseInt(arr[0]),arr[1], arr[2], arr[3], arr[4],arr[5]);
                customers.add(customer);
            }
            raf.close();
        }
        catch (Exception ignored){
        }

        return customers;
    }
    public static ArrayList<AddOrder> getOrders(){
        ArrayList<AddOrder> orders = new ArrayList<>();
        ArrayList<String>strings=new ArrayList<>();
        try {
            raf = new RandomAccessFile("Back/Orders.txt", "rw");
            raf.seek(0);
            String s;
            while ((s = raf.readLine()) != null) {
                strings.add(s);
            }
            raf.close();
        }
        catch (Exception ignored){
        }
        for (String s:strings){
            ArrayList<Product>products=new ArrayList<>();
            String[] arr = s.split(",");
            AddOrder order=new AddOrder();
            order.setId(Integer.parseInt(arr[0]));
            Customer customer=getCustomerById(Integer.parseInt(arr[1]));
                order.setDate(LocalDate.parse(arr[2]));
                order.setTotal(Double.parseDouble(arr[3]));
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
        ArrayList<Customer>customers=getCustomers();
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
    public static void updateCustomers(ArrayList<Customer>customers){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Back/Customer.txt"));
            writer.write("");
            writer.flush();
            writer.close();
            RandomAccessFile raf = new RandomAccessFile("Back/Customer.txt", "rw");
            raf.seek(0);
            for (Customer customer : customers) {
                raf.writeBytes(customer.getId() + "," +customer.getFullName() + "," + customer.getEmail() + "," + customer.getPhone() + "," +
                        customer.getAddress()+","+customer.getPassword() +"\r\n");

            }
            raf.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
    public static void updateOrders(ArrayList<AddOrder> orders) {
                try {
            BufferedWriter     writer = new BufferedWriter(new FileWriter("Back/Orders.txt"));
            writer.write("");
            writer.flush();
            writer.close();
            RandomAccessFile raf = new RandomAccessFile("Back/Orders.txt", "rw");
            raf.seek(0);
            for (AddOrder order : orders) {
                raf.writeBytes(order.getId()+","+order.getCustomer().getId()+","+order.getDate()+","+order.getTotal()+","+order.getStatus()+ "," );
                for(Product product:order.getProducts()){
                    raf.writeBytes(product.getName()+" ");
                }
                raf.writeBytes("\r\n");
            }
            raf.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
    public static AddOrder getOrderByID(int id){
        AddOrder order=new AddOrder();
        for (AddOrder order1:getOrders()){
            if(order1.getId()==id){
                order=order1;
                break;
            }
        }
        return order;
    }
}


