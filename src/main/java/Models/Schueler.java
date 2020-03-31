package Models;

import java.time.LocalDate;

public class Schueler {
    private String firstName;
    private String lastName;

    // I will get date from the api in this format as String: "2003-03-29" and then i have to convert it in localdate
    private LocalDate birthDate;
    private String email;

    // Have to storage an img, but dont know how


    public Schueler(String firstName, String lastName, String birthDate, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = convertStringToDate(birthDate);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
