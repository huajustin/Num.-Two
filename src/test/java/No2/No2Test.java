package No2;

import No2.Places.CommunityCenter;
import No2.Places.Place;
import No2.Places.Washroom;
import org.junit.Test;

import java.util.List;

public class No2Test {

    @Test
    public void test1() {

        List<Place> list = CommunityCenter.toList("data/Community_Centers.json");

        for (Place p: list) {
            System.out.print(p.name() + " ");
            System.out.println(p.address());;
        }

    }


}
