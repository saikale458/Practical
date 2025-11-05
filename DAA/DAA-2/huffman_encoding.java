import java.util.*;

// Node class representing each node in Huffman Tree
class Node {
    Node left;
    Node right;
    Character value;
    int frequency;

    Node(Character value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }

    Node(Node left, Node right, int frequency) {
        this.left = left;
        this.right = right;
        this.frequency = frequency;
    }
}

// Huffman Encoding class
class HuffmanEncoding {
    private List<Node> q = new ArrayList<>();
    private String text;
    private Map<Character, String> encoding = new HashMap<>();

    HuffmanEncoding(String text) {
        this.text = text;
    }

    // Step 1: Count frequency of each character
    private void charFrequency() {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : text.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            q.add(new Node(entry.getKey(), entry.getValue()));
        }

        q.sort(Comparator.comparingInt(n -> n.frequency));
    }

    // Step 2: Build Huffman Tree
    private void buildTree() {
        while (q.size() > 1) {
            Node n1 = q.remove(0);
            Node n2 = q.remove(0);

            Node newNode = new Node(n1, n2, n1.frequency + n2.frequency);
            q.add(newNode);
            q.sort(Comparator.comparingInt(n -> n.frequency));
        }
    }

    // Step 3: Recursive helper to assign binary codes
    private void helper(Node node, String binaryStr) {
        if (node == null)
            return;

        if (node.value != null) { // leaf node
            encoding.put(node.value, binaryStr);
            return;
        }

        helper(node.left, binaryStr + "0");
        helper(node.right, binaryStr + "1");
    }

    // Step 4: Generate Huffman encoding
    private void huffmanEncoding() {
        if (q.isEmpty()) return;
        Node root = q.get(0);
        helper(root, "");
    }

    // Step 5: Print encoding table
    private void printEncoding() {
        System.out.println(" Char | Huffman Code ");
        System.out.println("---------------------");
        for (Map.Entry<Character, String> entry : encoding.entrySet()) {
            System.out.printf("  %-4s| %s%n", entry.getKey(), entry.getValue());
        }
    }

    // Step 6: Encode the full string
    public void encode() {
        charFrequency();
        buildTree();
        huffmanEncoding();
        printEncoding();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string to be encoded: ");
        String input = sc.nextLine();
        HuffmanEncoding encoder = new HuffmanEncoding(input);
        encoder.encode();
        sc.close();
    }
}
