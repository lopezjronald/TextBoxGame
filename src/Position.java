public class Position {
    private String item;
    private String objectThatOpens;
    private int positionNumber;
    private String roomName;

    public Position() {
    }

    public Position(int positionNumber) {
        this.positionNumber = positionNumber;
    }

    public Position(int positionNumber, String roomName) {
        this.positionNumber = positionNumber;
        this.roomName = roomName;
    }

    public Position(int positionNumber, String roomName, String item, String objectThatOpens) {
        this.positionNumber = positionNumber;
        this.item = item;
        this.roomName = roomName;
        this.objectThatOpens = objectThatOpens;
    }

    public String getItem() {
        return item;
    }

    public String getObjectThatOpens() {
        return objectThatOpens;
    }

    public int getPositionNumber() {
        return positionNumber;
    }

    public String getRoomName() {
        return roomName;
    }
}
