package najah.edu;

import entities.Data;
import entities.Product;
import entities.Worker;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.List;

import static najah.edu.Main.logger;

public class DistributeOrder {

    public static Worker getWorker(Product product){
        List<Worker>workers=Data.getWorkers();
        System.out.println(workers.size());
        int min=workers.get(0).getNumOfProd();
        Worker worker=workers.get(0);
        int ind=0;
        for (Worker worker1:workers){
            if(worker1.getCategory().equals(product.getCategory().toString())){
                System.out.println(worker1);
                if(min>worker1.getNumOfProd()) {
                    worker = worker1;
                    ind=workers.indexOf(worker1);
                }            }
        }
        workers.get(ind).setNumOfProd();
        updateWorkerFile(workers);
        return worker;
    }

    public static void updateWorkerFile(List<Worker>workers){
        try (
            RandomAccessFile raf = new RandomAccessFile("src/main/resources/Back/Worker.txt", "rw");
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/Back/Worker.txt"))){
                writer.write("");
                writer.flush();
            for (Worker worker : workers) {
                raf.seek(raf.length());
                raf.write(worker.toString().getBytes());
            }
        }
        catch(Exception e){
            logger.info("Error");
        }
    }
}
