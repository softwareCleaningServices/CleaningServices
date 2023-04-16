package najah.edu;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());
    public static int menu(){
        logger.info("Welcome to AR-Cleaning Services System");
        Scanner in=new Scanner(System.in);
        int option;
        try {
            logger.info("If you want to login enter number 1");
            logger.info("If you are new customer enter number 2");
            option = in.nextInt();
        }
        catch (InputMismatchException e){
            logger.info("please enter a valid number");
            option= menu();
        }
        return option;
    }

    public static void main(String[]args){
        int option=menu();
        if(option==1){
            userLogin();
        }
        else {
            RecordCustomer recordCustomer=new RecordCustomer();
            recordCustomer.newCustomer();
            userLogin();
        }

    }

    public static void userLogin(){

        Scanner in=new Scanner(System.in);
        logger.info("***************Welcome Back***************");
        while(true) {
            logger.info("Enter your email ");
            String email = in.nextLine();
            logger.info("Enter your password ");
            String password = in.nextLine();
            Login login=new Login();
            login.setEmail(email);
            login.setPassword(password);
            if(login.isCorrectInfo()){
                login.login();
                break;
            }
            else {
                logger.info("Incorrect user name or password, try again");
            }

        }
    }
}