/**
 * Created by mezkresh on 25.10.2017.
 */
public class Node {

    public String keys[] = new String[3];
    public int numOfKeys,numOfChildrens = 0;
    public Node parent,childrens[] = new Node[4];

    public void sort(){
        String tmp;
        for(int i=0;i<numOfKeys;i++){
            for(int j=i;j<numOfKeys;j++){
                if(keys[i].hashCode()>keys[j].hashCode()){
                   tmp=this.keys[i];
                    this.keys[i]=this.keys[j];
                    this.keys[j] = tmp;
                }
            }
        }
    }
    public Node(){
        numOfChildrens = 0;
    }

    public boolean equals2(Node t){
        boolean flag = true;
        if(this.numOfKeys!=t.numOfKeys || this.numOfChildrens!=t.numOfChildrens)
            flag = false;
        for(int i=0;i<this.numOfKeys;i++){
            if(this.keys[i].hashCode()!=t.keys[i].hashCode())
                flag = false;
        }
        return  flag;
    }



}
