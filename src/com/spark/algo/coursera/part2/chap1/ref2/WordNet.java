package com.spark.algo.coursera.part2.chap1.ref2;

import java.util.ArrayList;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;

public class WordNet {  
    private class Noun implements Comparable<Noun>{  
        private String noun;  
        private ArrayList<Integer> id = new ArrayList<Integer>();  
          
        public Noun(String noun){  
            this.noun = noun;  
        }  
  
        @Override  
        public int compareTo(Noun that) {  
            return this.noun.compareTo(that.noun);  
        }  
          
        public ArrayList<Integer> getId(){  
            return this.id;  
        }  
          
        public void addId(Integer x){  
            this.id.add(x);  
        }  
    }  
      
    private SET<Noun> nounSET;  
    private Digraph G;  
    private SAP sap;  
    private ArrayList<String> idList;  
      
    // constructor takes the name of the two input files  
    public WordNet(String synsets, String hypernyms){  
        In inSynsets = new In(synsets);  
        In inHypernyms = new In(hypernyms);  
        //counting the total number of vertex  
        int maxVertex = 0;   
        idList = new ArrayList<String>();  
        nounSET = new SET<Noun>();  
           
        //start to read hypernyms.txt  
        String line = inSynsets.readLine();  
          
        while (line != null) {  
            maxVertex++;  
            String[] synsetLine = line.split(",");  
            //String[0] is id  
            Integer id = Integer.parseInt(synsetLine[0]);  
            //String[1] is noun, split it and add to the set  
            String[] nounSet = synsetLine[1].split(" ");  
            for (String nounName : nounSet){  
                Noun noun = new Noun(nounName);  
                if (nounSET.contains(noun)){  
                    noun = nounSET.ceiling(noun);  
                    noun.addId(id);  
                } else {  
                    noun.addId(id);  
                    nounSET.add(noun);  
                }  
                  
            }  
            //add it to the idList  
            idList.add(synsetLine[1]);  
            //continue reading synsets  
            line = inSynsets.readLine();  
        }  
          
        G = new Digraph(maxVertex);  
        //the candidate root  
        boolean[] isNotRoot = new boolean[maxVertex];  
        //start to read hypernyms.txt  
        line = inHypernyms.readLine();  
        while (line != null){  
            String[] hypernymsLine = line.split(",");  
            //String[0] is id  
            int v = Integer.parseInt(hypernymsLine[0]);  
            isNotRoot[v] = true;  
            //String[1] and others is its ancestor, constructing G  
            for (int i=1; i<hypernymsLine.length;i++){  
                G.addEdge(v, Integer.parseInt(hypernymsLine[i]));  
            }  
            line = inHypernyms.readLine();  
        }  
        //test for root: no cycle  
        DirectedCycle directedCycle = new DirectedCycle(G);  
        if (directedCycle.hasCycle()){  
            throw new java.lang.IllegalArgumentException();  
        }  
        //test for root: no more than one candidate root  
        int rootCount = 0;  
        for (boolean notRoot : isNotRoot){  
            if (!notRoot){  
                rootCount++;  
            }  
        }  
        if (rootCount > 1){  
            throw new java.lang.IllegalArgumentException();  
        }  
        sap = new SAP(G);  
  
    }  
  
    // the set of nouns (no duplicates), returned as an Iterable  
    public Iterable<String> nouns(){  
        Queue<String> nouns = new Queue<String>();  
        for (Noun noun : nounSET){  
            nouns.enqueue(noun.noun);  
        }  
        return nouns;  
    }  
  
    // is the word a WordNet noun?  
    public boolean isNoun(String word){  
        Noun noun = new Noun(word);  
        return nounSET.contains(noun);  
    }  
  
    // distance between nounA and nounB (defined below)  
    public int distance(String nounA, String nounB){  
        if (!isNoun(nounA)){  
            throw new java.lang.IllegalArgumentException();  
        }  
        if (!isNoun(nounB)){  
            throw new java.lang.IllegalArgumentException();  
        }  
        Noun nodeA = nounSET.ceiling(new Noun(nounA));  
        Noun nodeB = nounSET.ceiling(new Noun(nounB));  
        return sap.length(nodeA.getId(), nodeB.getId());  
    }  
  
    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB  
    // in a shortest ancestral path (defined below)  
    public String sap(String nounA, String nounB){  
        if (!isNoun(nounA)){  
            throw new java.lang.IllegalArgumentException();  
        }  
        if (!isNoun(nounB)){  
            throw new java.lang.IllegalArgumentException();  
        }  
        Noun nodeA = nounSET.ceiling(new Noun(nounA));  
        Noun nodeB = nounSET.ceiling(new Noun(nounB));  
        return idList.get(sap.ancestor(nodeA.getId(), nodeB.getId()));  
    }  
}  
