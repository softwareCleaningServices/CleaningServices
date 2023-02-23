package entities;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private int id;
    private String fName;
    private String lName;
    private Customer existCustomer;
    private String email;
    private String city;
    private String street;
    private String phone;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer(int id, String fName, String lName, String email, String phone, String city, String street) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.email = email;
    }
    public Customer() {
    }



    public boolean isTakenEmail(){
        ArrayList<Customer> customers;
        customers= Data.getCustomers();
        int flag=0;
        for (Customer customer : customers) {
            if (customer.getEmail().equals(this.getEmail())) {
                flag = 1;
                existCustomer=customer;
                break;
            }
        }
        return flag == 1;

    }


    public boolean isValidEmail() {
        String emailRegex= "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat=Pattern.compile (emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher=emailPat.matcher (this.getEmail());
        return matcher.find();
    }

    @Override
    public String toString() {
        return
                 id +
                "\t " + fName +
                "\t " + lName +
                "\t " + phone +
                "\t " + city +
                "\t " + street +
                "\t " + email ;
    }

    public void sendConfirmationEmail() {
        final String user = "rubasalon5@gmail.com";
        final String password = "wntxcpwbkocnjjdm";
        String to = this.getEmail();
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
            message1.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message1.setSubject("Sign Up");
            message1.setText("Hello You are Signed-Up to Cleaning System Company Welcome to our application");
            Transport.send(message1);
            System.out.println("We send a confirmation message to customer on email");

        } catch (Exception ignored) {

        }
    }

    public Customer getCustomerDetails() {
        return existCustomer;
    }

    public void storeCustomer(Customer customer) {
        try{
            RandomAccessFile raf = new RandomAccessFile("Customer.txt", "rw");
            raf.seek(raf.length());
                raf.writeBytes(customer.getfName() + " " + customer.getlName() + " " + customer.getEmail() + " " + customer.getPhone() + " " +
                        customer.getCity() + " " + customer.getStreet()+ "\r\n");

            raf.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }

    }
}
