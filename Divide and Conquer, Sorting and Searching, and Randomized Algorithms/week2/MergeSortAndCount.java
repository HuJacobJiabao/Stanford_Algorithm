import java.util.ArrayList;


public class MergeSortAndCount {
    long count = 0;

    public void mergeSort(ArrayList<Integer> list) {
        mergeSortHelper(list, 0, list.size());
    }

    public void mergeSortHelper(ArrayList<Integer> list, int startIndex, int endIndex) {
        if (endIndex - startIndex <= 1) {
            return;
        }

        int middleIndex = (startIndex + endIndex) / 2;
        mergeSortHelper(list, startIndex, middleIndex);
        mergeSortHelper(list, middleIndex, endIndex);

        ArrayList<Integer> mergedResults = new ArrayList<>();
        int leftCursor = startIndex;
        int rightCursor = middleIndex;

        while (leftCursor < middleIndex && rightCursor < endIndex) {
            int leftValue = list.get(leftCursor);
            int rightValue = list.get(rightCursor);
            if (leftValue < rightValue) {
                mergedResults.add(leftValue);
                leftCursor++;
            } else {
                mergedResults.add(rightValue);
                addCount(middleIndex, leftCursor);
                rightCursor++;
            }
        }
        while (leftCursor < middleIndex) {
            mergedResults.add(list.get(leftCursor));
            leftCursor++;
        }
        while (rightCursor < endIndex) {
            mergedResults.add(list.get(rightCursor));
            rightCursor++;
        }

        for (int i = 0; i < mergedResults.size(); i++) {
            list.set(startIndex + i, mergedResults.get(i));
        }

    }

    public void addCount(int middleIndex, int leftCursor) {
        count = count + middleIndex - leftCursor;
    }

}
