import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TemplateFileIO {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner in = new Scanner(file);
        String ansText= "";
        HashMap<String,Long> map = new HashMap<>();
        while(in.hasNextLine()){
            String[] words = in.nextLine().split(" ");
            if(words[0].equals("DEPOSIT")){
                if(!map.containsKey(words[1])){
                    map.put(words[1],0L);
                }
                map.put(words[1],map.get(words[1])+Integer.parseInt(words[2]));
            }else if(words[0].equals("INCOME")){
                for(Map.Entry<String,Long> map1 : map.entrySet()){
                    if(map1.getValue()>0){
                        map.put(map1.getKey(),(map1.getValue()*(100+Integer.parseInt(words[1])))/100);
                    }
                }
            }else if(words[0].equals("WITHDRAW")){
                if(!map.containsKey(words[1])){
                    map.put(words[1],0L);
                }
                map.put(words[1],map.get(words[1])-Integer.parseInt(words[2]));
            }else if(words[0].equals("BALANCE")){
                if(!map.containsKey(words[1])){
                    System.out.println("ERROR");
                }else{
                    System.out.println(map.get(words[1]));
                }
            }else if(words[0].equals("TRANSFER")){
                if(!map.containsKey(words[1])){
                    map.put(words[1],0L);
                }
                if(!map.containsKey(words[2])){
                    map.put(words[2],0L);
                }
                int n = Integer.parseInt(words[3]);
                map.put(words[1],map.get(words[1])-n);
                map.put(words[2],map.get(words[2])+n);
            }
        }

    }


}
//["ab", "a"]
//["c","acc","ccc"]
