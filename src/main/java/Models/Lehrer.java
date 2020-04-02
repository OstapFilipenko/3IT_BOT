package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lehrer {
    private String firstName;
    private String lastName;
    private String kuerzel;


    private List<String> stundenList = new ArrayList<>();
    private String email;


    public Lehrer(String firstName, String lastName, List<String> stundenList, String email, String kuerzel) {
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


    public List<String> getStundenList() {
        return stundenList;
    }

    public void setStundenList(List<String> stundenList) {
        this.stundenList = stundenList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String result = "";
        String stunden = "";
        for (String s: this.stundenList) {
            stunden += "\n    " + s;
        }
        result += "Firstname: " + this.firstName + "\nLastname: " + this.lastName + "\nKürzel: "
                + this.kuerzel + "\nStunden: " + stunden + "\nEmail: " + this.email + "\n\n" ;

        return result;
    }
}
