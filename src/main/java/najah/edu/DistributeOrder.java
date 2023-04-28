package najah.edu;

import entities.Data;
import entities.Worker;

import java.util.ArrayList;
import java.util.List;

public class DistributeOrder {
    private DistributeOrder(){
        //not used
    }
    public static Worker getWorker(Order order){
        List<Order>orders=Data.getOrders();
        orders.add(order);
        Worker worker=new Worker();
        List<Integer> ids=distributeOrder(orders,Data.getWorkers());
        for (Integer id:ids){
            worker=Data.getWorkerById(id);
            if (order.getStatus().equals("waiting")){
                order.setWorker(worker);
            }
        }
        return worker;
    }
    public static List<Integer> distributeOrder(List<Order> orders, List<Worker> workers) {
        List<Integer>workersId=new ArrayList<>();
        int numOrders=orders.size();
        int numWorkers=workers.size();
        if (numWorkers == 0)
            return workersId;
        else if (numOrders == 0)
            return workersId;
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
