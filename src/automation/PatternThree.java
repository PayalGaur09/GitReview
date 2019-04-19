package automation;

public class PatternThree {
    public static void main(String[] args) {
        int n=7;
        for (int i = 0; i < n/2 + 1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = i; j < n-i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

}
