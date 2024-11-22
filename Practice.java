import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Practice{

    // First Non_repeated character in a string using streamsAPI.
    public Character firstUniqueCharacter(String input){
        Map<Character, Integer> countMapUnique = new LinkedHashMap<>(); //I'm using LinkedHashMap to implement Map interface to preserve the order of elements that are added.

        for(char ch : input.toCharArray()){
            countMapUnique.put(ch, countMapUnique.getOrDefault(ch, 0) + 1);
        }

        Character unique = countMapUnique.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);

        return unique;
    }

    // Top K Frequency words using streams.
    public List<String> topKFreq(String[] input, int k){
        Map<String, Integer> wordFreqCount = new LinkedHashMap<>();

        for(String word : input){
            wordFreqCount.put(word, wordFreqCount.getOrDefault(word, 0) + 1);
        }

        List<String> topK = wordFreqCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k).map(Map.Entry::getKey).collect(Collectors.toList());

        return topK;
    }

    // Sum of Unique elements in a arraylist.
    public int sumOfUnique(List<Integer> arr){
        int sum = 0;

        sum = arr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() == 1).mapToInt(Map.Entry::getKey).sum();

        return sum;
    }
}