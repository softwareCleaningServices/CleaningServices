package najah.edu;

import entities.Customer;
import entities.Data;
import entities.Product;
import entities.Worker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Order {
    private int id;
    private Customer customer;
    private LocalDate date;
    private double total;
    private boolean paid;
    private Worker worker;
    public Worker getWorker() {
        return worker;
    }
    public void setWorker(Worker worker) {
        this.worker = worker;
    }
    public boolean getPaid() {
        return paid;
    }
    @Override
    public String toString() {

        return id+","+customer.getId()+","+date+","+total+","+status+","+paid+","+(worker==null?0:worker.getId())+"\r\n";
    }
    public  String getString(){
        String threeSpace="\t\t\t";
        StringBuilder str;
        str = new StringBuilder(this.getId() + "\t\t" + this.getCustomer().getFullName() + threeSpace+
                this.getDate() + threeSpace+this.getTotal()+threeSpace + this.getStatus() + threeSpace + (paid ? "Yes" : "No") +
                threeSpace+this.getWorker().getName()+ "\n");
        for (Product product:this.getProducts()){
            str.append(product.toString()).append("  ").append("\n");
        }
             str.append("\t\t\n");
        return str.toString();
    }
    public LocalDate getDate() {
        return date;
    }
    public Order() {
        products=new ArrayList<>();
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    private  List<Product> products;
    private String status;
    public Customer getCustomer() {
        return customer;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
        calcTotal();
    }
    public List<Product> getProducts() {
        return products;
    }
    public String getStatus() {
        return status;
    }
    public Order(List<Product> products, String status) {
        this.id= Data.getOrderId();
        this.date=LocalDate.now();
        this.products=products;
        this.status=status;
        this.paid=false;
        calcTotal();
    }
    void calcTotal(){
        double out=0;
        for (Product product:products){
            out+=product.getCost();
        }
        total=out;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCustomer(Customer customer) {
        this.customer=customer;
    }
    public double getTotal(){
        return total;
    }
    public void displayStatus() {
        logger.info("The Order Status is: "+this.getStatus());
    }
    static Logger logger = Logger.getLogger(Order.class.getName());

    public void displayDetails() {
       logger.info(toString());
    }
}
