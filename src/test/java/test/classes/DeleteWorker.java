package test.classes;

import entities.Data;
import entities.Worker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteWorker {
    AdminLogin admin;
    Worker worker;
    List<Worker>workers;
    @Given("I choose to delete worker")
    public void i_choose_to_delete_worker() {
       admin=new AdminLogin();
       worker=new Worker();
       workers= Data.getWorkers();
    }
int id;
    @When("I enter the worker Id={string}")
    public void i_enter_the_worker_id(String id) {
        this.id=Integer.parseInt(id);
      worker.setId(Integer.parseInt(id));
    }
    @Then("the worker deleted successfully")
    public void the_worker_deleted_successfully() {
        assertTrue(worker.isExistWorker());
        for (Worker worker1:workers){
            if(worker1.getId()==worker.getId()){
                workers.remove(worker1);
                break;
            }
        }
        assertFalse(workers.contains(worker));

    }
    @Then("The message {string} will be shown")
    public void the_message_will_be_shown(String msg) {
        assertFalse(worker.isExistWorker());
        assertEquals(0,Data.getWorkerById(id).getId());
        assertEquals("This worker doesn't exist",msg);
        System.out.println(msg);
    }

}
