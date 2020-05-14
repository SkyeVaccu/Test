import java.util.ArrayList;

public class Stack<E> {
    ArrayList<E> arrayList=new ArrayList<E>();;
    public boolean push(E a){
        try {
            arrayList.add(a);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public E pop(){
        E o = (E)arrayList.get(arrayList.size() - 1);
        arrayList.remove(arrayList.size()-1);
        return o;
    }

    public E getTop(){
        E o = (E)arrayList.get(0);
        return o;
    }
}
