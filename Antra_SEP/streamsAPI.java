import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class streamsAPI{
    /*
     * The StreamsAPI in java introduced in Java 8 to simplify bulk operations on data like filtering, mapping, and reducing by processing collections in a functional and declarative way.
     * Key characterstics : 
     * - Do not store data
     * - Lazy Execution: operations are executed only when required
     * - Immutability: original data source is not modified.
     * - Can be sequential or parallel.
     * Intermediate operations:
     * - They transform a stream into another stream.
     * - They are lazy, meaning they do not execute until a terminal operation is invoked.
     * Terminal operations:
     * - Trigger the execution of intermediate operations and produces a result or side effect.
     * - They are eager, meaning they execute entire stream when invoked.
     */

    //filter()(Filters stream based on a predicate) operation example
    public void filter_eg(){
        List<String> names = Arrays.asList("Alice", "Bob");
        names.stream().filter(n -> n.startsWith("A")).forEach(System.out::println);
    }

    //map()(Transforms elements in a stream) operation example
    public void map_eg(){
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        numbers.stream().map(n -> n * 2).forEach(System.out::print);
        System.out.println();
    }

    //flatMap() flattens nested structures.
    public void flatmap_eg(){
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1,2), Arrays.asList(3,4));
        lists.stream().flatMap(List::stream).forEach(System.out::print);
        System.out.println();
    }

    //Collectors collects the stream elements and reduces to data structures or results.
    public List<Integer> collectors_eg(){
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squared = nums.stream().map(n -> n * n).collect(Collectors.toList());
        return squared;
    }

    //sorted() sorts the elements in natural order or custom order.
    public void sorted_eg(){
        List<Integer> nums = Arrays.asList(3, 1, 2);
        nums.stream().sorted().forEach(System.out::print);
        System.out.println();
    }

    /*
     * findFirst() - return first element
     * FinfAny() - returns any element(useful in parallel executions)
     */
    public void exmpl(){
        List<Integer> nums = Arrays.asList(1, 2, 3);
        System.out.println(nums.stream().findFirst().orElse(-1));
    }

    //reduce() aggregates elements into a single unit.
    public void reduce_eg(){
        List<Integer> nums = Arrays.asList(1, 2, 3);
        int sum = nums.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    //distinct() removes duplicate elements
    public void distinct_eg(){
        List<Integer> nums = Arrays.asList(1, 2, 2, 3);
        nums.stream().distinct().forEach(System.out::print);
        System.out.println();
    }

    //Infinite stream in java => Stream.generate() or Stream.iterate()
    public void exmpl(int limit){
        Stream<Integer> infinite = Stream.iterate(0, n -> n+1);
        infinite.limit(limit).forEach(System.out::print);
        System.out.println();
    }

    //peek() allows inspection without modifying the stream.(used for logging and debugging)
    public void peek_eg(){
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        nums.stream().peek(System.out::print).map(n -> n * n).forEach(System.out::println);
    }

    //ParallelStreams executes operations concurrently
    public void ParallelStreams_eg(){
        List<Integer> lst = List.of(1, 2, 3, 4);
        lst.parallelStream().forEach(System.out::println);
    }

    //toMap() converts elements into a map
    public void toMap_ex(){
        List<String> names = Arrays.asList("Alice", "Bob","carie");
        Map<String, Integer> nameLen = names.stream().collect(Collectors.toMap(n -> n, String::length));
        System.out.println(nameLen);
    }

    //groupingBy() groups elements by a classifier function
    public void grouping_ex(){
        List<String> namesList = Arrays.asList("Alice", "Angel", "Baby", "Berlin");
        Map<Character,List<String>> grouped = namesList.stream().collect(Collectors.groupingBy(n -> n.charAt(0)));
        System.out.println(grouped);
    }

    //partitioningBy() partitions elements into two groups based on a predicate
    public void partition_ex(){
        List<Integer> lst = Arrays.asList(1, 2, 3, 4);
        System.out.println(lst.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0)));
    }

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

    /*Executor Service in Java : 
     * ExecutorService is part of the java.util.concurrent package and provides a high-level framework for managing and controlling threads. 
     * It abstracts the complexity of thread creation, management, and execution, offering a more robust and scalable alternative to manually managing threads using the Thread class.
     * 
     */
    public static void main(String[] args){
        streamsAPI ex1 = new streamsAPI();
        /* 
        ex1.filter_eg();
        ex1.map_eg();
        ex1.flatmap_eg();
        ex1.sorted_eg();
        ex1.distinct_eg();
        ex1.exmpl(5);
        ex1.peek_eg();
        */
        ex1.ParallelStreams_eg();
        ex1.toMap_ex();
        ex1.grouping_ex();
        ex1.partition_ex();
    }

}