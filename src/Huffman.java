import java.util.HashMap;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Huffman {
    public static double sc=0;
    public static class Node{
        Node UNO;
        Node ZERO;
        String key;
        double p;
        public Node(double p,String key){
            this.p=p;
            this.key=key;
        }
    }
    public static String alphabet="abcdefghijklmnopqrstuvwxyzöäüßABCDEFGHIJKLMNOPQRSTUVWXYZÜÖÄ";
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String eingabe=s.nextLine();
        HashMap<String, Integer> Probs=getprobswords(eingabe);
        System.out.println(Probs.get("hallo"));
    }
        public static HashMap<Character, Integer> getprobschar(String s){
            HashMap<Character, Integer> Probs=new HashMap<>();
            int l=s.length();
            for(int i=0;i<l;i++){
                char c=s.charAt(i);
                Probs.put(c,Probs.getOrDefault(c, 0) + 1);
            }
            return Probs;
        }
    public static HashMap<String, Integer> getprobswords(String s){
        HashMap<String, Integer> Probs=new HashMap<>();
        int l=s.length();
        String key="";
        boolean worttrenner=false;
        for(int i=0;i<l;i++){
            char c=s.charAt(i);
            if (alphabet.contains(""+c)){
                key=key.concat(c+"");
                worttrenner=false;
            }else{
                if (!worttrenner){
                    Probs.put(key,Probs.getOrDefault(key, 0) + 1);
                    sc++;
                    worttrenner=true;
                    key="";
                }
            }
        }
        if (!worttrenner){
            Probs.put(key,Probs.getOrDefault(key, 0) + 1);
            sc++;
            key="";
        }
        return Probs;
    }
    public static Node getHuff(HashMap<String,Integer> map){
        Set<Node> set=new HashSet<Node>();
        for (String key : map.keySet()) {
            Node n=new Node(map.get(key),key);
            set.add(n);
        }
        Node finalNode=null;
        while(set.size()<=1) {
            double min_p=sc;
            Node min_Node=new Node(1,"");
            for (Node n : set) {
                if(n.p<min_p){
                    min_p=n.p;
                    min_Node=n;
                }
            }
            if (finalNode==null){
                finalNode=min_Node;
            }else{
                Node fNode=new Node(min_p+finalNode.p,min_Node.key+" "+finalNode.key);
                fNode.UNO=Math.min();

            }
            set.remove(min_Node);
        }
    }
}
