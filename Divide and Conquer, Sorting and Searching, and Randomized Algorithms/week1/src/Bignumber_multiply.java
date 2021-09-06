import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bignumber_multiply {

        @SuppressWarnings("resource")
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please input the first number:");
            char[] nums1 = sc.next().toCharArray();
            System.out.println("Please input the second number:");
            char[] nums2 = sc.next().toCharArray();

            ArrayList<Integer> num1 = new ArrayList<Integer>();
            toIntArray(nums1, num1);
            ArrayList<Integer> num2 = new ArrayList<Integer>();
            toIntArray(nums2, num2);

            //Compare the two numbers and ensure the first one is larger.
            if(num1.size() < num2.size()){
                ArrayList<Integer> list = null;
                list = num1;
                num1 = num2;
                num2 = list;
            }

            ArrayList<Integer> answer = new ArrayList<Integer>();//Get the answer.
            int n = 0;//Record the carry.
            for (int i = 0; i < num2.size(); i++) {				//Use a nest loop to perform dislocation combined.
                for (int j = 0; j < num1.size(); j++) {
                    if(i + j < answer.size()){
                        n = num1.get(j) * num2.get(i) + n + answer.get(i+j);//If there's number, add it.
                        answer.set(i + j, n % 10);
                    }else {
                        n = num1.get(j) * num2.get(i) + n;					//If there's originally no number, set it.
                        answer.add(n % 10);
                    }
                    n = n / 10;
                }
                if(n != 0){			//Carry for every step
                    answer.add(n);
                    n = 0;
                }
            }
            if(n != 0){				//Carry after the calculation.
                answer.add(n);
            }
            Collections.reverse(answer);//Reverse the answer
            System.out.println("Their product is:"+answer.toString().replace(" ", "").replace(",", ""));
        }


        private static void toIntArray(char[] nums,ArrayList<Integer> list){
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i] - '0');
            }
            Collections.reverse(list);
        }

    }