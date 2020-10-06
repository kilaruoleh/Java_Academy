package co.inventorsoft.homework;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = getNumbers();
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] input) {
        mergesort(input, 0, input.length - 1);
    }

    private static void mergesort(int[] input, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergesort(input, start, mid);
            mergesort(input, mid + 1, end);
        }

        int i = 0, first = start, last = mid + 1;
        int[] tmp = new int[end - start + 1];

        while (first <= mid && last <= end) {
            tmp[i++] = input[first] < input[last] ? input[first++] : input[last++];
        }
        while (first <= mid) {
            tmp[i++] = input[first++];
        }
        while (last <= end) {
            tmp[i++] = input[last++];
        }
        i = 0;
        while (start <= end) {
            input[start++] = tmp[i++];
        }
    }

    public static int[] getNumbers() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть кількість елементів у масиві: ");
        int length = 0;

        if (sc.hasNextInt()) length = sc.nextInt();
        else System.out.println("Введено не число. Перезапустіть програму і спробуйте ще раз");

        int[] arr = new int[length];
        System.out.println("Введіть елементи масиву: ");

        for(int i=0; i<length; i++) {
            if (sc.hasNextInt()) arr[i] = sc.nextInt();
            else {
                System.out.println("Введено не число. Перезапустіть програму і спробуйте ще раз ");
                break;
            }
        }

        return arr;
    }
}