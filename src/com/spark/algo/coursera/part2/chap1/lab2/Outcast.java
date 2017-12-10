package com.spark.algo.coursera.part2.chap1.lab2;

public class Outcast {  
    private WordNet wordnet;  
    // constructor takes a WordNet object  
    public Outcast(WordNet wordnet){  
        this.wordnet = wordnet;  
    }  
  
    // given an array of WordNet nouns, return an outcast  
    public String outcast(String[] nouns){  
        int[] distance = new int[nouns.length];  
        for (int i=0; i<nouns.length; i++){  
            for (int j=i; j<nouns.length; j++){  
                int dist = wordnet.distance(nouns[i], nouns[j]);  
                distance[i] += dist;  
                if (i != j){  
                    distance[j] += dist;  
                }  
            }  
        }  
        int maxDistance = 0;  
        int maxIndex = 0;  
        for (int i=0; i<distance.length; i++){  
            if (distance[i] > maxDistance){  
                maxDistance = distance[i];  
                maxIndex = i;  
            }  
        }  
        return nouns[maxIndex];  
    }  
}  