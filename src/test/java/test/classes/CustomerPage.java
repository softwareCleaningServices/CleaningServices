package test.classes;

import entities.Customer;
import entities.Data;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.CustomerLogin;
import najah.edu.Order;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class CustomerPage {
    CustomerLogin customerLogin;
    Customer customer;
    @Given("that the customer is logged in")
    public void that_the_customer_is_logged_in() {
        customerLogin=new CustomerLogin();
        customer= Data.getCustomerById(105);
        customerLogin.setCustomer(customer);

    }

    @When("he select to see his orders")
    public void he_select_to_see_his_orders() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("2\n5\n".getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        customerLogin.customerPage();

        System.setIn(stdin);
        System.setOut(stdout);




    }

    @Then("his orders will be printed")
    public void his_orders_will_be_printed() {

        for (Order order:Data.getOrderByCustomer(customer)){
            System.out.println(order);
        }

    }
    @When("he select to add order")
    public void he_select_to_add_order() {
test();
    }

    @Then("the order will added")
    public void the_order_will_added() {
test2();
test3();
test4("4\n1\n023456\n5\n");
test4("4\n2\n023456\n5\n");
test4("4\n3\n023456\n5\n");
test4("4\n5\n023456\n5\n");
test5();
test4("df\n5\n");
customerLogin.setCustomer(Data.getCustomerById(112));
test2();
    }
    public void test(){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(("1\n5\n").getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);
        customerLogin.customerPage();
        System.setIn(stdin);
        System.setOut(stdout);
    }
    public void test2(){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("2\n5\n".getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);
        customerLogin.customerPage();
        System.setIn(stdin);
        System.setOut(stdout);
    }
public void test3(){
    InputStream stdin = System.in;
    System.setIn(new ByteArrayInputStream("3\n5\n".getBytes()));
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(byteArrayOutputStream);
    PrintStream stdout = System.out;
    System.setOut(ps);
    customerLogin.customerPage();
    System.setIn(stdin);
    System.setOut(stdout);
}
public void test4(String s){
    InputStream stdin = System.in;
    System.setIn(new ByteArrayInputStream(s.getBytes()));
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(byteArrayOutputStream);
    PrintStream stdout = System.out;
    System.setOut(ps);
    customerLogin.customerPage();
    System.setIn(stdin);
    System.setOut(stdout);
}
public void test5(){
    InputStream stdin = System.in;
    System.setIn(new ByteArrayInputStream("5\n".getBytes()));
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(byteArrayOutputStream);
    PrintStream stdout = System.out;
    System.setOut(ps);
    customerLogin.customerPage();
    System.setIn(stdin);
    System.setOut(stdout);
}

}
