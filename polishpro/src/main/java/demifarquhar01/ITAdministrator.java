package demifarquhar01;


// ITAdministrator class
public class ITAdministrator extends User {
 
public ITAdministrator(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }   
    public void handleEmailFailure() {
        System.out.println("Handling email delivery failure.");
    }
}


