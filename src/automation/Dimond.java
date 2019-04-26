package automation;

public class Dimond {
    public static void main(String[] args) {
        int n = 11;
        int sp = n/2;
        int star=1;

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= sp; j++){
                System.out.print(" ");
            }

            for (int k = 1; k <= 2 * star - 1; k++){
                System.out.print("*");
            }

            if( i<=n/2){
                sp--;
                star++;
            }else{
                sp++;
                star--;
            }
            System.out.println();
        }

    }
}


