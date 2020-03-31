package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lehrer {
    private String firstName;
    private String lastName;

    // I will get date from the api in this format as String: "2003-03-29" and then i have to convert it in localdate
    private LocalDate birthDate;
    private List<Stunden> stundenList = new ArrayList<>();
    private String email;

    // Have to storage an img, but dont know how


    public Lehrer(String firstName, String lastName, String birthDate, List<Stunden> stundenList, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = convertStringToDate(birthDate);
        this.stundenList = stundenList;
        this.email = email;
    }


    public LocalDate convertStringToDate(String date){
        return LocalDate.parse(date);
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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
