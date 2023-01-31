public class RingBuffer
{
   private int first;
   private int last;
   private double[] arr;
   
   public RingBuffer(int capacity)
   {
      arr = new double[capacity];
      for(int i = 0; i < arr.length; i++)
         arr[i] = 0;
      first = 0;
      last = 0;
   }
   //
   //
   public int size()
   {
      int count = 0;
      for(int i = 0; i < arr.length; i++)
      {
         if(arr[i] <= .5 && arr[i] >= -.5)
            count++;
      }
      return count;
   }
   //
   //
   public boolean isEmpty()
   {
      if(this.size() == 0)
         return true;
      return false;
   }
   //
   //
   public boolean isFull()
   {
      if(this.size() == arr.length - 1)
         return true;
      return false;
   }
   //
   //
   public void enqueue(double x)
   {
      if(isFull())
         throw new IndexOutOfBoundsException("Buffer Problemo");
      arr[last] = x;
      if(last == arr.length - 1)
         last = 0;
      else
         last++;
   }
   //
   //
   public double dequeue()
   {
//       if(this.size() == 0)
//          throw new IndexOutOfBoundsException("Size: " + this.size() + "  Add something first");
      double val = arr[first];
      arr[first] = 0;
      if(first == arr.length - 1)
         first = 0;
      else
         first++;
      return val;
   }
   //
   //
   public double peek()
   {
      return arr[first];
   }
}