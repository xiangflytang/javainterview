package com.java.nomora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public int[] solution(String R, int[] V) {
        // Implement your solution here
        // supposed both have 0 balance at first
        int bBalance = 0;
        int aBalance = 0;
        int aLowestBalance = 0;
        int bLowestBalance = 0;
        int aminBalanceNeed = 0;
        int bminBalanceNeed = 0;
        char[] recipients = R.toCharArray();

        for (int i = 0; i < recipients.length; i++) {

            if (recipients[i] == 'b' || recipients[i] == 'B') {
                aBalance = aBalance - V[i];
                bBalance = bBalance + V[i];

            } else {
                aBalance = aBalance + V[i];
                bBalance = bBalance - V[i];
            }
            aLowestBalance = Math.min(aLowestBalance, aBalance);
            bLowestBalance = Math.min(bLowestBalance, bBalance);

        }
        if (aLowestBalance < 0) {
            aminBalanceNeed = aLowestBalance * -1;
        }
        if (bLowestBalance < 0) {
            bminBalanceNeed = bLowestBalance * -1;
        }
        return new int[]{aminBalanceNeed, bminBalanceNeed};
    }

    public static int[] solution1(String[] S) {
        // Implement your solution here
        Map<Character, List<Integer>> map;
        for (int i = 0; i < S[0].length(); i++) {
            map = new HashMap<>(26);
            for (int j = 0; j < S.length; j++) {
                Character c = S[j].charAt(i);
                List<Integer> locations = map.get(c);
                if (locations == null) {
                    locations = new ArrayList<>();
                    map.put(c,locations);
                }
                locations.add(j);
            }

            for (int k = 0; k <= 25; k++) {
                char cLook = (char) ('a' + k);
                List<Integer> locationResult = map.get(cLook);
                if (locationResult != null && locationResult.size() > 1) {
                    return new int[]{locationResult.get(0), locationResult.get(1), i};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        String[] S= new String []{"abc", "bca", "dbe"};
        int []position=test.solution1(S);

        System.out.println(position[0]);
        System.out.println(position[1]);
        System.out.println(position[2]);

    }

}
