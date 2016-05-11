package ru.lesson.lessons;

import java.util.Date;
import java.util.ArrayList;

/**
 * Created by onotole on 09.05.16.
 */
public class Main {
    public static void main(String[] args) {
        DBManager db = new DBManager();
//        db.dropDB();
        db.createVeloDB();
//        db.clearDB();
        ArrayList<Velostation> veloList = JSONParser.dumpData();
        Date date = new Date();
        for (Velostation velo: veloList) {
            db.addVeloStation(velo, date.toString());
        }
    }
}
