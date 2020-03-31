package Models;

public class Stunden {
    private String stundenName;
    private Lehrer lehrer;

    public Stunden(String stundenName, Lehrer lehrer) {
        this.stundenName = stundenName;
        this.lehrer = lehrer;
    }

    public String getStundenName() {
        return stundenName;
    }

    public void setStundenName(String stundenName) {
        this.stundenName = stundenName;
    }

    public Lehrer getLehrer() {
        return lehrer;
    }

    public void setLehrer(Lehrer lehrer) {
        this.lehrer = lehrer;
    }
}
