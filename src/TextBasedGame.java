public class TextBasedGame implements TextBasedGameImpl{
    private final Position POSITION_X = new Position(-1);
    private final Position POSITION_0 = new Position(0, "outside", "map", "mailbox");
    private final Position POSITION_1 = new Position(1, "front door", "knob", "door");
    private final Position POSITION_2 = new Position(2, "stairs");
    private final Position POSITION_3 = new Position(3, "living room");
    private final Position POSITION_4 = new Position(4, "hallway");
    private final Position POSITION_5 = new Position(5, "kitchen");
    private final Position POSITION_6 = new Position(6, "upstairs bathroom");
    private final Position POSITION_7 = new Position(7, "guest bedroom");
    private final Position POSITION_8 = new Position(8, "master bedroom");
    private final Position POSITION_9 = new Position(9, "upstairs hallway");

    private String direction;
    private String item;
    private String selection;
    private String objectThatOpens;

    @Override
    public void help() {
        System.out.println("List of Commands");
        System.out.println("****************");
        System.out.println("Intro - Tells you about the game");
        System.out.println("Turn - turns right or left");
        System.out.println("Open - opens an item if there's an object to open in the room");
        System.out.println("Quit - Quit the game");
        System.out.println("");

    }

    @Override
    public void open(String objectThatOpens) {

    }

    @Override
    public void quit() {

    }

    @Override
    public void turn() {

    }

    @Override
    public String input() {
        return null;
    }

    @Override
    public void intro() {
        System.out.println("You are standing in an open field west of a white house, with a boarded front door. There is a small mailbox here");
    }
}