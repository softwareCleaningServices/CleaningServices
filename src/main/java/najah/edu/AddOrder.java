package najah.edu;



import entities.Customer;
import entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;

public class AddOrder {
    @Override
    public String toString() {
        return
                "customer=" + customer.getFullName() +
                ", date=" + date +
                ", total=" + total +
                ", products=" + products +
                ", status='" + status + '\'' ;
    }
    private int id=13;
    private Customer customer;
    private LocalDate date;
    private double total;

    public LocalDate getDate() {
        return date;
    }

    public AddOrder() {
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private  ArrayList<Product> products;
    private String status;

    public Customer getCustomer() {
        return customer;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public String getStatus() {
        return status;
    }

    public AddOrder(ArrayList<Product> products, String status) {
        this.id++;
        this.date=LocalDate.now();
        this.products=products;
        this.status=status;
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
        total=0;
        for (Product product:products){
            total+=product.getCost();
        }
        return total;
    }
}
