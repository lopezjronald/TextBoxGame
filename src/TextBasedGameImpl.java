public interface TextBasedGameImpl {
    void intro();
    void help();
    void open(Position position);
    void quit();
    void turn();
    String input();
    void walk (Position position);
}
