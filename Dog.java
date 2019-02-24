package sample;

public class Dog extends Creature implements Creep {

    public String creep() {
        return ("I can creep");
    }

    @Override
    public String whoIAm() {
        return ("I am Dog");
    }

    public String wriggle(){
        return null;
    }
}
