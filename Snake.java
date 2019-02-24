package sample;

public class Snake extends Creature implements Wriggle {

    @Override
    public String wriggle() {
        return ("I can wriggle!");
    }

    @Override
    public String whoIAm() {
        return ("I am snake!");
    }

    public String creep(){
        return null;
    }

}
