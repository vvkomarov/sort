import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by World in fire on 05.11.2015.
 */
public class quicksort
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<Integer> list = createList();
        Date starttime = new Date();
        sortList(list);
        Date finishtime = new Date();
        long resulttime = finishtime.getTime() - starttime.getTime();
        printList(list);
        System.out.println("time distance is " + resulttime + " is ms");
    }

    public static ArrayList<Integer> createList() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        for ( ;true; ){ // Ввод до end
            String s = reader.readLine();
            if (s.equals("end")){
                break;
            }
            else{
                list.add(Integer.parseInt(s));
            }
        }
        return list;
    }

    public static ArrayList<Integer> sortList(ArrayList<Integer> list){
        if (list.size() == 0) {
            return list;
        }
        ArrayList<Integer> right = new ArrayList<Integer>();
        ArrayList<Integer> left = new ArrayList<Integer>();
        int tail = list.get(list.size()/2);
        list.remove(list.size()/2);
        for (Integer aList : list){ //����������
            if ( tail >= aList){
                left.add(aList);
            } else
                right.add(aList);
        }
        list.clear();
        list.addAll(sortList(left));
        list.add(tail);
        list.addAll(sortList(right));
        return list;
    }

    public static void printList(ArrayList<Integer> list)
    {
        for (Integer aList : list)
        { //Вывод
            System.out.println(aList);
        }
    }
}