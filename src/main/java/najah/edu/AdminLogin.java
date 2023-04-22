package najah.edu;

import entities.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import java.util.*;
import java.util.logging.Logger;

public class AdminLogin {
    Admin admin=new Admin();
    Logger logger = Logger.getLogger(AdminLogin.class.getName());
    String msg="Enter valid number";
    private boolean logged;

    public void setEmail(String email) {
        this.admin.setEmail(email);
    }

    public void adminMenu() {
        logger.info("To see all customers details enter number 1 ");
        logger.info("To see all workers details enter number 2 ");
        logger.info("To see all orders details enter number 3 ");
        logger.info("To add new order enter number 4");
        logger.info("To generate report about financial information  enter number 5");
        logger.info("To update the cost of category enter 6");
        logger.info("To logout enter number 7");
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
                    logger.info(msg);
                    customerMenu();
                }
                if(x==4){
                    break;
                }
            } catch (Exception ignored) {
                logger.info(msg);
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
           customer=Data.getCustomerById(id);

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
                    logger.info(msg);
                    orderMenu();
                }
                if(x==3){
                    break;
                }
            } catch (Exception ignored) {
                logger.info(msg);
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
                Order order=Data.getOrderByID(id);
                List<Order>orders=Data.getOrders();
                for (Order order1:orders){
                    if(order1.getId()==id) {
                        order1.setPaid(true);
                    break;
                    }
                }
                Data.updateOrders(orders);
                invoice(order);
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

        else if (option==2) {
            printWorkers();
        }
        else if (option == 3) {
            logger.info("********************************************************************************************************************************");
            logger.info("Order ID\tCustomer Name\t\tOrder Date\t\t\tTotal Coast\t\tOrder Status\nProducts: ");
            for (Order order:Data.getOrders()){
                logger.info(order.getString());
                logger.info("********************************************************************************************************************************");
            }
            orderMenu();

        }
        else if (option == 4) {
            takenOrder();
        } else if (option==5) {
            generateAbout();
        } else if (option==6) {
            ProductFile.updateCostOfCategory();
        }
    }
    public void printWorkers(){
        List<Worker> workers = Data.getWorkers();
        logger.info("****************************************************Customers**********************************************************");
        logger.info("ID               Name                                Email                           Mobile Number" +
                "                        Address  \t\t\t\t\t Category \t\tSalary\t\t Number of total product " +
                "");
        for (Worker worker:workers) {
            logger.info(worker.getId() + "\t\t\t\t" +worker.getName() + getSpaces(worker.getName()) + worker.getEmail() + getSpaces(worker.getEmail())
                    + worker.getPhone() + getSpaces(worker.getPhone()) + worker.getAddress()+getSpaces(worker.getAddress())+worker.getCategory()+getSpaces(String.valueOf(worker.getCategory()))+worker.getSalary()+
                    "\t\t"+worker.getNumOfProd()
            );
        }
        workerMenu();
    }

    private void workerMenu() {
        while (true) {
            logger.info("If you want to add new worker enter number 1");
            logger.info("If you want to delete worker enter number 2");
            logger.info("If you want to update worker information enter number 3");
            logger.info("If you want to back enter number 4");
            Scanner in = new Scanner(System.in);
            int x = 0;
            try {
                x = in.nextInt();
                if (x < 1 || x > 4) {
                    logger.info(msg);
                    workerMenu();
                }
                if (x == 4) {
                    break;
                }

            } catch (Exception ignored) {
                logger.info(msg);
                customerMenu();
            }

            workerOptions(x);
        }
    }

    public void workerOptions(int x) {
        if(x==1){
            recordWorker();
        } else if (x==2) {
            deleteWorker();
        } else if (x==3) {
            updateWorker();
        }
    }

    private void updateWorker() {
        logger.info("Enter the ID of the worker you want to update his information ");
        Scanner in=new Scanner(System.in);
       Worker worker=new Worker();
       boolean flag=false;
       int id=0;
        try {
             id=in.nextInt();
            worker.setId(id);
            flag=worker.isExistWorker();

        }
        catch (InputMismatchException e){
            logger.info("Invalid Input, try again");
            updateWorker();
        }
        if(!flag){
            logger.info("This worker doesn't exist");
        }
        else {
            worker=Data.getWorkerById(id);
            updateWorker(worker);
        }

    }

    private void updateWorker(Worker worker) {
        logger.info("Enter The Attribute You Want to Update \" Phone, Address, Email, Salary \" ");
        Scanner in =new Scanner(System.in);
        String attribute=in.nextLine();
        if(!(attribute.equalsIgnoreCase("Phone")||attribute.equalsIgnoreCase("Email")||
                attribute.equalsIgnoreCase("Salary")||attribute.equalsIgnoreCase("Address"))){
            logger.info("This Attribute not allowed try again");
        }
        else{
            logger.info("Enter The New Value ");
            String value=in.nextLine();
            updateWorker(attribute,value,worker);
        }
    }

    public void updateWorker(String attribute, String value, Worker worker) {
        if(attribute.equalsIgnoreCase("Address")){
            worker.setAddress(value);
        } else if (attribute.equalsIgnoreCase("Phone")) {
            worker.setPhone(value);
        } else if (attribute.equalsIgnoreCase("Email")) {
            worker.setEmail(value);
        } else if (attribute.equalsIgnoreCase("Salary")) {
           worker.setSalary(Integer.parseInt(value));
        }
        List<Worker>workers=Data.getWorkers();
        for (Worker worker1:workers){
          int ind=  workers.indexOf(worker1);
            if(worker1.getId()==worker.getId()){
              workers.remove(ind);
              workers.add(ind,worker);
                break;
            }
        }

       Data.updateWorkers(workers);
    }

    public void deleteWorker() {
        logger.info("Enter the ID of the worker you want to delete ");
        Scanner in=new Scanner(System.in);
       Worker worker=new Worker();
       boolean flag=false;
        try {
            int id=in.nextInt();
            worker.setId(id);
             flag=worker.isExistWorker();

        }
        catch (InputMismatchException e){
            logger.info("Invalid Input, try again");
            deleteWorker();
        }
        if(flag){
          deleteWorker(worker);
        }
        else {
            logger.info(msg());
        }


    }
    public void deleteWorker(Worker worker) {
        List<Worker>workers=Data.getWorkers();
        for(Worker worker1:workers){
            if(worker1.getId()==worker.getId()){
               workers.remove(worker1);
               break;
            }
        }
        Data.updateWorkers(workers);
    }


    public void recordWorker() {
        Scanner in=new Scanner(System.in);
        Worker worker=new Worker();
        logger.info("Enter worker Name ");
        worker.setName(in.nextLine());
        logger.info("Enter worker Email ");
        worker.setEmail(in.nextLine());
        logger.info("Enter worker Phone ");
        worker.setPhone(in.nextLine());
        logger.info("Enter worker Address ");
        worker.setAddress(in.nextLine());
        logger.info("Enter worker Category ");
        worker.setCategory(Category.valueOf(in.nextLine().toUpperCase()));
        logger.info("Enter worker salary ");
        worker.setSalary(in.nextInt());
        worker.setId(Data.getWorkerId());
        System.out.println("Ok");
    addWorker(worker);
    }

    public void adminPage(){
        Scanner in=new Scanner(System.in);
        while (true) {
            try {
                adminMenu();
                int option = in.nextInt();
                if(option==7){
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
    public Order takeOrder(){
        Scanner in=new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        Order order;
        while (true) {
            Product product=RecordProduct.addAProduct();
            products.add(product);
            logger.info("Do you want to add another product to this order? \"yes or no\"");
            String ans = in.nextLine();
            if (ans.equalsIgnoreCase("no")) {
                break;
            }
        }
        order=new Order(products,"waiting");
        for (Product product:products){
            product.setOrderId(order.getId());
        }
        return order;
    }
    public void takenOrder(){
        Order order=takeOrder();
        Scanner in=new Scanner(System.in);
        logger.info("Enter the customer name or customer email ");
        Customer customer=Data.getCustomerBy(in.nextLine());
        if(customer.getId()==0){
            logger.info("This Customer is new customer, so you have to enter his information ");
            RecordCustomer recordCustomer=new RecordCustomer();
           customer= recordCustomer.newCustomer();
        }
        order.setCustomer(customer);
        logger.info("The total is:"+order.getTotal());
        logger.info("The new total with discount is:" + ProductFile.totalAfterDiscount(order));
        addOrder(order);
    }
    public void addOrder(Order order) {

          Data.storeObject("Orders",order);
            ProductFile.storeProducts(order.getProducts());
            logger.info("The Order Added Successfully");

    }

    public void notifyCustomer(Customer customer) {
        customer.sendEmail("Complete Order","Hello Mr/Ms "+customer.getFullName()+", your order is ready you can take it now","");

    }

    public void invoice(Order order) {
      InvoiceOrder.invoice(order,order.getTotal());
    }
    public String getSpaces(String att){
        return " ".repeat(Math.max(0, 35 - att.length()));
    }

    public void addWorker(Worker worker) {
        Data.storeObject("Worker",worker);
        logger.info("The worker added successfully");
    }

    public void notExistMsg() {
       logger.info("This Order is not exist on our orders");
    }

    public void setLogged(boolean b) {
        this.logged=b;
    }

    public void generateAbout() {
        try {
            List<Order> list=Data.getOrders();
            JasperReport report= JasperCompileManager.compileReport("About.jrxml");
            Map<String,Object> parameters=new HashMap<>();
            parameters.put("ordersNum",Data.getOrders().size());
            int complete=Data.getCountOrders("complete");
            int waiting=Data.getCountOrders("waiting");
            int paid=Data.getPaid(true);
            int debt=Data.getPaid(false);
            int cash=paid+debt;
            parameters.put("compOrders",complete);
            parameters.put("waiting",waiting);
            parameters.put("p",paid);
            parameters.put("d",debt);
            parameters.put("cash",cash);
            JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(list);
            JasperPrint print= JasperFillManager.fillReport(report,parameters,dataSource);
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            logger.info("Can't generate report");
        }
    }

    public boolean isLogged() {
        return logged;
    }


    public String msg() {
        return "This worker doesn't exist";
    }


}
