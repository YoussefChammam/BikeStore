import org.jetbrains.annotations.TestOnly;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class main {
    static String ort = "Die Station liegt in Berlin-Prenzlauerberg";

    public static String Ort() {
        return ort;
    }

    // formula to be able to remove an element of an array

    public static Fahrradverleih[] removeTheElement(Fahrradverleih[] arr,
                                                    int index) {
        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null
                || index < 0
                || index >= arr.length) {
            return arr;
        }

        // Create another array of size one less
        Fahrradverleih[] anotherArray = new Fahrradverleih[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return anotherArray;
    }

    public static void main(String[] args) {
        Fahrradverleih decathlon1 = new Fahrradverleih("decathlon yellow", "mountainbike ", 1, 1);
        Fahrradverleih decathlon2 = new Fahrradverleih("decathlon red", "mountainbike ", 5, 2);
        Fahrradverleih decathlon3 = new Fahrradverleih("decathlon green ", "citybike ", 3, 3);
        Fahrradverleih decathlon4 = new Fahrradverleih("decathlon blue ", "mountainbike ", 16, 4);
        Fahrradverleih[] Fahrräder = {decathlon1, decathlon2, decathlon3, decathlon4};

        for (int i = 0; i < 4; i++) {
            System.out.println(Fahrräder[i].toString());
        }
        String d1 = Integer.toString((int) decathlon1.Distance(decathlon1, decathlon2));
        String d2 = Integer.toString((int) decathlon2.Distance(decathlon2, decathlon3));
        String d3 = Integer.toString((int) decathlon3.Distance(decathlon3, decathlon4));
        String d4 = Integer.toString((int) decathlon1.Distance(decathlon1, decathlon3));
        String d5 = Integer.toString((int) decathlon2.Distance(decathlon2, decathlon4));
        String d6 = Integer.toString((int) decathlon1.Distance(decathlon1, decathlon4));

        String[][] abstände = {{"decathlon1/decathlon2", d1 + " m"}, {"decathlon2/decathlon3", d2 + " m"}, {"decathlon3/decathlon4", d3 + " m"}, {"decathlon1/decathlon3", d4 + " m"}, {"decathlon2/decathlon4", d5 + " m"}, {"decathlon1/decathlon4", d6 + " m"}};
        System.out.println(Arrays.deepToString(abstände));
        int i = 0;
        Fahrradverleih x = Fahrräder[0];
        while (i < Fahrräder.length) {
            if (Fahrräder[i].latitude > x.latitude) {
                x = Fahrräder[i];
                i++;
            } else
                i++;
        }
        String[] bikeOrder = {x.name};
        Fahrradverleih nearestFahrrad = Fahrräder[0];
        double initdist = Fahrräder[0].Distance(Fahrräder[0], x);
        Fahrräder = removeTheElement(Fahrräder, java.util.Arrays.asList(Fahrräder).indexOf(x));
        while (bikeOrder.length != 3) {
            for (int j = 1; j < Fahrräder.length +1; j++) {
                int theindex = java.util.Arrays.asList(Fahrräder).indexOf(nearestFahrrad);
                Fahrräder = removeTheElement(Fahrräder, theindex);
                if (j > Fahrräder.length) {
                    break;
                } else {

                    if ((Fahrräder[j].Distance(Fahrräder[j], x) < initdist) && (Fahrräder[j] != x)) {
                        nearestFahrrad = Fahrräder[j];
                        initdist = Fahrräder[j].Distance(Fahrräder[j], x);
                    }
                }

                bikeOrder = Arrays.copyOf(bikeOrder, bikeOrder.length + 1);
                bikeOrder[bikeOrder.length - 1] = nearestFahrrad.name;

            }
            if (Fahrräder.length <= 2) {
                bikeOrder = Arrays.copyOf(bikeOrder, bikeOrder.length + 1);
                bikeOrder[bikeOrder.length - 1] = Fahrräder[0].name;
                System.out.println(" ");
                System.out.println("order of bikes to pick first : ");
                System.out.println(Arrays.deepToString(bikeOrder));
                System.out.println(" ");
                System.out.println("you can now pick the last one that isn't sited on the list and go home");
            }
        }
    }
}

