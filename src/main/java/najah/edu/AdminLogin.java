package najah.edu;

import entities.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.RandomAccessFile;
import java.util.*;
import java.util.logging.Logger;

public class AdminLogin {
    Admin admin=new Admin();
    Logger logger = Logger.getLogger(AdminLogin.class.getName());
    public void setEmail(String email) {
        this.admin.setEmail(email);
    }

    public void adminMenu() {
        logger.info("To see all customers details enter number 1 ");
        logger.info("To see all workers details enter number 2 ");
        logger.info("To see all orders details enter number 3 ");
        logger.info("To add new order enter number 4");
        logger.info("To logout enter number 5");
    }
    public void customerMenu() {
        while (true) {
            logger.info("If you want to add new customer enter number 1");
            logger.info("If you want to delete customer enter number 2");
            logger.info("If you want to contact customer enter number 3");
            logger.info("If you want to back enter number 4");
            Scanner in = new Scanner(System.in);
            int x = 0;
            try {
                x = in.nextInt();
                if (x < 1 || x > 4) {
                    logger.info("Enter valid number");
                    customerMenu();
                }
                if(x==4){
                    break;
                }
            } catch (Exception ignored) {
                logger.info("Enter valid number");
                customerMenu();
            }
            customerOptions(x);
        }
    }
    private void customerOptions(int option) {
        if(option==1){
            RecordCustomer customer=new RecordCustomer();
            customer.newCustomer();

        } else if (option==2) {
            deleteCustomer();
        }
    }
    public void deleteCustomer() {
        logger.info("Enter the ID of the customer you want to delete ");
        Scanner in=new Scanner(System.in);
        Customer customer=new Customer();
        try {
            int id=in.nextInt();
            Data.getCustomerById(id);
            customer.setId(id);
        }
        catch (InputMismatchException e){
            logger.info("Invalid Input, try again");
            deleteCustomer();
        }
        deleteCustomer(customer);
    }
    public void deleteCustomer(Customer customer){
        int flag=0;
        List<Customer>customers=Data.getCustomers();
        for(Customer customer1:customers){
            if(customer1.equals(customer)){
                customers.remove(customer1);
                flag=1;
                break;
            }
        }
        if(flag==1) {
            Data.updateCustomers(customers);
            logger.info("The customer removed successfully");
        }
        else {
            logger.info("This Customer is not exist in our customers");
        }

    }
    public void orderMenu() {
        while (true) {
            logger.info("If you want to change the order status enter number 1");
            logger.info("If you want to invoice the order enter number 2");
            logger.info("If you want to back enter number 3");
            Scanner in = new Scanner(System.in);
            int x = 0;
            try {
                x = in.nextInt();
                if (x < 1 || x > 3) {
                    logger.info("Enter valid number");
                    orderMenu();
                }
                if(x==3){
                    break;
                }
            } catch (Exception ignored) {
                logger.info("Enter valid number");
                orderMenu();
            }
            orderOptions(x);
        }
    }

    public void orderOptions(int x) {
        Scanner in=new Scanner(System.in);
        if(x==1){
            logger.info("Enter the order number you want to change it's status  ");
            int orderId=in.nextInt();
            logger.info("Enter the new status for this order ");
            String status=in.next();
            changeStatus(orderId,status);
        }
        else if (x==2) {
            logger.info("Enter the order ID you want to invoice ");
            int id=in.nextInt();
            if(isExistOrder(id)){
                invoice(Data.getOrderByID(id));
            }
            else {
                logger.info("This Id is not exist try again");
            }
        }

    }

    public boolean isExistOrder(int id) {
        Order order=Data.getOrderByID(id);
        return order.getId()==id;
    }

    public void changeStatus(int orderId,String status){
        List<Order>orders=Data.getOrders();
        Customer customer=new Customer();
        for (Order order:orders) {
            if (order.getId() == orderId) {
                customer=order.getCustomer();
                order.setStatus(status);
                break;
            }
        }
        Data.updateOrders(orders);
        notifyCustomer(customer);

    }

    public void adminOptions(int option){
        if (option == 1) {
            List<Customer> customers = Data.getCustomers();
            logger.info("****************************************************Customers**********************************************************");
            logger.info("ID               Name                                Email                           Mobile Number" +
                    "                        Address  " +
                    "");
            for (Customer customer : customers) {
                logger.info(customer.getId() + "\t\t\t\t" +customer.getFullName() + getSpaces(customer.getFullName()) + customer.getEmail() + getSpaces(customer.getEmail())
                        + customer.getPhone() + getSpaces(customer.getPhone()) + customer.getAddress()
                );
            }
            customerMenu();

        }

        else if (option == 3) {
            logger.info("********************************************************************************************************************************");
            logger.info("Order ID\tCustomer Name\t\tOrder Date\t\t\tTotal Coast\t\tOrder Status\nProducts: ");
            for (Order order:Data.getOrders()){
                logger.info(order.getId()+"\t\t"+order.getCustomer().getFullName()+getSpaces(order.getCustomer().getFullName())+order.getDate()+getSpaces(String.valueOf(order.getDate()))+order.getTotal()+"\t"+
                        order.getStatus()+getSpaces(order.getStatus()));
                for(Product product:order.getProducts()){
                    //System.out.println(product.getCategory()+"\t"+product.getName()+"\t"+product.getDescription());
                    System.out.println(product);
                }
                logger.info("********************************************************************************************************************************");
            }
            orderMenu();

        }
        else if (option == 4) {
            takeOrder();
        }
    }
    public void adminPage(){
        Scanner in=new Scanner(System.in);
        while (true) {
            try {
                adminMenu();
                int option = in.nextInt();
                if(option==5){
                    logger.info("Goodbye");
                    break;
                }
                adminOptions(option);

            } catch (Exception e) {
                logger.info("Enter a valid option number ");
                adminPage();
            }


        }
    }

    public boolean isExistCustomer(int id){
        int flag=0;
        for(Customer customer:Data.getCustomers()){
            if(customer.getId()==id){
                flag=1;
                break;
            }
        }
        return flag==1;
    }
    public void takeOrder(){
        Scanner in=new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        Order order;
        while (true) {
            Product product=RecordProduct.NewProduct();
            products.add(product);
            logger.info("Do you want to add another product to this order? \"yes or no\"");
            String ans = in.nextLine();
            if (ans.equalsIgnoreCase("no")) {
                break;
            }
        }
        order=new Order(products,"waiting");
        logger.info("Enter the customer name or customer email ");
        Customer customer=Data.getCustomerBy(in.nextLine());
        if(customer.getId()==0){
            logger.info("This Customer is new customer, so you have to enter his information ");
            RecordCustomer recordCustomer=new RecordCustomer();
            recordCustomer.newCustomer();
        }
        order.setCustomer(customer);
        logger.info("The total is:"+order.getTotal());
        logger.info("The new total with discount is:");//TODO
        addOrder(order);
    }
    public void addOrder(Order order) {
        ProductFile.storeProducts(order.getProducts());
        try{
            RandomAccessFile raf = new RandomAccessFile("src/main/resources/Back/Orders.txt", "rw");
            raf.seek(raf.length());
            raf.writeBytes(order.getId()+","+order.getCustomer().getId()+","+order.getDate()+","+order.getTotal()+","+order.getStatus()+ "," );
            for(Product product:order.getProducts()){
                raf.writeBytes(product.getName()+" ");
            }
            raf.writeBytes("\r\n");
            raf.close();
            logger.info("The Order Added Successfully");
        }
        catch(Exception e){
            logger.info("Error");
        }
    }

    public void notifyCustomer(Customer customer) {
        final String user = "rubasalon5@gmail.com";
        final String password = "wntxcpwbkocnjjdm";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
                        return new javax.mail.PasswordAuthentication(user,password);
                    }

                });
        try {
            Message message1 = new MimeMessage(session);
            message1.setFrom(new InternetAddress(user));
            message1.setRecipient(Message.RecipientType.TO, new InternetAddress(customer.getEmail()));
            message1.setSubject("Complete Order");
            message1.setText("Hello Mr/Ms "+customer.getFullName()+", your order is ready you can take it now");
            Transport.send(message1);

        } catch (Exception ignored) {

        }
    }

    public void invoice(Order order) {//TODO
        try {
            List<Order> list=Data.getOrders();
            JasperReport report= JasperCompileManager.compileReport("CSS.jrxml");
            Map<String,Object> parameters=new HashMap<>();
            parameters.put("name",order.getCustomer().getFullName());
            parameters.put("date",String.valueOf(order.getDate()));
            parameters.put("address",order.getCustomer().getAddress());
            parameters.put("total", list.get(0).getTotal());
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
    public String getSpaces(String att){
        return " ".repeat(Math.max(0, 35 - att.length()));
    }
}
