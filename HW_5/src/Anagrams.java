// cs 570 assignment 5 
// zening fang

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.*;

public class Anagrams{
    final Integer[] primes;
    Map<Character,Integer> letterTable;
    Map<Long,ArrayList<String>> anagramTable;
    
    // constructor 
    public Anagrams() {
        primes = new Integer[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,83,89,97,101};
        buildLetterTable();
        anagramTable = new HashMap<Long, ArrayList<String>>();
    }
    
    // define the letter table so each letter is refenced to a unique prime number
    private void buildLetterTable(){
        letterTable = new HashMap<Character, Integer>();
        Character letter[]= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		for(int i=0;i<26;i++) {
			this.letterTable.put(letter[i],primes[i]);
		}
    }
    
    // add the words to the anagram table
    private void addWord(String s){
        Long key = this.myHashCode(s);
        ArrayList<String> words = anagramTable.get(this.myHashCode(s));
        if(words == null){
            words = new ArrayList<>(); 
            words.add(s);
            anagramTable.put(key, words);
        }else{
            words.add(s);
        }
    }

    // transform the string to its unique hash code
    private Long myHashCode(String s){
        long hashCode = 1;
		int prime_no = 0;
        if(s == null){
            throw new NumberFormatException("the given string is null");
        }else{
            for (int i = 0; i < s.length(); i++) {
        	    //by multipling the primes referenced to each letter, to get the key
                Character a = s.charAt(i);
        	    prime_no = letterTable.get(a);
        	    hashCode = hashCode * prime_no;
            }
            return hashCode;
        }
    }
    
    // read in the file
    public void processFile(String s) throws IOException{
        FileInputStream fstream = new FileInputStream(s);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream ));
        String strLine;
        while (( strLine = br.readLine ()) != null) {
            this.addWord(strLine );
        }
        br.close ();
    }

    // return entries with the largest size of arraylist in the anagram
    private ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries(){
        ArrayList<Map.Entry<Long,ArrayList<String>>> result = new ArrayList<>(); 
        int max = 0;
        for(Map.Entry<Long,ArrayList<String>> entry: anagramTable.entrySet()){
            int size = entry.getValue().size();
            if (size == max) {
                result.add(entry);
            } else if (size > max) {
                result.clear();
                result.add(entry);
                max = size;
            }
        }
        return result;
    }


    public static void main(String[] args){
        Anagrams a = new Anagrams ();
        final long startTime = System.nanoTime ();
        try {a.processFile("words_alpha.txt");
        } catch (IOException e1) {
            e1.printStackTrace ();
        }
        ArrayList <Map.Entry <Long ,ArrayList <String >>> maxEntries = a.getMaxEntries ();
        final long estimatedTime = System.nanoTime () - startTime;
        final double seconds = (( double) estimatedTime /1000000000);
        System.out.println("Time: "+ seconds );
        System.out.println("List of max anagrams: "+ maxEntries );
    }

}
