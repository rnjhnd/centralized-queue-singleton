public class CentralSystem {
    public static void main(String[] args) {
        HelpDesk helpDesk = HelpDesk.getInstance();

        System.out.println("Pag-Ibig Queueing System\n");

        helpDesk.serveNextCustomer("Help Desk #1");
        helpDesk.serveNextCustomer("Help Desk #2");
        helpDesk.serveNextCustomer("Help Desk #3");
        helpDesk.serveNextCustomer("Help Desk #1");
        helpDesk.serveNextCustomer("Help Desk #2");
        helpDesk.serveNextCustomer("Help Desk #3");

        helpDesk.displaycurrentQueueNumber();

        helpDesk.resetQueueNumber(1);

        helpDesk.serveNextCustomer("Help Desk #1");
        helpDesk.serveNextCustomer("Help Desk #2");
        helpDesk.serveNextCustomer("Help Desk #3");
    }
}