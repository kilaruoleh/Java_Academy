package co.inventorsoft.homework;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = getNumbers();
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] mergeSort(int[] array) {
        int[] tmp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size = size * 2;

            System.out.println(Arrays.toString(currentSrc));
        }
        
        return currentSrc;
    }

    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest,
                              int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
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