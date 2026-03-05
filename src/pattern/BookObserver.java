package pattern;

public class BookObserver implements Observer {

    private String patronName;

    public BookObserver(String patronName) {
        this.patronName = patronName;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + patronName + ": " + message);
    }
}
