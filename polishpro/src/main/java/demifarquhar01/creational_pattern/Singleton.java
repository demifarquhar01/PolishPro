package demifarquhar01.creational_pattern;

public class Singleton {

    public static class ITAdministrator {  // Make ITAdministrator static
        // Step 1: Create a private static instance of the class
        private static ITAdministrator instance;

        // Step 2: Private constructor to prevent external instantiation
        private ITAdministrator() {
            // Initialization code
            System.out.println("ITAdministrator created.");
        }

        // Step 3: Provide a public static method to get the instance of the class
        public static ITAdministrator getInstance() {
            if (instance == null) {
                instance = new ITAdministrator();
            }
            return instance;
        }

        public void handleEmailFailure() {
            System.out.println("Handling email failure...");
        }
    }

    public static void main(String[] args) {
        // Test the Singleton pattern
        ITAdministrator admin1 = ITAdministrator.getInstance();
        ITAdministrator admin2 = ITAdministrator.getInstance();

        // Verify that both references point to the same instance
        System.out.println(admin1 == admin2);  // Should print true, since it's a Singleton
    }
}




