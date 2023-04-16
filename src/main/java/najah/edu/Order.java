package najah.edu;



import entities.Customer;
import entities.Data;
import entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id=13;
    private Customer customer;
    private LocalDate date;
    private double total;
    private boolean paid;

    public boolean isPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return id+","+customer.getId()+","+date+","+total+","+status+","+paid+"\r\n";
    }
    public  String getString(){
        StringBuilder str;
        str = new StringBuilder(this.getId() + "\t\t" + this.getCustomer().getFullName() + "\t\t\t" +
                this.getDate() + "\t\t\t"+this.getTotal()+"\t\t\t" + this.getStatus() + "\t\t\t" + (paid ? "Yes" : "No") +
                "\n");
        for (Product product:this.getProducts()){
            str.append(product.toString());
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
}
