package Models;

public class Stunden {
    private String stundenName;
    private String lehrer;

    public Stunden(String stundenName, String lehrer) {
        this.stundenName = stundenName;
        this.lehrer = lehrer;
    }

    public String getStundenName() {
        return stundenName;
    }

    public void setStundenName(String stundenName) {
        this.stundenName = stundenName;
    }

    public String getLehrer() {
        return lehrer;
    }

    public void setLehrer(String lehrer) {
        this.lehrer = lehrer;
    }


    @Override
    public String toString() {
       return "Stunde: " + this.stundenName + "\nLehrer: " + this.lehrer + "\n\n";
    }
}
