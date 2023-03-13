package najah.edu;



import entities.Customer;
import entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
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
        this.id++;
        this.date=LocalDate.now();
        this.products=products;
        this.status=status;
        calcTotal();
    }
    void calcTotal(){
        double out=0;
        for (Product product:products){
            out+=product.getCost();
        }
        total=out;
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
