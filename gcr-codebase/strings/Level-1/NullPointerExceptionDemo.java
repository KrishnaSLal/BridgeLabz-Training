public class NullPointerExceptionDemo {

    // create method to generate NullPointerException
    public static void generateException() {
        String text = null;   
        System.out.println(text.length()); 
    }

    // create method to handle NullPointerException
    public static void handleException() {
        String text = null;  
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException!");
        }
    }

    public static void main(String[] args) {

        System.out.println("Generating NullPointerException:");
        generateException();

        System.out.println("\nHandling NullPointerException:");
        handleException();
    }
}