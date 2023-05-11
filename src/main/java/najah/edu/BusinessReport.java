package najah.edu;

import entities.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static entities.Data.*;

public class BusinessReport {
    static Logger logger = Logger.getLogger(BusinessReport.class.getName());
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
            }else{
                numWorker[3]++;
            }
        }
        return numWorker;
    }
    public static List<Order> allOrdersInThisMonth(int month,int year){
        List<Order> orders=new ArrayList<>();
        for(Order order:getOrders()){
            if(Month.of(month) ==order.getDate().getMonth() && year ==order.getDate().getYear()){
                orders.add(order);
            }
        }
        return orders;
    }
    public static int numberOfAllOrdersInThisMonth(int month,int year){
        List<Order> orders=allOrdersInThisMonth(month,year);
        return orders.size();
    }
    public static int numberOfSofaInThisMonth(int month,int year){
        List<Order> orders=allOrdersInThisMonth(month,year);
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
    public static int numberOfCarpetInThisMonth(int month,int year){
        List<Order> orders=allOrdersInThisMonth(month,year);
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
    public static int[] numberOfCoverInThisMonth(int month,int year){
        List<Order> orders=allOrdersInThisMonth(month,year);
        int []numCover=new int[6];
        for (int i=0;i<=5;i++){
            numCover[i]=0;
        }
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
                    } else {
                        numCover[5]++;
                    }
                }
            }
        }
        return numCover;
    }
    public static void businessReport() {
        try {
            List<Order> list=Data.getOrders();
            JasperReport report= JasperCompileManager.compileReport("report.jrxml");
            Map<String,Object> parameters=new HashMap<>();
            LocalDate today = LocalDate.now();
            int month=today.getMonthValue();
            int year=today.getYear();
            parameters.put("all_customers",numberOfAllCustomers());
            int []peopleWork=numberOfAllWorker();
            parameters.put("all_workers",peopleWork[0]);
            parameters.put("sofas_worker",peopleWork[1]);
            parameters.put("carpet_worker",peopleWork[2]);
            parameters.put("cover_worker",peopleWork[3]);
            parameters.put("all_order",numberOfAllOrdersInThisMonth(month,year));
            parameters.put("sofa_order",numberOfSofaInThisMonth(month,year));
            parameters.put("carpet_order",numberOfCarpetInThisMonth(month,year));
            int[]cover=numberOfCoverInThisMonth(month,year);
            parameters.put("cover_order",cover[0]);
            parameters.put("king_order",cover[1]);
            parameters.put("queen_order",cover[2]);
            parameters.put("twin_xl_order",cover[3]);
            parameters.put("twin_order",cover[4]);
            parameters.put("crib_order",cover[5]);
            JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(list);
            JasperPrint print= JasperFillManager.fillReport(report,parameters,dataSource);
            JasperViewer.viewReport(print, false);
            JasperExportManager.exportReportToPdfFile(print,"C:\\Users\\Administrator\\JaspersoftWorkspace\\rep.pdf");
        } catch (JRException ignored) {
            logger.info("Can't generate report");
        }
    }
}
