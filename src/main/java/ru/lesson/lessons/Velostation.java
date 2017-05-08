package ru.lesson.lessons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by onotole on 09.05.16.
 */
public class Velostation {
    String Address;
    int FreeElectricPlaces;
    int FreeOrdinaryPlaces;
    int FreePlaces;
    String Id;
    Boolean IsLocked;
    Map<String, Double> Position = new HashMap<String, Double>();
    int TotalElectricPlaces;
    int TotalOrdinaryPlaces;
    int TotalPlaces;

    @Override
    public String toString() {
        return "Velostation{" +
                "Address='" + Address + '\'' +
                ", FreePlaces=" + FreePlaces +
                ", Id='" + Id + '\'' +
                ", IsLocked=" + IsLocked +
                ", Position=" + Position +
                ", TotalPlaces=" + TotalPlaces +
                '}';
    }
}

class RawVelostation {
    public ArrayList<Velostation> Items;
}
