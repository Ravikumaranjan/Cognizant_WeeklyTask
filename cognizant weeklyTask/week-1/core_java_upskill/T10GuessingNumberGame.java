import java.util.*;


class GuessGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int target = r.nextInt(100)+1;
        int guess;

        do {
            guess = sc.nextInt();

            if(guess<target)
                System.out.println("Too Low");
            else if(guess>target)
                System.out.println("Too High");
            else
                System.out.println("Correct");

        } while(guess!=target);
    }
}
