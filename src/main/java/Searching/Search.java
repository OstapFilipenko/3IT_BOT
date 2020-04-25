package Searching;

import Models.Lehrer;
import Models.Schueler;
import Models.Stunden;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Search {

    public List<Lehrer> searchLehrer(String attr, List<Lehrer> lehrerList){
        List<Lehrer> lehrerOK = new ArrayList<>();
        String[] splited = attr.split(" ");
        for (Lehrer l: lehrerList) {
            if(Arrays.stream(splited).parallel().anyMatch(l.toString()::contains)){
                lehrerOK.add(l);
            }
        }
        return lehrerOK;
    }

    public List<Schueler> searchSchueler(String attr, List<Schueler> schuelerList){
        List<Schueler> schuelerOK = new ArrayList<>();
        String[] splited = attr.split(" ");
        for (Schueler l: schuelerList) {
            if(Arrays.stream(splited).parallel().anyMatch(l.toString()::contains)){
                schuelerOK.add(l);
            }
        }
        return schuelerOK;
    }
    public List<Stunden> searchStunden(String attr, List<Stunden> stundenList){
        List<Stunden> stundenOK = new ArrayList<>();
        String[] splited = attr.split(" ");
        for (Stunden l: stundenList) {
            if(Arrays.stream(splited).parallel().anyMatch(l.toString()::contains)){
                stundenOK.add(l);
            }
        }
        return stundenOK;
    }
}
