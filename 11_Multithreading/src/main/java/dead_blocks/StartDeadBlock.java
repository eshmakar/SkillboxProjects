package dead_blocks;

public class StartDeadBlock {
    public static void main(String[] args) {
        final Friend anton = new Friend("Anton");
        final Friend john = new Friend("John");

        new Thread(()->anton.throwBallTo(john)).start();
        new Thread(()->john.throwBallTo(anton)).start();
    }
}
