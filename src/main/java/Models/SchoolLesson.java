package Models;

public class SchoolLesson {
    private String name;
    private String lehrer;
    private String start;
    private String end;
    private String day;

    public SchoolLesson(String name, String lehrer, String start, String end, String day) {
        this.name = name;
        this.lehrer = lehrer;
        this.start = start;
        this.end = end;
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLehrer() {
        return lehrer;
    }

    public void setLehrer(String lehrer) {
        this.lehrer = lehrer;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
    @Override
    public String toString() {
        String result = "";

        result += "Name: " + this.name + "\nLehrer: " + this.lehrer + "\nDay: "
                + this.day + "\nStart: " + this.start + "\nEnd: " + this.end + "\n\n" ;

        return result;
    }
}
