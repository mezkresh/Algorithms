import java.io.FileNotFoundException;

public interface ITree <T extends Comparable>{

    /**
     * Interface Tree used for creating trees.
     * Contains the following methods:
     * 1. {@link ITree#find(String)}            ---> finding element
     * 2. {@link ITree#insert(String)}          ---> inserting element
     * 3. {@link ITree#remove(String)}          ---> removing element
     * 4. {@link ITree#traverse())}              ---> goes through all nodes (in-order)
     * 5. {@link ITree#print()}                     ---> prints out every element of tree
     * @param x
     * @return
     */


    T find(String x);
    void insert(String x) throws FileNotFoundException;
    void remove(String x) ;
    String traverse(Node n);
    String print() throws InterruptedException;



}
