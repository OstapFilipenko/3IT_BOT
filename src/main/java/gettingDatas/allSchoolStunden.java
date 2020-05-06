package gettingDatas;


import Models.SchoolLesson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class allSchoolStunden {
    public static List<SchoolLesson> getAllSchoolLessons() throws IOException {
        File file  = new File("C:\\HTL\\3-Klasse\\NTVS\\BOT\\JSON_Files\\SchoolLessons.json");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String result = "";
        String st;
        List<SchoolLesson> alleSchoolLessons = new ArrayList<>();
        while ((st = br.readLine()) != null){
            result += st;
        }


        JSONArray jsonArray = new JSONArray(result);
        jsonArray.forEach(jsonObject -> {
            JSONObject schoolLesson = (JSONObject) jsonObject;
            alleSchoolLessons.add(new SchoolLesson(schoolLesson.getString("name"), schoolLesson.getString("lehrer"), schoolLesson.getString("start"), schoolLesson.getString("end"), schoolLesson.getString("day")));
        });
        return alleSchoolLessons;
    }
}
