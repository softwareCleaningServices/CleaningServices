package entities;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private int id;
    private String fullName;
    private Customer existCustomer;
    private String password;
    private String email;
    private String address;
    private String phone;
    Logger logger = Logger.getLogger(Customer.class.getName());
    public int getId() {
        return id;
    }
    public String getPhone() {
        return phone;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        if (!Objects.equals(email, customer.email)) return false;

        return Objects.equals(id, customer.id);
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Customer(int id,String fullName, String email, String phone, String address,String password) {
        this.id =id;
        this.fullName=fullName;
        this.address=address;
        this.phone = phone;
        this.email = email;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public Customer(String fullName, String email, String phone, String address, String password){
        this.id =Data.getId();
        this.fullName=fullName;
        this.address=address;
        this.phone = phone;
        this.email = email;
        this.password=password;
    }


    public Customer() {
    }


    @Override
    public String toString() {
        return  id +
                "," + fullName +
                ","  +email+
                "," + phone +
                "," + address +
                "," + password +"\r\n";
    }

    public boolean isTakenEmail(){
        List<Customer> customers;
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

    public void sendEmail(String title,String message,String msg){
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
            message1.setSubject(title);
            message1.setText(message);
            Transport.send(message1);
            logger.info(msg);
        } catch (Exception ignored) {

        }
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (existCustomer != null ? existCustomer.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (logger != null ? logger.hashCode() : 0);
        return result;
    }

    public Customer getCustomerDetails() {
        return existCustomer;
    }

}
