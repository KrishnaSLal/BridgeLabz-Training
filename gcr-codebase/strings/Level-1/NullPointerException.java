class NullPointerException{

    // Method to generate NullPointerException
    static void generateException() {
        String text = null;      // initializing to null
        System.out.println(text.length()); // causes NullPointerException
    }

    // Method to handle NullPointerException
    static void handleException() {
        String text = null; // initializing to null

        try {
            System.out.println(text.length()); // risky code
        } catch (NullPointerException e) {
            System.out.println("NullPointerException present ");
            System.out.println("Reason: Attempt to access method on a null object.");
        }
    }

    public static void main(String[] args) {

        System.out.println("Calling method to generate exception:");
        generateException();   // This will crash the program

        // The below code will not execute until we refactor
        // to handle the exception

        System.out.println("\nCalling method to handle exception:");
        handleException();
    }
}