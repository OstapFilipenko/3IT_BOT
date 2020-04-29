package gettingDatas;


import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import okhttp3.*;

public class Overwriting_jsonFiles extends Thread{
    private final OkHttpClient httpClient = new OkHttpClient();
    private String link;
    private String targetDir;

    public Overwriting_jsonFiles(String link, String targetDir){
        this.link = link;
        this.targetDir = targetDir;
    }

    @Override
    public void run() {
        Request request = new Request.Builder()
                .url(link)
                .addHeader("Content-Type", "application/json")
                .addHeader("X-Api-Key", "htl-leoben2020")
                .build();
        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            Files.write(Paths.get(targetDir), response.body().string().getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
