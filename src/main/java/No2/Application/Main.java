package No2.Application;


import GUI.GUI;
import GoogleMapsMediator.GoogleMapsMediator;
import No2.Places.CommunityCenter;
import No2.Places.Hospital;
import No2.Places.Place;
import No2.Places.Washroom;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Place> list = Washroom.toList("data/public-washrooms.json");

        for (Place p: list) {
            System.out.println(p.address());
        }
    }
}
