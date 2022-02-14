import java.util.List;
import java.util.ArrayList;

public class storeArrays {
    public static List<Integer> compDataX = new ArrayList<>();
    public static List<Integer> compDataY = new ArrayList<>();
    public static List<Integer> testList1 = new ArrayList<>();
    public static List<Integer> testList2 = new ArrayList<>();
    public static void main(String[] args) {
        for (int i = 1; i <= 5;++i) {
            int x = (int) (Math.random() * 10);
            compDataX.add(x);
            int y = (int) (Math.random() * 10);
            compDataY.add(y);
        }
        System.out.println(compDataX);
        System.out.println(compDataY);
        testList1.add(1);
        testList1.add(2);
        testList1.add(3);
        testList2.add(1);
        testList2.add(2);
        testList2.add(3);

        for i in

        if (testList1.indexOf(1) == testList2.indexOf(1)) {
            System.out.println("You can sleep now");
        }

    }
}


/*    int[] years = {2015, 2016, 2017, 2018, 2019, 2020};

// loop all elements
for (int y : years) {
        if (y == 2019) {
            System.out.println("Goodbye, 2019!");
            break;
        }
    }
 */