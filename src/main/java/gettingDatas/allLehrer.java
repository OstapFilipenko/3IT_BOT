package gettingDatas;

import Models.Lehrer;
import Models.Schueler;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class allLehrer {
    public static List<Lehrer> getAllLehrer() throws IOException {
        File file  = new File("C:\\HTL\\3-Klasse\\NTVS\\BOT\\NTVS_3IT_BOT\\src\\main\\resources\\Lehrer.json");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String result = "";
        String st;
        List<Lehrer> alleLehrer = new ArrayList<>();
        while ((st = br.readLine()) != null){
            result += st;
        }

        JSONArray jsonArray = new JSONArray(result);
        jsonArray.forEach(jsonObject -> {
            JSONObject lehrer = (JSONObject) jsonObject;
            JSONArray stunden = (JSONArray) lehrer.get("stunden");
            List<String> subjects = new ArrayList<>();
            stunden.forEach(std->{
                JSONObject s = (JSONObject) std;
                subjects.add(s.get("stundenName").toString());
            });
            alleLehrer.add(new Lehrer(lehrer.getString("firstName"), lehrer.getString("lastName"), subjects, lehrer.get("email").toString(), lehrer.get("kuerzel").toString()));
        });
        return alleLehrer;
    }
}