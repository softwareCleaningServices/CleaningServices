package najah.edu;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static int menu(){
        System.out.println("Welcome to AR-Cleaning Services System");
        Scanner in=new Scanner(System.in);
        int option;
        try {
            System.out.println("If you want to login enter number 1");
            System.out.println("If you are new customer enter number 2");
            option = in.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("please enter a valid number");
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
        }
    }


    public static void userLogin(){

        Scanner in=new Scanner(System.in);
        System.out.println("***************Welcome Back***************");
        while(true) {
            System.out.print("Enter your email ");
            String email = in.nextLine();
            System.out.print("Enter your password ");
            String password = in.nextLine();
            Login login=new Login();
            login.setEmail(email);
            login.setPassword(password);
            if(login.isCorrectInfo()){
                break;
            }
            else {
                System.out.println("Incorrect user name or password, try again");
            }

        }
    }
}
