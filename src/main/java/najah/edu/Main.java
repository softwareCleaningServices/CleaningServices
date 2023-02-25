package najah.edu;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        System.out.println("***************Welcome Back***************");
        while(true) {
            System.out.print("Enter your email ");
            String email = in.nextLine();
            System.out.print("Enter your password ");
            String password = in.nextLine();
            AdminLogin adminLogin = new AdminLogin();
            adminLogin.setPassword(password);
            adminLogin.setEmail(email);
            if (adminLogin.isCorrectInfo()) {
                adminLogin.adminOptions();
                break;
            } else {
                System.out.println("Incorrect user name or password try again");
            }
        }
    }
}
