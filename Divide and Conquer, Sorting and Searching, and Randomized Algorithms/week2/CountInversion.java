import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CountInversion {
    public static void main(String[] args) throws Exception{
        File file = new File("IntegerArray.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while (scanner.hasNextLine()) {
            list.add(Integer.parseInt(scanner.nextLine()));
        }
        System.out.println(list);
        MergeSortAndCount program = new MergeSortAndCount();
        program.mergeSort(list);
        System.out.println("After mergesort ......");
        System.out.println(list);
        System.out.println(program.count);
    }

}
