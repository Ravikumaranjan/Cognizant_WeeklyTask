public class T15stringReversal {
    public static void main(String[] args) {
        String str = "Hello, World!";
        String reversedStr = new StringBuilder(str).reverse().toString();
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reversedStr);
    }
}
