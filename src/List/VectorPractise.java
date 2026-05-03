package List;

import java.util.LinkedList;
import java.util.Vector;

public class VectorPractise {

	public static void main(String[] args) {
		
      Vector<Integer> list = new Vector<>(5, 3); // 5 = initial capacity and 3 = increment factor. otherwise double growth factor
      
      list.add(1); // O(n)
      list.add(1);
      list.add(1);
      list.add(1);
      list.add(1);
      
      System.out.println(list.capacity());  // we  can check capacity also in vector directly
      list.add(1);
      
      System.out.println(list.capacity());
      
      list.add(1);
      list.add(1);
      
      System.out.println(list.capacity());
      
      list.add(1);
      
      System.out.println(list.capacity());
      
      LinkedList<Integer> linkedList = new LinkedList<>();
      linkedList.add(1);
      linkedList.add(2);
      linkedList.add(3);
      
      Vector<Integer> vector1 = new Vector<>(linkedList);
      
      System.out.println(vector1);
      
      for(int i = 0; i < vector1.size(); i++){
          System.out.println(vector1.get(i));
      }
      
      vector1.clear();
      
      System.out.println(vector1);

      // checking thread safety

      Vector<Integer> vector = new Vector<>();
      Thread t1 = new Thread(() -> {
          for (int i = 0; i < 1000; i++) {
              vector.add(i);
          }
      });
      Thread t2 = new Thread(() -> {
          for (int i = 0; i < 1000; i++) {
              vector.add(i);
          }
      });

      t1.start();
      t2.start();

      try {
          t1.join();
          t2.join();
      } catch (InterruptedException e) {
          e.printStackTrace();
      }

      System.out.println("Size of list: " + vector.size()); // Output: 2000


	}

}
