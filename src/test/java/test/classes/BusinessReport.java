package test.classes;

import entities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.Login;
import najah.edu.Order;

import java.util.ArrayList;
import java.util.List;

import static entities.Data.*;
import static org.junit.Assert.*;

public class BusinessReport {
    List<Customer> customer;
    List<Worker> workers;
    List<Order> orders;
    Login login=new Login();
    int numCustomer;
    int[] numWorker;
    int numOrders;
    int numSofa;
    int numCarpet;
    int[] numCover;
    @Given("that needs the number of all business customers")
    public void thatNeedsTheNumberOfAllBusinessCustomers() {
        customer=new ArrayList<>();
    }

    @When("the admin enters to show the report")
    public void theAdminEntersToShowTheReport() {
        login.setEmail("adminClean@gmail.com");
        login.setPassword("adminCSS");
        login.setRul("admin");
    }

    @Then("calculate number of all business customers")
    public void calculateNumberOfAllBusinessCustomers() {
        customer=getCustomers();
        numCustomer= najah.edu.BusinessReport.numberOfAllCustomers();
        assertEquals(customer.size(),numCustomer);
    }

    @Given("that needs the number of all business worker")
    public void thatNeedsTheNumberOfAllBusinessWorker() {
        workers=new ArrayList<>();
    }
    @Then("calculate number of all business worker")
    public void calculateNumberOfAllBusinessWorker() {
        numWorker= najah.edu.BusinessReport.numberOfAllWorker();
        assertEquals(11,numWorker[0]);
    }

    @Given("that needs the number of all business worker in category sofa")
    public void thatNeedsTheNumberOfAllBusinessWorkerInCategorySofa() {
        workers=getWorkers();
    }

    @Then("calculate number of all business worker in category sofa")
    public void calculateNumberOfAllBusinessWorkerInCategorySofa() {
        numWorker= najah.edu.BusinessReport.numberOfAllWorker();
        assertEquals(2,numWorker[1]);
    }

    @Given("that needs the number of all business worker in category carpet")
    public void thatNeedsTheNumberOfAllBusinessWorkerInCategoryCarpet() {
        workers=getWorkers();
    }

    @Then("calculate number of all business worker in category carpet")
    public void calculateNumberOfAllBusinessWorkerInCategoryCarpet() {
        numWorker= najah.edu.BusinessReport.numberOfAllWorker();
        assertEquals(6,numWorker[2]);
    }

    @Given("that needs the number of all business worker in category cover")
    public void thatNeedsTheNumberOfAllBusinessWorkerInCategoryCover() {
        workers=getWorkers();
    }

    @Then("calculate number of all business worker in category cover")
    public void calculateNumberOfAllBusinessWorkerInCategoryCover() {
        numWorker= najah.edu.BusinessReport.numberOfAllWorker();
        assertEquals(3,numWorker[3]);
    }
    @Given("that needs the number of all orders in this month")
    public void thatNeedsTheNumberOfAllOrdersInThisMonth() {
        orders=new ArrayList<>();
    }

    @Then("calculate number of all business orders in month {int} and year {int}")
    public void calculateNumberOfAllBusinessOrdersInMonthAndYear(int month, int year) {
        numOrders= najah.edu.BusinessReport.numberOfAllOrdersInThisMonth(month, year);
        assertEquals(4,numOrders);
    }

    @Given("that needs the number of sofas in all orders in this month")
    public void thatNeedsTheNumberOfSofasInAllOrdersInThisMonth() {
        orders=new ArrayList<>();
    }

    @Then("calculate number of sofas in all orders in month {int} and year {int}")
    public void calculateNumberOfSofasInAllOrdersInMonthAndYear(int month, int year) {
        numSofa= najah.edu.BusinessReport.numberOfSofaInThisMonth(month, year);
        assertEquals(7,numSofa);
    }

    @Given("that needs the number of carpets in all orders in this month")
    public void thatNeedsTheNumberOfCarpetsInAllOrdersInThisMonth() {
        orders=new ArrayList<>();
    }

    @Then("calculate number of carpets in all orders in month {int} and year {int}")
    public void calculateNumberOfCarpetsInAllOrdersInMonthAndYear(int month, int year) {
        numCarpet= najah.edu.BusinessReport.numberOfCarpetInThisMonth(month, year);
        assertEquals(22,numCarpet);
    }


    @Given("that needs the number of covers in all orders in this month")
    public void thatNeedsTheNumberOfCoversInAllOrdersInThisMonth() {
        orders=new ArrayList<>();
    }

    @Then("calculate number of covers in all orders in month {int} and year {int}")
    public void calculateNumberOfCoversInAllOrdersInMonthAndYear(int month, int year) {
        numCover= najah.edu.BusinessReport.numberOfCoverInThisMonth(month, year);
        assertEquals(6, numCover[0]);
        assertEquals(1, numCover[1]);
        assertEquals(2, numCover[2]);
        assertEquals(1, numCover[3]);
        assertEquals(1, numCover[4]);
        assertEquals(1, numCover[5]);
    }
}
