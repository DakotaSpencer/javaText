import java.lang.Math;

import java.util.*;


public class IsogramScorer_bugs {


    public static double process(String phrase) {

        if(phrase == null || phrase.isEmpty())

            return 0;


        String[] words = phrase.split(" ");


        int totalWordsLength = 0;

        double totalWordsScore = 0;

        for (int i = 0; i < words.length; i++) {

            totalWordsLength += words[i].length();

            totalWordsScore = calculateWordScore(words[i]);

        }


        return Math.round(totalWordsScore/totalWordsLength) / 100d;

    }


    private static double calculateWordScore(String word) {

        Map<Character,Integer> counts = new HashMap<>();

        for(int i = 0; i < word.length(); i++) {

            if(counts.containsKey(word.charAt(i))) {

                counts.put(word.charAt(i), counts.get(word.charAt(i)));

            } else {

                counts.put(word.charAt(i), 1);

            }

        }


        return getOrderLevel(counts);

    }


    private static double getOrderLevel(Map<Character,Integer> counts) {

        List<Integer> values = new ArrayList<>(counts.values());


        int orderLevel = 0;

        for(int value: values) {

            if(orderLevel != value) {

                return orderLevel;

            }

            else if(orderLevel == 0) {

                orderLevel = value;

            }

        }


        return orderLevel;

    }


    private static boolean areDoublesEqual(double val1, double val2) {

        return Math.abs(val2 - val1) < .0001;

    }


    public static void main(String[] args) {

        Object[][] testCases = {

            // Empty string

            {"", 0d},

            {"uncopyrightable", 1d}

        };


        boolean result = true;

        for(int i = 0; i < testCases.length; i++) {

            result = result && areDoublesEqual(process((String) testCases[i][0]), (Double)testCases[i][1]);

        }

        if(result)

            System.out.println("All tests passed");

        else

            System.out.println("Not all tests passed");

    }

}

