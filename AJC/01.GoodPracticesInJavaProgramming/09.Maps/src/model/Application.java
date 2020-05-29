package model;

import java.util.*;

public class Application {

    public static void main(String[] args) {

        Map<String, List<Parking>> parking = new HashMap<>();
        parking.put("Gironde", Arrays.asList(new Parking("Parking 1", "A"), new Parking("Parking 2", "B")));
        parking.put("\nLoire", Arrays.asList(new Parking("Parking 3", "C"), new Parking("Parking 4", "D")));

        Iterator<String> it = parking.keySet().iterator();

        while (it.hasNext()) {
            String department = it.next();
            System.out.println(department);
            List<Parking> parkingList = parking.get(department);
            for (Parking p : parkingList) {
                System.out.printf("   " + p.name);
            }
        }

        System.out.println("\n\n***String builder****");
        it = parking.keySet().iterator();
        it.forEachRemaining(department -> {
            System.out.println(department);
            parking.get(department).stream().map(v -> new StringBuilder("   ")
                    .append(v.name).toString()).forEach(System.out::println);
        });

        // Compare both
        long currentTime = System.currentTimeMillis();
        String s = "blabla";
        for (int i =0; i <100000; i++){
            s += "blabla" + "blabla";
        }
        System.out.println("\n String Time: " + ( System.currentTimeMillis() - currentTime));

        currentTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("blabla");
        for (int i = 0; i<500000; i++){
            sb.append("blabla").append("blabla");
        }
        System.out.println("Stringbuilder Time: " + ( System.currentTimeMillis() - currentTime));

    }
}
