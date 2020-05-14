import java.util.HashMap;

public class cart {
    HashMap<String,Object> hashMap=new HashMap<>();
    public cart(){
        hashMap.put("手机","小米10");
        hashMap.put("电视","智慧屏");
    }

    public boolean addCommdity(String title,Object temp){
        try {
            hashMap.put(title,temp);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeCommdity(String title){
        try {
            hashMap.remove(title);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public int count(){
        return hashMap.size();
    }
}
