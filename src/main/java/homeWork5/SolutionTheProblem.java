package homeWork5;

public class SolutionTheProblem {

//   Задание 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.

    public static int run (Item[] items, int maxCapacity) {
        return rec (items, maxCapacity, new int[maxCapacity + 1], 0);
    }

    private static int rec(Item[] items, int maxCapacity, int[] tab, int i) {

        if(i >= items.length) {
            return 0;
        }

        if(tab[maxCapacity] != 0){
            return tab[maxCapacity];
        }

        int value1 = rec(items, maxCapacity, tab, i + 1);
        int value2 = 0;

        if(maxCapacity >= items[i].getWeight ()) {
            value2 = rec(items, maxCapacity - items[i].getWeight (), tab, i + 1) + items[i].getValue ();
        }

        return tab[maxCapacity] = Math.max (value1, value2);
    }

}
