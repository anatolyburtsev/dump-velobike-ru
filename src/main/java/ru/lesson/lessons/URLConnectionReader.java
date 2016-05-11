package ru.lesson.lessons;


import java.net.*;
import java.io.*;
/**
 * Created by onotole on 07.05.16.
 */
public class URLConnectionReader {
    String urlString;


    public URLConnectionReader(String url) {
        this.urlString = url;
    }

    public String dump() throws IOException {
        if (urlString == null) {
            return "";
        }

        URL url = new URL(urlString);
        return "";
    }
}
