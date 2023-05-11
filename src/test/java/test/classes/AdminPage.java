package test.classes;

import entities.Data;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import najah.edu.Order;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class AdminPage {
AdminLogin adminLogin;
Order order;
    @Given("tha the admin logged in")
    public void tha_the_admin_logged_in() {
        adminLogin=new AdminLogin();

    }

    @When("he select to invoice order wit id ={int}")
    public void he_select_to_invoice_order_wit_id(Integer orderId) {
        order= Data.getOrderByID(orderId);
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream((orderId+"\n").getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        adminLogin.orderOptions(2);

        System.setIn(stdin);
        System.setOut(stdout);

    }

    @Then("e will see the invoice for this order")
    public void e_will_see_the_invoice_for_this_order() {

    }

}
