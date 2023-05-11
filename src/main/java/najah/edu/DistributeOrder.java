package najah.edu;

import entities.Worker;

import java.util.ArrayList;
import java.util.List;

public class DistributeOrder {
    private DistributeOrder(){
    }
    public static List<Integer> distributeOrder(List<Order> orders, List<Worker> workers) {
        List<Integer>workersId=new ArrayList<>();
        int numOrders=orders.size();
        int numWorkers=workers.size();
        if (numWorkers == 0)
            return new ArrayList<>();
        else if (numOrders==0) {
            return new ArrayList<>();
        }

        else {
            int ind=0;
            for (Order order:orders){
                order.setWorker(workers.get(ind));
                workersId.add(workers.get(ind).getId());
                if(ind == workers.size()-1){
                    ind=0;
                }
                else ind++;
            }

        }
        return workersId;
    }
}
