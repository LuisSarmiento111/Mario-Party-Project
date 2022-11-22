import java.util.ArrayList;

public class Maps {

    private String map;
    private int maxSpaces;
    private ArrayList<Integer> blueSpaces;
    private ArrayList<Integer> redSpaces;
    private ArrayList<Integer> eventSpaces;
    private int starSpace;
    private int barrelCannon;

    public Maps(String map) {
        this.map = map;
    }

    public String mapDetails() {
        if (map.toLowerCase().equals("lava castle")) {
            return "Ahhhh. Probably the worst place to try have fun";
        }
        return "";
    }
}
