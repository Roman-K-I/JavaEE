package AlgHomeWork2;

import java.util.Random;

public class Main {

      /*
    Задание 1. Создать массив большого размера (100000 элементов).
    Задание 2. Заполнить массив случайными числами.
    Задание 3. Проверить скорость выполнения каждой сортировки.
     */

    private final static int SIZE = 100_000;
    private final static int BOUND = 1000;
    private static long time;
    private static MyArrayList myArrayList;

    private static MyArrayList getNotSortedList(){
        Random random = new Random();
        MyArrayList<Integer> myArrayList = new MyArrayList<> (SIZE);
        for (int i = 0; i < SIZE; i++) {
            myArrayList.add(random.nextInt(BOUND));
        }
        return myArrayList;
    }

    private static void showTime(String typeSort, long time){
        time = System.nanoTime () - time;
        System.out.println (typeSort + " nano=" + time + " mil=" + time / 1000000 );
    }

    private static void timeTest(){

        myArrayList = getNotSortedList ();
        time = System.nanoTime ();
        myArrayList.selectionSort ();
        showTime ("selectionSort", time);

        myArrayList = getNotSortedList ();
        time = System.nanoTime ();
        myArrayList.insertionSort ();
        showTime ("insertionSort", time);

        myArrayList = getNotSortedList ();
        time = System.nanoTime ();
        myArrayList.bubbleSort ();
        showTime ("bubbleSort", time);

        myArrayList = getNotSortedList ();
        time = System.nanoTime ();
        myArrayList.bubbleSortOptimized ();
        showTime ("bubbleSortOptimized", time);

    }


    public static void main (String[] args) {
        timeTest ();
    }


}
