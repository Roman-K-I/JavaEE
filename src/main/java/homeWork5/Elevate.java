package homeWork5;

public class Elevate {

    //   Задание 1. Написать программу по возведению числа в степень с помощью рекурсии.

    public static double run(int x,  int n){
        if (n >= 0){
            return rec (x, n);
        }
        return 1 / rec (x, (n * -1) );
    }

    private static double rec(int x,  int n){
        if (x == 1 || n == 0){
            return 1;
        }
        if (n == 1){
            return x;
        }
        return rec(x, n -1) * x;
    }
}