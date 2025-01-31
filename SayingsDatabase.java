package sayingsDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * AVL Tree implementation for the Sayings Database. It stores Hawaiian sayings,
 * their English
 * translations, and explanations, supporting operations like insert, search,
 * and finding
 * predecessors/successors alphabetically.
 * 
 * @author Binh Tran and Ellie Ishii
 *
 */
public class SayingsDatabase {
    // internal node class that represents a node in the AVL Tree
    private class Node {
        Saying saying; // the saying that is stored in the node
        Node left, right; // left and right children
        int height; // height of the node in the tree

        // constructor for a node that initializes the saying and sets height to 1
        Node(Saying saying) {
            this.saying = saying;
            height = 1;
        }
    }

    private Node root; // root of the AVL tree

    // Insert a new saying into the AVL tree
    public void insert(Saying saying) {
        root = insert(root, saying);
    }

    // helper function to insert a new saying in the tree and maintain AVL balance 
    private Node insert(Node node, Saying saying) {
        // if the current node is null, create a new node with the saying
        if (node == null) {
            return new Node(saying);
        }

        // compare the new saying with the current node's saying
        if (saying.getHawaiianWords().compareToIgnoreCase(node.saying.getHawaiianWords()) < 0) {
            // insert in the left subtree if the new saying is smaller
            node.left = insert(node.left, saying);
        } else if (saying.getHawaiianWords().compareToIgnoreCase(node.saying.getHawaiianWords()) > 0) {
            // insert in the right subtree if the new saying is larger
            node.right = insert(node.right, saying);
        } else {
            return node; // if there is a duplicate saying, do nothing
        }

        // Update height of the node
        node.height = 1 + Math.max(height(node.left), height(node.right));
        // balance the tree after insertion
        return balance(node);
    }

    // helper method to return the height of a node
    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    // calculate the balance factor of a node (left height - right height)
    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // Balance the AVL tree after an insertion or deletion
    private Node balance(Node node) {
        int balance = getBalance(node);

        // Left heavy case
        if (balance > 1) {
            // if the left child is right heavy, perform a left rotation on the left child
            if (getBalance(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            // right rotation to balance the tree
            return rotateRight(node);
        }

        // Right heavy case
        if (balance < -1) {
            // if the right child is left heavy, perform a right rotation on the right child
            if (getBalance(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            // left rotation to balance the tree
            return rotateLeft(node);
        }
        // return the balanced node
        return node;
    }

    // perform a right rotation on a subtree
    private Node rotateRight(Node y) {
        Node x = y.left; // set the left child as the new root of the subtree
        Node T2 = x.right; // temporarily store the right subtree of x

        // perform the rotations
        x.right = y;
        y.left = T2;

        // update heights of the rotated nodes
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // return the new root of the subtree
        return x;
    }

    // perform a left rotation on a subtree
    private Node rotateLeft(Node x) {
        Node y = x.right; // Set the right child as the new root of the subtree
        Node T2 = y.left; // Temporarily store the left subtree of y

        // perform rotations
        y.left = x;
        x.right = T2;

        // Update heights of the rotated nodes
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return the new root of the subtree
        return y;
    }

    // Retrieve all sayings in the database in sorted order (in-order traversal)
    public List<Saying> getAllSayings() {
        List<Saying> sayingsList = new ArrayList<>();
        inOrderTraversal(root, sayingsList);
        return sayingsList;
    }

    // get sayings in lexicographical order
    private void inOrderTraversal(Node node, List<Saying> sayingsList) {
        if (node != null) {
            inOrderTraversal(node.left, sayingsList);
            sayingsList.add(node.saying);
            inOrderTraversal(node.right, sayingsList);
        }
    }

    // Check if a saying is a member of the database (case insensitive)
    public boolean member(String hawaiianWords) {
        return search(root, hawaiianWords.toLowerCase()) != null;
    }

    // Search for a node containing the given Hawaiian words (case insensitive)
    private Node search(Node node, String hawaiianWords) {
        if (node == null) {
            return null;
        }

        // case insensitive comparison with the current node
        if (node.saying.getHawaiianWords().equalsIgnoreCase(hawaiianWords)) {
            return node;
        }

        // recursively search in the left or right subtree
        if (hawaiianWords.compareToIgnoreCase(node.saying.getHawaiianWords()) < 0) {
            return search(node.left, hawaiianWords);
        } else {
            return search(node.right, hawaiianWords);
        }
    }

    // Find the first saying (alphabetically)
    public Saying first() {
        return minValueNode(root).saying;
    }

    // Find the last saying (alphabetically)
    public Saying last() {
        return maxValueNode(root).saying;
    }

    // Get the node with the minimum value (leftmost node)
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Get the node with the maximum value (rightmost node)
    private Node maxValueNode(Node node) {
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    // Find the predecessor (largest node smaller than the target)
    public Saying predecessor(String hawaiianWords) {
        Node predecessor = predecessor(root, null, hawaiianWords);
        return predecessor != null ? predecessor.saying : null;
    }

    // helper method to find the predecessor of a given word
    private Node predecessor(Node node, Node predecessor, String hawaiianWords) {
        if (node == null) {
            return predecessor;
        }

        // recursively search for the predecessor
        if (hawaiianWords.compareToIgnoreCase(node.saying.getHawaiianWords()) > 0) {
            return predecessor(node.right, node, hawaiianWords);
        } else {
            return predecessor(node.left, predecessor, hawaiianWords);
        }
    }

    // Find the successor (smallest node greater than the target)
    public Saying successor(String hawaiianWords) {
        Node successor = successor(root, null, hawaiianWords);
        return successor != null ? successor.saying : null;
    }

    // helper method to find the successor of a given word
    private Node successor(Node node, Node successor, String hawaiianWords) {
        if (node == null) {
            return successor;
        }

        // recursively search for the successor
        if (hawaiianWords.compareToIgnoreCase(node.saying.getHawaiianWords()) < 0) {
            return successor(node.left, node, hawaiianWords);
        } else {
            return successor(node.right, successor, hawaiianWords);
        }
    }

    // Find sayings containing a specific word in Hawaiian
    public List<Saying> withWord(String word) {
        List<Saying> result = new ArrayList<>();
        searchByWord(root, word, result, true);
        return result;
    }

    // Find sayings containing a specific word in English
    public List<Saying> withWordInEnglish(String word) {
        List<Saying> result = new ArrayList<>();
        searchByWord(root, word, result, false); // Search in English
        return result;
    }

    // Search for sayings containing a specific word (in Hawaiian or English)
    private void searchByWord(Node node, String word, List<Saying> result, boolean searchInHawaiian) {
        if (node == null) {
            return;
        }

        // Determine the text to search based on the language specified
        String textToSearch = searchInHawaiian ? node.saying.getHawaiianWords() : node.saying.getEnglishTranslation();
        // Check if the text contains the specified word, case insensitive
        if (textToSearch.toLowerCase().contains(word.toLowerCase())) {
            result.add(node.saying);
        }

        // Recursively search left and right subtrees
        searchByWord(node.left, word, result, searchInHawaiian);
        searchByWord(node.right, word, result, searchInHawaiian);
    }

    // Method to find sayings containing a specific Hawaiian word
    public List<Saying> MeHua(String word) {
        List<Saying> results = new ArrayList<>();
        searchMeHua(root, word.toLowerCase(), results);
        return results;
    }

    // helper method to search for a specific Hawaiian word
    private void searchMeHua(Node node, String word, List<Saying> results) {
        if (node != null) {
            // Check the current saying for the word
            if (node.saying.getHawaiianWords().toLowerCase().contains(word)) {
                results.add(node.saying);
            }

            // recursively search the left and right subtrees
            searchMeHua(node.left, word, results);
            searchMeHua(node.right, word, results);
        }
    }
}
