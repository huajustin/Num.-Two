package No2.Places;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Hospital implements Place {

    private String name;
    private double latitude;
    private double longitude;
    private String address;

    public Hospital(String name, double latitude, double longitude, String address) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public double latitude() {
        return this.latitude;
    }

    @Override
    public double longitude() {
        return this.longitude;
    }

    @Override
    public String address() {
        return this.address;
    }

    public static List<Place> toList(String json) {
        JsonParser parser = new JsonParser();

        List<Place> places = new ArrayList<>();
        try (FileReader fr = new FileReader(json)) {
            JsonElement jsonE = parser.parse(fr);
            if (jsonE.isJsonArray()) {
                JsonArray jArray = jsonE.getAsJsonArray();
                for (int i = 0; i < jArray.size(); i++) {
                    JsonObject field = jArray.get(i).getAsJsonObject();
                    String name = null;
                    double longitude = 0;
                    double latitude = 0;
                    String address = null;

                    try {
                        name = field.get("SV_NAME").getAsString();
                        longitude = Double.parseDouble(field.get("LONGITUDE").getAsString());
                        latitude = Double.parseDouble(field.get("LATITUDE").getAsString());
                        address = field.get("STREET_NUMBER").getAsString();
                    }
                    catch (Exception e) { /* ignore it for now */ }
                    /* what else? */

                    places.add(new Hospital(name, latitude, longitude, address)); /* change this */
                }
            }
        }
        catch (IOException ioe) {
            System.out.println("Unexpected");
        }
        System.out.println(places.size());

        return places;
    }
}
