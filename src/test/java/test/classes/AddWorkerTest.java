package test.classes;

import entities.Worker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;

import static org.junit.Assert.assertTrue;

public class AddWorkerTest {
Worker worker;
    AdminLogin admin=new AdminLogin();
    @Given("that the admin choose to add new worker")
    public void that_the_admin_choose_to_add_new_worker() {
        admin.adminOptions(3);
        worker=new Worker();
    }

    @When("the admin enter all the required data about worker")
    public void the_admin_enter_all_the_required_data_about_worker() {
    worker=new Worker(120,"Ali sami","059812345","Nablus","alisam@gmail.com",1500);
    }

    @Then("the worker added successfully")
    public void the_worker_added_successfully() {
    assertTrue(worker.isValidEmail());
    admin.addWorker(worker);
    }

}
