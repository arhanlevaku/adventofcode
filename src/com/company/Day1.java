
package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day1 {

    public static void main(String[] args) throws FileNotFoundException {
        {

            File file = new File("inputDay1.txt");
            LinkedHashMap<Integer, Integer> cals = new LinkedHashMap<>();
            int val = 0;
            Scanner sc = new Scanner(file);
            int key = 0;

            //add contents from input file into hashmap. get the elf# that also has more cals.

          do {
                String value = sc.nextLine();
                if (!value.isEmpty()) {
                    val += Integer.parseInt(value);
                } else if (val > 0){
                        cals.put(key, val);
                        val = 0;
                        key+= 1;
                } }
            while (sc.hasNextLine()) ;
            key+= 1;
            cals.put(key, val);



            //convert LinkedHashMap to List of Map.Entry
            List<Map.Entry<Integer, Integer>> elfsetListEntry = new ArrayList<>(cals.entrySet());

            // 3. sort list of entries using Collections class'
            elfsetListEntry.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

            cals.clear();

            for(Map.Entry<Integer, Integer> map : elfsetListEntry){
                cals.put(map.getKey(), map.getValue());
            }

            System.out.println("sorted hashmap : elf & cals" + cals);


            for(Map.Entry<Integer, Integer> map :
                    cals.entrySet()){
                System.out.println("Key : "  + map.getKey()
                        + "\t\t" + "Value : "  + map.getValue());
            }
        }


    }

}
