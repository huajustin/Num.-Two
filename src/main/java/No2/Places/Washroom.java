package No2.Places;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.maps.model.LatLng;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Washroom implements Place {

    private final String name;
    private final double latitude;
    private final double longitude;
    private final String address;

    public Washroom(String name, double latitude, double longitude, String address) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    public String name() {
        return this.name;
    }

    public double latitude() {
        return this.latitude;
    }

    public double longitude() {
        return this.longitude;
    }

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
                        name = field.getAsJsonObject("fields").get("name").getAsString();
                        longitude = Double.parseDouble(field.getAsJsonObject("fields").getAsJsonObject("geom").get("coordinates").getAsString().split(", ")[1]);
                        latitude = Double.parseDouble(field.getAsJsonObject("fields").getAsJsonObject("geom").get("coordinates").getAsString().split(", ")[0]);
                        address = field.getAsJsonObject("fields").getAsJsonObject("geom").get("address").getAsString();
                    }
                    catch (Exception e) { /* ignore it for now */ }

                    places.add(new Washroom(name, latitude, longitude, address));
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
