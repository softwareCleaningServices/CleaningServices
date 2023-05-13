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

import static org.junit.Assert.assertFalse;

public class AdminPage {
AdminLogin adminLogin;
Order order;
    @Given("tha the admin logged in")
    public void tha_the_admin_logged_in() {
        adminLogin=new AdminLogin();
        adminLogin.setEmail("adminClean@gmail.com");
adminLogin.isLogged();
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
       // test4();
//testDel("112");
//testDel("0");
//testOrder("3\n1\n3\n8\n");
    }
    @When("he select to see all customers")
    public void he_select_to_see_all_customers() {
     test1(("1\n8\n4\n8\n"));
    }

    @Then("the customers will printed")
    public void the_customers_will_printed() {
        test4("4");
        test2(1,"hgf\nfghgf\ngfd\ntfd\ngfd\n4");
        test2(2,"110");
        test2(2,"hg");
        test2(2,"0");
        test2(3,"jhgh");
    testWorker(0,"4");
    testWorker(1,"fgh\ngfh\n456\nfgh\nCARPET\n7867");
    testWorker(2,"120\n");
        testWorker(2,"0\n");
        testWorker(2,"scn\n");
        testWorkerMenu("4");
        testWorkerMenu("vbn");
        testWorkerMenu("0");
adminLogin.printWorkers();
testWorker(3,"130\nPhone\nghfd\n");
testWorker(3,"130\nEmail\nghfd\n");
testWorker(3,"130\nPhone\nghfd\n");
testWorker(3,"130\nSalary\nghfd\n");
testWorker(3,"130\nAddress\nghfd\n");
testWorker(3,"hjb\n130\nPhone\nghfd\n");
test1(("1\n8\n4\n8\n"));
test1(("3\n3\n8\n"));
test1(("4\nCARPET\nfgh\njhv\nfgd\nhgfd\n5\nno\nali@gmail.com\n8\n"));

testOrder("3\n");
testOrder("5\n12\ntest\n3\n");
testOrderOptions(1,"12\ntest\n");
testOrderOptions(1,"0\ntest\n");
testOrderOptions(2,"0\n");
assertFalse(adminLogin.isExistOrder(-5));

    }

    public void test1(String s){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(s.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);
        adminLogin.adminPage();
        System.setIn(stdin);
        System.setOut(stdout);
    }
public void test2(int c,String s){
    InputStream stdin = System.in;
    System.setIn(new ByteArrayInputStream((s+"\n").getBytes()));
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(byteArrayOutputStream);
    PrintStream stdout = System.out;
    System.setOut(ps);
    adminLogin.customerOptions(c);
    System.setIn(stdin);
    System.setOut(stdout);
}
    public void test4(String s){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream((s+"\n").getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);
        adminLogin.customerMenu();
        System.setIn(stdin);
        System.setOut(stdout);
    }

    public void testWorker(int a,String s){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream((s+"\n").getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);
    adminLogin.workerOptions(a);
        System.setIn(stdin);
        System.setOut(stdout);
    }
    public void testWorkerMenu(String s){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream((s+"\n").getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);
        adminLogin.workerMenu();
        System.setIn(stdin);
        System.setOut(stdout);
    }
    public void testOrder(String s){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream((s).getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);
        adminLogin.orderMenu();
        System.setIn(stdin);
        System.setOut(stdout);
    }
    public void testOrderOptions(int a,String s){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream((s).getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);
        adminLogin.orderOptions(a);
        System.setIn(stdin);
        System.setOut(stdout);
    }


}
