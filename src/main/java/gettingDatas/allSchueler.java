package gettingDatas;

import Models.Schueler;
import Models.Stunden;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class allSchueler {
    public static List<Schueler> getAllSchueler() throws IOException {
        File file  = new File("C:\\HTL\\3-Klasse\\NTVS\\BOT\\JSON_Files\\Schueler.json");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String result = "";
        String st;
        List<Schueler> alleSchueler = new ArrayList<>();
        while ((st = br.readLine()) != null){
            result += st;
        }


        JSONArray jsonArray = new JSONArray(result);
        jsonArray.forEach(jsonObject -> {
            JSONObject schueler = (JSONObject) jsonObject;
            alleSchueler.add(new Schueler(schueler.getString("firstName"), schueler.getString("lastName"), schueler.get("email").toString()));
        });
        return alleSchueler;
    }

}
