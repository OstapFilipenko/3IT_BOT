package gettingDatas;

import Models.Stunden;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class allStunden {
    public static List<Stunden> getAllStunden() throws IOException {
        File file  = new File("C:\\HTL\\3-Klasse\\NTVS\\BOT\\NTVS_3IT_BOT\\src\\main\\resources\\Stunden.json");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String result = "";
        String st;
        List<Stunden> alleStunden = new ArrayList<>();
        while ((st = br.readLine()) != null){
            result += st;
        }

    JSONArray jsonArray = new JSONArray(result);
        jsonArray.forEach(jsonObject -> {
            JSONObject stunde = (JSONObject) jsonObject;
            alleStunden.add(new Stunden(stunde.getString("lessonName"), stunde.getString("teacher")));
        });
        return alleStunden;
    }
}
