import java.io.FileNotFoundException;


public class BTree extends BST implements ITree{
    public static BNode root;

    public BTree() throws FileNotFoundException{
        this.root = null;
    }

    /**
     * Almost the same as in BST class
     * @param x
     * @return
     */
    public Comparable find(String x) {
        return null;
    }
    private BNode findNode(String s, BNode t) throws NullPointerException{
        if(t.numOfChildrens==0){
            return t;
        }
        if(t.numOfKeys==1){
            if(t.keys[0].hashCode()<s.hashCode()){
                return findNode(s,t.childrens[1]);
            }
            else return findNode(s,t.childrens[0]);
        }
        if(t.numOfKeys==2){
            if(t.keys[0].hashCode()>=s.hashCode()){
                return findNode(s,t.childrens[0]);
            }
            else if(t.keys[1].hashCode()>=s.hashCode()){
                return findNode(s,t.childrens[1]);
            }
            else return findNode(s,t.childrens[2]);
        }
        return null;
    }

    /**
     * Split method used for split node into two nodes;
     *
     * Use:
     *
     * 1. Check whether parent is null or not.
     * 2. Then check whether amount of children is 0; needed to be sure,that our tree will not get disbalanced;
     * 3. Creating nodes and re insert values.
     *
     * @param t
     */

    private void split(BNode t){
        if(t.parent == null){
            if(t.numOfChildrens==0){
                BNode n = new BNode();
                n.numOfKeys = 1;
                n.keys[0] = t.keys[1];

                BNode b = new BNode();
                b.numOfKeys = 1;
                b.keys[0] = t.keys[2];
                b.parent = n;

                t.numOfKeys = 1;
                t.keys[1] = null;
                t.keys[2] = null;
                t.parent = n;
                root = n;
                n.numOfChildrens = 2;
                n.childrens[0] = t;
                n.childrens[1] = b;
                return;
            }
            else {
                BNode n = new BNode();
                n.numOfKeys = 1;
                n.keys[0] = t.keys[1];

                BNode b = new BNode();
                b.numOfKeys = 1;
                b.keys[0] = t.keys[2];
                b.numOfChildrens = 2;
                b.childrens[0] = t.childrens[2];
                b.childrens[1] = t.childrens[3];
                b.childrens[0].parent = b;
                b.childrens[1].parent = b;
                b.parent = n;
                root = n;
                t.numOfKeys = 1;
                t.keys[1] = null;
                t.keys[2] = null;
                t.numOfChildrens = 2;
                t.childrens[2] = null;
                t.childrens[3] = null;
                t.parent = n;

                n.numOfChildrens = 2;
                n.childrens[0] = t;
                n.childrens[1] = b;
                return;
            }

        }
        if(t.numOfChildrens == 0){
            BNode n = new BNode();
            n.numOfKeys = 1;
            n.keys[0] = t.keys[2];
            n.parent = t.parent;


            int b = 0;
            for(int i=0;i<t.parent.numOfChildrens;i++){
                if(t.parent.childrens[i].equals2(t)){
                    b=i;
                }
            }
            for(int i=t.parent.numOfChildrens;i>b;i--){
                t.parent.childrens[i] = t.parent.childrens[i-1];
            }
            t.parent.keys[t.parent.numOfKeys] = t.keys[1];
            t.parent.numOfKeys++;
            t.parent.childrens[b] = t;
            t.parent.childrens[b+1] = n;
            t.parent.numOfChildrens++;
            t.keys[1] = null;
            t.keys[2] = null;
            t.numOfKeys = 1;
            t.parent.sort();
        }
        else {
            BNode n = new BNode();
            n.numOfKeys = 1;
            n.keys[0] = t.keys[2];
            n.parent = t.parent;
            n.numOfChildrens = 2;
            t.childrens[2].parent = n;
            t.childrens[3].parent = n;
            n.childrens[0] = t.childrens[2];
            n.childrens[1] = t.childrens[3];

            t.parent.keys[t.parent.numOfKeys]= t.keys[1];
            t.parent.numOfKeys++;
            t.parent.sort();

            int b = 0;
            for(int i=0;i<t.parent.numOfChildrens;i++){
                if(t.parent.childrens[i].equals2(t)){
                    b=i;
                }
            }
            for(int i=t.parent.numOfChildrens;i>b;i--){
                t.parent.childrens[i] = t.parent.childrens[i-1];
            }
            t.parent.numOfChildrens++;
            t.parent.childrens[b] = t;
            t.parent.childrens[b+1] = n;
            t.numOfChildrens = 2;
            t.childrens[2] = null;
            t.childrens[3] = null;
            t.numOfKeys = 1;
            t.keys[1] = null;
            t.keys[2] = null;
        }
        if(t.parent.numOfKeys>2)
            split(t.parent);
    }

    public void insert(String x) throws FileNotFoundException {
        if(root==null){
            root = new BNode();
            root.keys[0] = x;
            root.numOfKeys =1;
            return;
        }
        BNode a = findNode(x,root);
        a.keys[a.numOfKeys] = x;
        a.numOfKeys++;
        a.sort();
        if(a.numOfKeys>2){
            split(a);
        }
    }


    public void remove(String x) {
    }


    public String traverse(BNode n) {

        String result = "";
        if(n.numOfChildrens!=0){
            result += traverse(n.childrens[0]);
        }
        result+=n.keys[0]+" ";
        if(n.numOfChildrens>0){
            result+=traverse(n.childrens[1]);
        }
        if(n.numOfKeys>1)
            result+=n.keys[1]+" ";
        if(n.numOfChildrens>2){
            result+=traverse(n.childrens[2]);
        }

        return result;

    }

    @Override
    public String print() throws InterruptedException {
        return null;
    }
}
