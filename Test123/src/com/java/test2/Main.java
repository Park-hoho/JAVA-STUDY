
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //input
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        //logic
        int answer = a + b;

        //output
        System.out.println(answer);
    }
}

//sc.hasNext()