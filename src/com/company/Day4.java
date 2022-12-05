package com.company;
import java.io.*;
import java.util.*;
import java.lang.*;

class ranges {
    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    private String range;
    public ranges() {

    }

    public boolean checkRange() {
        StringTokenizer st = new StringTokenizer(getRange(), "-,");
        ArrayList<Integer> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(Integer.parseInt(st.nextToken()));
        }
        return ((tokens.get(0) <= tokens.get(2)) && (tokens.get(1) >= tokens.get(3)))
                ||
                ((tokens.get(0) >= tokens.get(2)) && (tokens.get(1) <= tokens.get(3)));

    }

    public boolean checkOverlapRange() {
        StringTokenizer st = new StringTokenizer(getRange(), "-,");
        ArrayList<Integer> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(Integer.parseInt(st.nextToken()));
        }
        return ((tokens.get(2) <= tokens.get(1)) && (tokens.get(3) >= tokens.get(0)));
    }

}

public class Day4 {

    public static void main(String[] args) throws Exception {
            File file = new File("inputDay4.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            ranges r1 = new ranges();

            int inRangeCount=0;
            int overlapCount=0;
            while ((st = br.readLine()) != null) {
               //in ranges puzzle
                r1.setRange(st);
                boolean inRange = r1.checkRange();
                if (inRange) {
                    inRangeCount+= 1;
                }
                //overlapRange puzzle
                boolean overlapRange = r1.checkOverlapRange();
                if (overlapRange) {
                    overlapCount+= 1;
                }
            }
            System.out.println("total in range :" + inRangeCount);
            System.out.println("total overlap range :" + overlapCount);
        }

    }
