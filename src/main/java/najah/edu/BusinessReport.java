package najah.edu;

import entities.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static entities.Data.*;

public class BusinessReport {
    private BusinessReport(){

    }
    public static int numberOfAllCustomers(){
        List<Customer>customers=getCustomers();
        return customers.size();
    }
    public static int[] numberOfAllWorker(){
        List<Worker> workers=getWorkers();
        int []numWorker=new int[4];
        for (Worker worker:workers) {
            numWorker[0]++;
            if(worker.getCategory() == Category.SOFA){
                numWorker[1]++;
            } else if (worker.getCategory() == Category.CARPET) {
                numWorker[2]++;
            }else if (worker.getCategory() == Category.COVER) {
                numWorker[3]++;
            }
        }
        return numWorker;
    }
    public static List<Order> allOrdersInThisMonth(){
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();
        int currentYear =currentDate.getYear();
        List<Order> orders=new ArrayList<>();
        for(Order order:getOrders()){
            if(currentMonth==order.getDate().getMonth() && currentYear==order.getDate().getYear()){
                orders.add(order);
            }
        }
        return orders;
    }
    public static int numberOfAllOrdersInThisMonth(){
        List<Order> orders=allOrdersInThisMonth();
        return orders.size();
    }
    public static int numberOfSofaInThisMonth(){
        List<Order> orders=allOrdersInThisMonth();
        int numSofa = 0;
        for(Order order:orders) {
            for (Product product : order.getProducts()) {
                if (product.getCategory() == Category.SOFA) {
                    numSofa += product.getNumOfSofa();
                }
            }
        }
        return numSofa;
    }
    public static int numberOfCarpetInThisMonth(){
        List<Order> orders=allOrdersInThisMonth();
        int numCarpet = 0;
        for(Order order:orders) {
            for (Product product : order.getProducts()) {
                if (product.getCategory() == Category.CARPET) {
                    numCarpet += product.getDimension();
                }
            }
        }
        return numCarpet;
    }
    public static int[] numberOfCoverInThisMonth(){
        List<Order> orders=allOrdersInThisMonth();
        int []numCover=new int[6];
        for(Order order:orders) {
            for (Product product : order.getProducts()) {
                if (product.getCategory() == Category.COVER) {
                    numCover[0]++;
                    if(product.getCover()== SizeOfCover.KING){
                        numCover[1]++;
                    } else if (product.getCover()== SizeOfCover.QUEEN) {
                        numCover[2]++;
                    }else if (product.getCover()== SizeOfCover.TWIN_XL){
                        numCover[3]++;
                    } else if (product.getCover()== SizeOfCover.TWIN) {
                        numCover[4]++;
                    } else if (product.getCover()== SizeOfCover.CRIB) {
                        numCover[5]++;
                    }

                }
            }
        }
        return numCover;
    }
}
