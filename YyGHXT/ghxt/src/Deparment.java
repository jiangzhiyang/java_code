import java.util.ArrayList;

public class Deparment {
    private String name;

    private ArrayList<Docter> docters = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Docter> getDocters() {
        return docters;
    }

    public void setDocters(ArrayList<Docter> docters) {
        this.docters = docters;
    }



}
