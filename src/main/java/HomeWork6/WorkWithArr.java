package HomeWork6;

import java.util.Arrays;

public class WorkWithArr {
    public static void main(String[] args) {
        int[] arr= new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] arrResult=null;
        for(int i=arr.length-1;i>=0; i--){
            if(arr[i]==4)
            {
                arrResult=new int[arr.length-i-1];
                System.arraycopy(arr, i+1, arrResult, 0, arr.length-i-1);
                break;
            }
        }
    }

    public static int[] returnArrAfter4(int arr[]) throws Exception {
        int[] arrResult=null;
        for(int i=arr.length-1;i>=0; i--){
            if(arr[i]==4)
            {
                arrResult=new int[arr.length-i-1];
                System.arraycopy(arr, i+1, arrResult, 0, arr.length-i-1);
                break;
            }
            if(i==0){
                throw new Exception("В данном массиве нет 4");
            }
        }
        return arrResult;
    }

    public static boolean checkArrFor1And4(Object arr[]){
        for (Object value : arr)
            if (value.equals(4) || value.equals(1))
                return true;
        return false;
    }
}
