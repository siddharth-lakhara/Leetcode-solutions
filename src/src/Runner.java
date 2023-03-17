import _208.Trie;

public class Runner {

    public static void main(String[] args) {
//        ConstructTree solution = new ConstructTree();
//        solution.driver();

        String word = "apple";
        String prefix = "app";
        Trie obj = new Trie();
        obj.insert(word);
        System.out.println("1 " + obj.search(word));
        System.out.println("2 " + obj.startsWith(prefix));
        System.out.println("3 " + obj.startsWith("app0"));
        System.out.println("3 " + obj.search("appl"));
    }
}
