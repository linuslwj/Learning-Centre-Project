public class forLoopDemo {
    public static void main(String[ ] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println("The current value of i: " + i);
        }
        for (int i = 10; i >= 0; i--) {
            System.out.println("The current value of i: " + i);
        }
        for (int i = 10; i >= 0; i-=2) {
            System.out.println("The current value of i: " + i);
        }
        for (int row = 0; row < 5; row++) {
            System.out.println("row" + row + ": ");
            for (int col = 0; col < 10; col++) {
                System.out.println(col + " ");
            }
            System.out.println();
        }
        int c = 5;

        for (int i = 2; i <= c; i++) {

            for (int j = 0; j < i; j++) {

                System.out.println("Tricky!");

            }

        }
        int num = 1;
        for (int i = 0; i < 11; i++) {
            System.out.print(num + " ");
            num += num;
        }

    }
}
