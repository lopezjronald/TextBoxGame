import java.util.Scanner;

public class TextBasedGame implements TextBasedGameImpl{
    private final Position POSITION_X = new Position(-1);
    private final Position POSITION_0 = new Position(0, "outside", "map", "mailbox");
    private final Position POSITION_1 = new Position(1, "front door", "knob", "door");
    private final Position POSITION_2 = new Position(2, "first part of the hallway", "monkey", "door under the stairs");
    private final Position POSITION_3 = new Position(3, "second part of the hallway", "giant spider", "window");
    private final Position POSITION_4 = new Position(4, "bathroom", "sea monster", "tub");
    private final Position POSITION_5 = new Position(5, "master bedroom", "escape portal", "chest");
    private final Position POSITION_6 = new Position(6, "living room", "fairy", "present box");
    private final Position POSITION_7 = new Position(7, "kitchen", "escape portal", "oven");

    private String direction = "west";
    private int currentPosition = 0;

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void help() {
        System.out.println("List of Commands");
        System.out.println("****************");
        System.out.println("Intro - Tells you about the game");
        System.out.println("Turn - turns right or left");
        System.out.println("Open - opens an item if there's an object to open in the room");
        System.out.println("Quit - Quit the game");
    }

    @Override
    public void open(Position position) {
        System.out.println("You open the " + position.getObjectThatOpens() + " and find a " + position.getItem() + ".");
    }

    @Override
    public void quit() {
        System.out.println("Thank you for playing");
        System.exit(0);
    }

    @Override
    public void turn() {
        System.out.println("Would you like to turn:");
        System.out.println("1. Right");
        System.out.println("2. Left");
        while (true) {
            String selection = input();
            if (selection.equals("1")) {
                switch (direction) {
                    case "west":
                        direction = "north";
                        break;
                    case "north":
                        direction = "east";
                        break;
                    case "east":
                        direction = "south";
                        break;
                    default:
                        direction = "west";
                }
                break;
            } else if (selection.equals("2")) {
                switch (direction) {
                    case "west":
                        direction = "south";
                        break;
                    case "south":
                        direction = "east";
                        break;
                    case "east":
                        direction = "north";
                        break;
                    default:
                        direction = "west";
                }
                break;
            } else {
                System.out.println("You have made an invalid entry. Please choose 1 to turn right or 2 to turn left");
            }
        }
    }

    @Override
    public String input() {
        return scanner.nextLine();
    }

    @Override
    public void walk(Position position) {

        // Current position is 0 where the location is the open field
        if (currentPosition == 0) {
            if (direction.equals("west")) {
                currentPosition = 1;
            } else
                System.out.println("Sorry. There's no where to go but into the fields and to get eaten by monsters");
        // Current position is 1 where the location is being in front of the door
        } else if (currentPosition == 1) {
            if (direction.equals("west")) {
                currentPosition = 2;
            } else if (direction.equals("north") || direction.equals("south")) {
                System.out.println("Sorry. The " + position.getRoomName() + " does not allow you to go " + direction + ".");
            } else {
                currentPosition = 0;
            }
        // Current position is 2 where the location is being in the front part of the hallway
        } else if (currentPosition == 2) {
            changePosition(3, 4, 6, 1);
        } else if (currentPosition == 3) {
           if (direction.equals("west")) {
               currentPosition = 7;
           } else if (direction.equals("north")) {
               currentPosition = 5;
           } else if (direction.equals("east")) {
               currentPosition = 2;
           } else if (direction.equals("south")) {
               System.out.println("There's only a window in front of you. You can't go through it.");
           }
        } else if (currentPosition == 4) {
            if (direction.equals("east")) {
                currentPosition = 3;
            } else {
                System.out.println("Sorry. There's no where to go. This " + position.getRoomName() + "doesn't have an exit door." );
            }
        } else if (currentPosition == 5) {
            if (direction.equals("south")) {
                currentPosition = 2;
            } else {
                System.out.println("Sorry. The " + position.getRoomName() + " doesn't have another exit.");
            }
        } else if (currentPosition == 6) {
            if (direction.equals("north")) {
                currentPosition = 2;
            } else {
                System.out.println("Sorry. The " + position.getRoomName() + " doesn't have any other exit.");
            }
        } else if (currentPosition == 7) {

        }
    }

    @Override
    public void intro() {
        System.out.println("You are standing in an open field west of a white house, with a boarded front door. There is a small mailbox here");
    }

    private void changePosition(int west, int north, int east, int south) {
        if (direction.equals("west")) {
            currentPosition = west;
        } else if (direction.equals("north")) {
            currentPosition = north;
        } else if (direction.equals("east")) {
            currentPosition = east;
        } else if (direction.equals("south")) {
            currentPosition = south;
        }
    }


}