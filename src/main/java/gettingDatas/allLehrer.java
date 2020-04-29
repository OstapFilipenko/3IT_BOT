package gettingDatas;

import Models.Lehrer;

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
        File file  = new File("C:\\HTL\\3-Klasse\\NTVS\\BOT\\JSON_Files\\Lehrer.json");
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
            alleLehrer.add(new Lehrer(lehrer.getString("firstName"), lehrer.getString("lastName"), lehrer.get("email").toString(), lehrer.get("kuerzel").toString()));
        });
        return alleLehrer;
    }
}
