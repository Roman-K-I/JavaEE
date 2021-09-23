package homeWork5;

import java.util.Random;

public class Main {

    public static void main (String[] args) {

        testProblem();

        testRecElevate();
    }

    private static void testProblem () {

        Random random = new Random ();

        int maxCapacity = random.nextInt (100);

        System.out.println ("Max capacity: " + maxCapacity);

        Item[] items = new Item[10];

        for (int i = 0; i < items.length; i++) {
            items[i] = new Item (random.nextInt (maxCapacity / 2),random.nextInt (3000));
            System.out.println (items[i]);
        }

        System.out.println ("Answer: " + SolutionTheProblem.run(items, maxCapacity));
    }

    public static void testRecElevate(){

        System.out.println (Elevate.run (2, 4));

        System.out.println (Elevate.run (2, -4));

        System.out.println (Elevate.run (2, 0));

        System.out.println (Elevate.run (2, 1));

        System.out.println (Elevate.run (1, 100));

        System.out.println (Elevate.run (0, 50));

    }




}
