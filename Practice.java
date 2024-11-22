import java.util.*;
import java.util.stream.Collectors;

class Practice{

    public Character firstUniqueCharacter(String input){
        Map<Character, Integer> countMapUnique = new LinkedHashMap<>(); //I'm using LinkedHashMap to implement Map interface to preserve the order of elements that are added.

        for(char ch : input.toCharArray()){
            countMapUnique.put(ch, countMapUnique.getOrDefault(ch, 0) + 1);
        }

        Character unique = countMapUnique.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);

        return unique;
    }

    public List<String> topKFreq(String[] input, int k){
        
    }
}