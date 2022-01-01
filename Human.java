public class Human extends Player{

    public Human(String name) {
        super(name);
    }

    public String toString(){
        return "Ok " + this.getName() + ", here are your stats:\n" + super.toString();
    }

}
