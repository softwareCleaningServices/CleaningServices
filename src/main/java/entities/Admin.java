package entities;

import java.util.Objects;

public class Admin {
    private String email;

    public Admin() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        if (!Objects.equals(email, admin.email)) return false;
        return Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String name) {
        this.email = name;
    }
}
