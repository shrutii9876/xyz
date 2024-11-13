import java.util.*;

class Node{
    char ch;
    int freq;
    Node left,right;

    Node(char ch,int freq){
        this.ch=ch;
        this.freq=freq;
    }

    Node(int freq, Node left, Node right){
        this.freq=freq;
        this.left=left;
        this.right=right;
    }
}

public class Huffman{

    public static Node buildTree(HashMap<Character,Integer> freqMap){
        PriorityQueue<Node> queue=new PriorityQueue<>((a,b)->a.freq-b.freq);
        freqMap.forEach((ch,freq)->queue.add(new Node(ch,freq)));

        while(queue.size()>1){
            Node left=queue.poll(),right=queue.poll();
            queue.add(new Node(left.freq+right.freq,left,right));
        }
        return queue.poll();
    }

    public static void generateCodes(Node root,String code,Map<Character,String> huffmanCode){
        if(root==null) return;
        if(root.left==null && root.right==null) huffmanCode.put(root.ch,code);

        generateCodes(root.left,code+"0",huffmanCode);
        generateCodes(root.right,code+"1",huffmanCode);
    }

    public static void main(String[] args){
        String str="huffman encoding";

        HashMap<Character,Integer> freqMap=new HashMap<>();
        for(char ch : str.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }

        Node root=buildTree(freqMap);
        Map<Character,String> huffmanCode=new HashMap<>();
        generateCodes(root,"",huffmanCode);

        System.out.println("Huffman Codes: "+huffmanCode);
        StringBuilder encodedText=new StringBuilder();
        for(char ch : str.toCharArray()){
            encodedText.append(huffmanCode.get(ch));
        }

        System.out.println("Encoded Text: "+encodedText);
    }
}