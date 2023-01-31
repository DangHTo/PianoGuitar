public class PianoKeyPress
{
   private RingBuffer string; 
   private int count;
   
   public PianoKeyPress(double frequency)
   {
      int n = (int)(44100.0/frequency);
      string = new RingBuffer(n); 
      count = 0;
   }
   
   public PianoKeyPress(double[] init)
   {
      string = new RingBuffer(init.length);
      for(int i = 0; i < init.length; i++)
      {
         string.enqueue(init[i]);
      }
      count = 0;
   }
   //
   //
   public void pluck()
   {
      for(int i = 0; i < string.size(); i++)
      {
         string.dequeue();
         string.enqueue(Math.random() - .5);
      }
   }
   //
   //
   public void tic()
   {
      //.996 Energy Decay Factor
      double x = string.dequeue();
      double y = string.peek();
      double result = .996 * (.5 * (x + y));
      string.enqueue(result);
      count++;
   }
   //
   //
   public double sample()
   {
      return string.peek();
   }
   //
   //
   public int time()
   {
      return count;
   }
}