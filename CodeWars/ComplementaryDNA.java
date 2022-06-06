/*
Descripton:
Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions" for the development and functioning of living organisms.

If you want to know more: http://en.wikipedia.org/wiki/DNA

In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". You function receives one side of the DNA (string, except for Haskell); you need to return the other complementary side. DNA strand is never empty or there is no DNA at all (again, except for Haskell).

More similar exercise are found here: http://rosalind.info/problems/list-view/ (source)

Example: (input --> output)

"ATTGC" --> "TAACG"
"GTAT" --> "CATA"
*/

import java.util.Map;
import java.util.HashMap;

public class ComplementaryDNA {
  public static String makeComplement(String dna) {
    
     // Create map of complements
     Map<String, String> dnaMap = new HashMap<String, String>();
     dnaMap.put("A", "T");
     dnaMap.put("T", "A");
     dnaMap.put("C", "G");
     dnaMap.put("G", "C");
    
     // Create a string with all the complements
     String result = "";
     for(int i=0; i<dna.length(); i++)
     {
        result += dnaMap.get(dna.substring(i, i+1));  
     }
     
     return result;
  }
}
