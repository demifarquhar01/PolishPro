package demifarquhar01;


// ITAdministrator class
public class ITAdministrator extends User {
    public ITAdministrator(String name, String email, String password) {
        super(name, email, password);
    }

    public void handleEmailFailure() {
        System.out.println("Handling email delivery failure.");
    }
}


