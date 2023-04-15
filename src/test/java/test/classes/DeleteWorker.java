package test.classes;

import entities.Worker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteWorker {
    AdminLogin admin;
    Worker worker;

    @Given("I choose to delete worker")
    public void i_choose_to_delete_worker() {
       admin=new AdminLogin();
       worker=new Worker();
    }

    @When("I enter the worker Id={string}")
    public void i_enter_the_worker_id(String id) {
      worker.setId(Integer.parseInt(id));
    }

    @Then("the worker deleted successfully")
    public void the_worker_deleted_successfully() {
      assertTrue(worker.isExistWorker());
      admin.deleteWorker(worker);
    }

    @Then("The message {string} will be shown")
    public void the_message_will_be_shown(String msg) {
        assertFalse(worker.isExistWorker());
        assertEquals(msg,admin.msg());
        System.out.println(msg);
    }

}
