package Searching;

import Models.Lehrer;
import Models.Schueler;
import Models.Stunden;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Search {

    public static List<Lehrer> searchLehrer(String attr, List<Lehrer> lehrerList){
        List<Lehrer> lehrerOK = new ArrayList<>();
        String regex = ".*" + attr + ".*";
        for (Lehrer l: lehrerList) {
            if(Pattern.matches(regex, l.toString())){
                lehrerOK.add(l);
            }
        }
        return lehrerOK;
    }

    public static List<Schueler> searchSchueler(String attr, List<Schueler> schuelerList){
        List<Schueler> schuelerOK = new ArrayList<>();
        String regex = ".*" + attr + ".*";
        for (Schueler l: schuelerList) {
            if(Pattern.matches(regex, l.toString())){
                schuelerOK.add(l);
            }
        }
        return schuelerOK;
    }
    public static List<Stunden> searchStunden(String attr, List<Stunden> stundenList){
        List<Stunden> stundenOK = new ArrayList<>();
        String regex = ".*" + attr + ".*";
        for (Stunden l: stundenList) {
            if(Pattern.matches(regex, l.toString())){
                stundenOK.add(l);
            }
        }
        return stundenOK;
    }
}
