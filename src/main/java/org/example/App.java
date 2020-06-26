package org.example;

import java.util.Arrays;

public class App
{
    /*
        1: We(App) manage the names array
        2: Only Unique names in the array
        3: Add and remove names
        4: Sort the array
        5: Find by name and return index from list

        Test that we follow the rules above!
     */
    private static String[] names = new String[0];

    public static void main( String[] args )
    {
        /*
        //When it comes objects, use equals method
        String me = "ulf";
        String antherMe = "ul";
        antherMe += "f";

        System.out.println(me + " = " + antherMe + " ? " + (me == antherMe));
        */
    }

    public static boolean addName(String name) {

        if (isNewName(name)) {
            names = incressArraySize(names);
            names[names.length - 1] = name;
            sortNames();

            return true;
        }

        return false;
    }
    //overload
    // 1: method name must be the same
    // 2: input type(s) must be different (amount and/or order)
    public static boolean[] addName(String[] namesToAdd) {

        boolean[] wasAdded = new boolean[namesToAdd.length];

        for (int i = 0; i < namesToAdd.length ; i++) {
            wasAdded[i] = addName(namesToAdd[i]);
        }
        return wasAdded;
    }

    public static boolean removeName(String name) {

        for (int i = 0; i < names.length ; i++) {//look for the name

            if (names[i].equalsIgnoreCase(name)) {//if we find it

                for (int j = i + 1; j < names.length ; j++, i++) {//move other names
                    names[i] = names[j];
                }
                names = Arrays.copyOf(names, names.length -1);//shorten the array down by one
                return true;
            }
        }
        return false;
    }

    /**
     * Looks in the names array and returns the index of name if found
     * will return -1 if it is not found.
     * @param name Name to look for
     * @return Index of Name, -1 if not found
     */
    public static int findByName(String name) {
        for (int i = 0; i < names.length ; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    //---- Utils Methods ----

    private static boolean isNewName(String name) {

        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                return false;
            }
        }

        return true;
    }

    public static void sortNames() {
        int i = 0;
        Arrays.sort(names);
    }

    private static String[] incressArraySize(String[] smallArray) {
        return Arrays.copyOf(smallArray, smallArray.length + 1);
    }

    //---- Getters & Setters ----

    public static String[] getNames() {
        return Arrays.copyOf(names, names.length);
    }

    //---- Reset Method ----

    static void resetNames() {
        names = new String[0];
    }
}
