public class HelpDesk {
    private static HelpDesk instance;
    private int queueNumber = 1;

    private HelpDesk() {
    }

    public static synchronized HelpDesk getInstance() {
        if (instance == null) {
            instance = new HelpDesk();
        }
        return instance;
    }

    public synchronized void displayCurrentQueueNumber() {
        System.out.println("\nCurrent Queue Number: " + queueNumber);
    }

    public synchronized void serveNextCustomer(String desk) {
        System.out.println("Currently serving Customer #" + queueNumber + " at " + desk);
        queueNumber++;
    }

    public synchronized void resetQueueNumber(int num) {
        queueNumber = num;
        System.out.println("\nReset Queue Number to: " + queueNumber + "\n");
    }
}
