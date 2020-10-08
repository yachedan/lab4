
package com.company;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        String entry = "";
        Map<String, Integer> words = new HashMap<String, Integer>();
        try {
            File harryPotter = new File("harryPotter.txt");
            Scanner myReader = new Scanner(harryPotter);
            while (myReader.hasNextLine()) {
                entry = myReader.nextLine();
                entry = entry.toLowerCase();
                String[] splitEntry = entry.split("[ .,?!;:—“”…)(]+");
                for(String s:splitEntry) {
                    if(words.get(s)==null)
                        words.put(s,1);
                    else
                        words.put(s,(words.get(s)+1));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        words.remove("");
        LinkedHashMap<String, Integer> wordsSort = new LinkedHashMap<>();
        ArrayList <Integer> list = new ArrayList<>();
        for (Map.Entry<String, Integer> m : words.entrySet()) {
            list.add(m.getValue());
        }
        Collections.sort(list, Collections.reverseOrder());
        for (int num : list)
            for(Map.Entry<String, Integer> m :words.entrySet())
                if(m.getValue().equals(num))
                    wordsSort.put(m.getKey(),num);
        for(Map.Entry<String, Integer> m:wordsSort.entrySet())
        {
            System.out.println(m);
        }

    }
}
