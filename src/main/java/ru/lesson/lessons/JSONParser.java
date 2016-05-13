package ru.lesson.lessons;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oracle.tools.packager.IOUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by onotole on 09.05.16.
 */
public class JSONParser {

    public static ArrayList<Velostation> dumpData() {
        URL url = null;
        int attemptCounter = 0;
        boolean isFailed = false;
        while (true) {
            try {
                isFailed = false;
                url = new URL(Config.apiUrl);
            } catch (Exception e) {
                isFailed = true;
                if (attemptCounter < 5) {
                    attemptCounter++;
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    continue;
                }
                e.printStackTrace();
            }
            if (! isFailed) break;
        }


        RawVelostation rawVelostation = null;
        try (InputStream in = url.openStream(); BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"))) {
            Gson gson = new GsonBuilder().create();
            rawVelostation = gson.fromJson(reader, RawVelostation.class);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rawVelostation.Items;


    }

    public static void main(String[] args) throws IOException {

        URL url = new URL("http://apivelobike.velobike.ru/ride/parkings");
        RawVelostation rawVelostation = null;

        try (InputStream in = url.openStream(); BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"))) {
            Gson gson = new GsonBuilder().create();
            rawVelostation = gson.fromJson(reader, RawVelostation.class);
        }

        for (Velostation Item : rawVelostation.Items) {
            System.out.println(Item.Address);
        }





    }
}
