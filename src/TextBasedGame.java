import java.util.Scanner;

public class TextBasedGame implements TextBasedGameImpl{
    private final Position POSITION_0 = new Position(0, "outside", "map", "mailbox");
    private final Position POSITION_1 = new Position(1, "front door", "knob", "empty house");
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
        System.out.println("About - Tells you about the game");
        System.out.println("Turn - turns right or left");
        System.out.println("Open - opens an item if there's an object to open in the room");
        System.out.println("Quit - Quit the game");
        System.out.println("Walk - Walk forward");
        System.out.println("Help - list of commands");
    }

    @Override
    public void open() {
        String objectThatOpens;
        String item;
        switch (currentPosition) {
            case 0:
                objectThatOpens = POSITION_0.getObjectThatOpens();
                item = POSITION_0.getItem();
                break;
            case 1:
                objectThatOpens = POSITION_1.getObjectThatOpens();
                item = POSITION_1.getObjectThatOpens();
                break;
            case 2:
                objectThatOpens = POSITION_2.getObjectThatOpens();
                item = POSITION_2.getItem();
                break;
            case 3:
                objectThatOpens = POSITION_3.getObjectThatOpens();
                item = POSITION_3.getItem();
                break;
            case 4:
                objectThatOpens = POSITION_4.getObjectThatOpens();
                item = POSITION_4.getItem();
                break;
            case 5:
                objectThatOpens = POSITION_5.getObjectThatOpens();
                item = POSITION_5.getItem();
                break;
            case 6:
                objectThatOpens = POSITION_6.getObjectThatOpens();
                item = POSITION_6.getItem();
                break;
            default:
                objectThatOpens = POSITION_7.getObjectThatOpens();
                item = POSITION_7.getItem();
                System.out.println("You have opened the " + POSITION_7.getItem() + ". You have escaped the game!");
                quit();
        }
        System.out.println("You open the " + objectThatOpens + " and find a " + item + ".");
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
            String selection = scanner.nextLine().toLowerCase();
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
    public void input() {
        while (true) {
            String choice = scanner.nextLine().toLowerCase();
            switch (choice) {
                case "about":
                    about();
                    break;
                case "help":
                    help();
                    break;
                case "turn":
                    turn();
                    break;
                case "walk":
                    walk();
                    break;
                case "quit":
                    quit();
                    break;
                case "open":
                    open();
                    break;
                default:
                    System.out.println("That was invalid choice. Please choose from the following");
                    help();
            }
        }
    }

    @Override
    public void walk() {
        // Current position is 0 where the location is the open field
        if (currentPosition == 0) {
            if (direction.equals("west")) {
                currentPosition = 1;
                currentLocation(POSITION_1);
            } else
                System.out.println("Sorry. There's no where to go but into the fields and to get eaten by monsters");
        // Current position is 1 where the location is being in front of the door
        } else if (currentPosition == 1) {
            if (direction.equals("west")) {
                currentPosition = 2;
                currentLocation(POSITION_2);
            } else if (direction.equals("north") || direction.equals("south")) {
                System.out.println("Sorry. The " + POSITION_1.getRoomName() + " does not allow you to go " + direction + ".");
            } else {
                currentPosition = 0;
                currentLocation(POSITION_0);
            }
        // Current position is 2 where the location is being in the front part of the hallway
        } else if (currentPosition == 2) {
            if (direction.equals("west")) {
                currentPosition = 3;
                currentLocation(POSITION_3);
            } else if (direction.equals("north")) {
                currentPosition = 4;
                currentLocation(POSITION_4);
            } else if (direction.equals("east")) {
                currentPosition = 1;
                currentLocation(POSITION_1);
            } else {
                currentPosition = 6;
                currentLocation(POSITION_6);
            }
        // Current position is 3 where the location is being in the second part of the hallway
        } else if (currentPosition == 3) {
           if (direction.equals("west")) {
               currentPosition = 7;
               currentLocation(POSITION_7);
           } else if (direction.equals("north")) {
               currentPosition = 5;
               currentLocation(POSITION_5);
           } else if (direction.equals("east")) {
               currentPosition = 2;
               currentLocation(POSITION_2);
           } else if (direction.equals("south")) {
               System.out.println("There's only a window in front of you. You can't go through it.");
           }
       // current position is 4 where you're in the bathroom
        } else if (currentPosition == 4) {
            if (direction.equals("east")) {
                currentPosition = 3;
                currentLocation(POSITION_3);
            } else {
                System.out.println("Sorry. There's no where to go. This " + POSITION_4.getRoomName() + "doesn't have an exit door." );
            }
        // current position is fiver, the master bedroom
        } else if (currentPosition == 5) {
            if (direction.equals("south")) {
                currentPosition = 2;
                currentLocation(POSITION_2);
            } else {
                System.out.println("Sorry. The " + POSITION_5.getRoomName() + " doesn't have another exit.");
            }
        // current position is 6, the living room
        } else if (currentPosition == 6) {
            if (direction.equals("north")) {
                currentPosition = 2;
                currentLocation(POSITION_2);
            } else {
                System.out.println("Sorry. The " + POSITION_6.getRoomName() + " doesn't have any other exit.");
            }
        // current position is 7, the kitchen
        } else if (currentPosition == 7) {
            if (direction.equals("east")) {
                currentPosition = 2;
            currentLocation(POSITION_2);
            } else {
                System.out.println("Sorry. The " + POSITION_7.getRoomName() + " doesn't have any other exit.");
            }
        }
    }

    @Override
    public void about() {
        System.out.println("You are standing in an open field west of a white house, with a boarded front door. There is a small mailbox here");
    }

    private void currentLocation(Position position) {
        System.out.println("You are currently looking " + direction + " at the " + position.getRoomName() + ". There's a " + position.getObjectThatOpens() + " you can open.");
        System.out.println("What would you like to do next");
    }
}