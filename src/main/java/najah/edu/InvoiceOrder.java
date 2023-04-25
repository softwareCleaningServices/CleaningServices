package najah.edu;

import entities.Data;
import entities.ProductFile;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static najah.edu.Main.logger;

public class InvoiceOrder {
    Order order;
    public InvoiceOrder(){
        //not used
    }
    public static void invoice(Order order, double total) {
        try {
            List<Order> list= Data.getOrders();
            JasperReport report= JasperCompileManager.compileReport("CSS.jrxml");
            Map<String,Object> parameters=new HashMap<>();
            parameters.put("name",order.getCustomer().getFullName());
            parameters.put("date",String.valueOf(order.getDate()));
            parameters.put("address",order.getCustomer().getAddress());
            parameters.put("tot", total);
            parameters.put("total", ProductFile.totalAfterDiscount(order));
            parameters.put("discount", (int)(ProductFile.discount(order.getTotal())*100)+"%");
            StringBuilder prod= new StringBuilder();
            StringBuilder coast= new StringBuilder();
            for(int i=0;i<order.getProducts().size();i++){
                prod.append(order.getProducts().get(i).getName()).append("\n\n");
                coast.append(order.getProducts().get(i).getCost()).append("\n\n");
            }
            parameters.put("product", prod.toString());
            parameters.put("price", coast.toString());
            JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(list);

            JasperPrint print= JasperFillManager.fillReport(report,parameters,dataSource);
            JasperViewer.viewReport(print, false);
            JasperExportManager.exportReportToPdfFile(print,"C:\\Users\\Administrator\\JaspersoftWorkspace\\out.pdf");

        } catch (Exception e) {
            logger.info("Can't generate report");
        }
    }
    public void setOrder(Order order) {
        this.order=order;
    }
}
