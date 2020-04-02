package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lehrer {
    private String firstName;
    private String lastName;
    private String kuerzel;


    private List<Stunden> stundenList = new ArrayList<>();
    private String email;

    // Have to storage an img, but dont know how


    public Lehrer(String firstName, String lastName, List<Stunden> stundenList, String email, String kuerzel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.stundenList = stundenList;
        this.email = email;
        this.kuerzel = kuerzel;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public List<Stunden> getStundenList() {
        return stundenList;
    }

    public void setStundenList(List<Stunden> stundenList) {
        this.stundenList = stundenList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
