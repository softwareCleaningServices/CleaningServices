package test.classes;

import entities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.Login;
import najah.edu.Order;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static entities.Data.*;
import static org.junit.Assert.*;

public class BusinessReport {
    List<Customer> customer;
    List<Worker> workers;
    List<Order> orders;
    Login login=new Login();
    int numSofaWorker;
    int numCarpetWorker;
    int numCoverWorker;
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
        workers=getWorkers();
        numWorker= najah.edu.BusinessReport.numberOfAllWorker();
        assertEquals(workers.size(),numWorker[0]);
    }

    @Given("that needs the number of all business worker in category sofa")
    public void thatNeedsTheNumberOfAllBusinessWorkerInCategorySofa() {
        workers=getWorkers();
    }

    @Then("calculate number of all business worker in category sofa")
    public void calculateNumberOfAllBusinessWorkerInCategorySofa() {
        for (Worker worker:workers) {
            if(worker.getCategory() == Category.SOFA){
                numSofaWorker++;
            }
        }
        numWorker= najah.edu.BusinessReport.numberOfAllWorker();
        assertEquals(numSofaWorker,numWorker[1]);
    }

    @Given("that needs the number of all business worker in category carpet")
    public void thatNeedsTheNumberOfAllBusinessWorkerInCategoryCarpet() {
        workers=getWorkers();
    }

    @Then("calculate number of all business worker in category carpet")
    public void calculateNumberOfAllBusinessWorkerInCategoryCarpet() {
        for (Worker worker:workers) {
            if(worker.getCategory() == Category.CARPET){
                numCarpetWorker++;
            }
        }
        numWorker= najah.edu.BusinessReport.numberOfAllWorker();
        assertEquals(numCarpetWorker,numWorker[2]);
    }

    @Given("that needs the number of all business worker in category cover")
    public void thatNeedsTheNumberOfAllBusinessWorkerInCategoryCover() {
        workers=getWorkers();
    }

    @Then("calculate number of all business worker in category cover")
    public void calculateNumberOfAllBusinessWorkerInCategoryCover() {
        for (Worker worker:workers) {
            if(worker.getCategory() == Category.COVER){
                numCoverWorker++;
            }
        }
        numWorker= najah.edu.BusinessReport.numberOfAllWorker();
        assertEquals(numCoverWorker,numWorker[3]);
    }
    @Given("that needs the number of all orders in this month")
    public void thatNeedsTheNumberOfAllOrdersInThisMonth() {
        orders=new ArrayList<>();
    }

    @Then("calculate number of all business orders in this month")
    public void calculateNumberOfAllBusinessOrdersInThisMonth() {
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();
        int currentYear =currentDate.getYear();
        for(Order order:getOrders()){
            if(currentMonth==order.getDate().getMonth() && currentYear==order.getDate().getYear()){
                orders.add(order);
            }
        }
        numOrders= najah.edu.BusinessReport.numberOfAllOrdersInThisMonth();
        assertEquals(orders.size(),numOrders);
    }

    @Given("that needs the number of sofas in all orders in this month")
    public void thatNeedsTheNumberOfSofasInAllOrdersInThisMonth() {
        orders=new ArrayList<>();
    }

    @Then("calculate number of sofas in all orders in this month")
    public void calculateNumberOfSofasInAllOrdersInThisMonth() {
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();
        int currentYear =currentDate.getYear();
        int numOfSofa=0;
        for(Order order:getOrders()){
            if(currentMonth==order.getDate().getMonth() && currentYear==order.getDate().getYear()){
                for (Product product : order.getProducts()) {
                    if (product.getCategory() == Category.SOFA) {
                        numOfSofa += product.getNumOfSofa();
                    }
                }
            }
        }
        numSofa= najah.edu.BusinessReport.numberOfSofaInThisMonth();
        assertEquals(numOfSofa,numSofa);
    }

    @Given("that needs the number of carpets in all orders in this month")
    public void thatNeedsTheNumberOfCarpetsInAllOrdersInThisMonth() {
        orders=new ArrayList<>();
    }

    @Then("calculate number of carpets in all orders in this month")
    public void calculateNumberOfCarpetsInAllOrdersInThisMonth() {
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();
        int currentYear =currentDate.getYear();
        int numOfCarpet=0;
        for(Order order:getOrders()){
            if(currentMonth==order.getDate().getMonth() && currentYear==order.getDate().getYear()){
                for (Product product : order.getProducts()) {
                    if (product.getCategory() == Category.CARPET) {
                        numOfCarpet += product.getDimension();
                    }
                }
            }
        }
        numCarpet= najah.edu.BusinessReport.numberOfCarpetInThisMonth();
        assertEquals(numOfCarpet,numCarpet);
    }

    @Given("that needs the number of covers in all orders in this month")
    public void thatNeedsTheNumberOfCoversInAllOrdersInThisMonth() {
        orders=new ArrayList<>();
    }

    @Then("calculate number of covers in all orders in this month")
    public void calculateNumberOfCoversInAllOrdersInThisMonth() {
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();
        int currentYear =currentDate.getYear();
        int numOfCover=0;
        for(Order order:getOrders()){
            if(currentMonth==order.getDate().getMonth() && currentYear==order.getDate().getYear()){
                for (Product product : order.getProducts()) {
                    if (product.getCategory() == Category.COVER) {
                        numOfCover ++;
                    }
                }
            }
        }
        numCover= najah.edu.BusinessReport.numberOfCoverInThisMonth();
        assertEquals(numOfCover,numCover[0]);
    }
    @Given("that needs the number of covers size King in all orders in this month")
    public void thatNeedsTheNumberOfCoversSizeKingInAllOrdersInThisMonth() {
        orders=new ArrayList<>();
    }

    @Then("calculate number of covers size King in all orders in this month")
    public void calculateNumberOfCoversSizeKingInAllOrdersInThisMonth() {
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();
        int currentYear =currentDate.getYear();
        int numOfCover=0;
        for(Order order:getOrders()){
            if(currentMonth==order.getDate().getMonth() && currentYear==order.getDate().getYear()){
                for (Product product : order.getProducts()) {
                    if (product.getCategory() == Category.COVER) {
                        if(product.getCover()== SizeOfCover.KING) {
                            numOfCover++;
                        }
                    }
                }
            }
        }
        numCover= najah.edu.BusinessReport.numberOfCoverInThisMonth();
        assertEquals(numOfCover,numCover[1]);
    }

    @Given("that needs the number of covers size Queen in all orders in this month")
    public void thatNeedsTheNumberOfCoversSizeQueenInAllOrdersInThisMonth() {
        orders=new ArrayList<>();
    }

    @Then("calculate number of covers size Queen in all orders in this month")
    public void calculateNumberOfCoversSizeQueenInAllOrdersInThisMonth() {
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();
        int currentYear =currentDate.getYear();
        int numOfCover=0;
        for(Order order:getOrders()){
            if(currentMonth==order.getDate().getMonth() && currentYear==order.getDate().getYear()){
                for (Product product : order.getProducts()) {
                    if (product.getCategory() == Category.COVER) {
                        if(product.getCover()== SizeOfCover.QUEEN) {
                            numOfCover++;
                        }
                    }
                }
            }
        }
        numCover= najah.edu.BusinessReport.numberOfCoverInThisMonth();
        assertEquals(numOfCover,numCover[2]);
    }

    @Given("that needs the number of covers size TWIN_XL in all orders in this month")
    public void thatNeedsTheNumberOfCoversSizeTwin_XLInAllOrdersInThisMonth() {
        orders=new ArrayList<>();
    }

    @Then("calculate number of covers size TWIN_XL in all orders in this month")
    public void calculateNumberOfCoversSizeTwin_XLInAllOrdersInThisMonth() {
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();
        int currentYear =currentDate.getYear();
        int numOfCover=0;
        for(Order order:getOrders()){
            if(currentMonth==order.getDate().getMonth() && currentYear==order.getDate().getYear()){
                for (Product product : order.getProducts()) {
                    if (product.getCategory() == Category.COVER) {
                        if(product.getCover()== SizeOfCover.TWIN_XL) {
                            numOfCover++;
                        }
                    }
                }
            }
        }
        numCover= najah.edu.BusinessReport.numberOfCoverInThisMonth();
        assertEquals(numOfCover,numCover[3]);
    }

    @Given("that needs the number of covers size TWIN in all orders in this month")
    public void thatNeedsTheNumberOfCoversSizeTwinInAllOrdersInThisMonth() {
        orders=new ArrayList<>();
    }

    @Then("calculate number of covers size TWIN in all orders in this month")
    public void calculateNumberOfCoversSizeTwinInAllOrdersInThisMonth() {
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();
        int currentYear =currentDate.getYear();
        int numOfCover=0;
        for(Order order:getOrders()){
            if(currentMonth==order.getDate().getMonth() && currentYear==order.getDate().getYear()){
                for (Product product : order.getProducts()) {
                    if (product.getCategory() == Category.COVER) {
                        if(product.getCover()== SizeOfCover.TWIN) {
                            numOfCover++;
                        }
                    }
                }
            }
        }
        numCover= najah.edu.BusinessReport.numberOfCoverInThisMonth();
        assertEquals(numOfCover,numCover[4]);
    }

    @Given("that needs the number of covers size CRIB in all orders in this month")
    public void thatNeedsTheNumberOfCoversSizeCribInAllOrdersInThisMonth() {
        orders=new ArrayList<>();
    }

    @Then("calculate number of covers size CRIB in all orders in this month")
    public void calculateNumberOfCoversSizeCribInAllOrdersInThisMonth() {
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();
        int currentYear =currentDate.getYear();
        int numOfCover=0;
        for(Order order:getOrders()){
            if(currentMonth==order.getDate().getMonth() && currentYear==order.getDate().getYear()){
                for (Product product : order.getProducts()) {
                    if (product.getCategory() == Category.COVER) {
                        if(product.getCover()== SizeOfCover.CRIB) {
                            numOfCover++;
                        }
                    }
                }
            }
        }
        numCover= najah.edu.BusinessReport.numberOfCoverInThisMonth();
        assertEquals(numOfCover,numCover[5]);
    }
}
