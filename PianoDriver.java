public class PianoDriver {
   public static void main(String[] args) {
      StdDraw.setPenRadius(0.005);
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.rectangle(.5, .75, .4, .15);
      StdDraw.rectangle(.5, .25, .4, .15);
      
      double x = .1727;
      for(int i = 0; i < 11; i++)
      {
         StdDraw.setPenRadius(0.001);
         StdDraw.line(x, .90, x, .60);
         StdDraw.line(x, .10, x, .40);
         x += .0727;
      }
      
      StdDraw.filledRectangle(.1727, .8, .0215, .1);
      StdDraw.filledRectangle(.3181, .8, .0215, .1);
      StdDraw.filledRectangle(.3908, .8, .0215, .1);
      StdDraw.filledRectangle(.5362, .8, .0215, .1);
      StdDraw.filledRectangle(.6089, .8, .0215, .1);
      StdDraw.filledRectangle(.6816, .8, .0215, .1);
      StdDraw.filledRectangle(.827, .8, .0215, .1);
      StdDraw.filledRectangle(.9, .8, .0215, .1);
      
      StdDraw.filledRectangle(.2454, .30, .0215, .1);
      StdDraw.filledRectangle(.3181, .30, .0215, .1);
      StdDraw.filledRectangle(.3908, .30, .0215, .1);
      StdDraw.filledRectangle(.5362, .30, .0215, .1);
      StdDraw.filledRectangle(.6089, .30, .0215, .1);
      StdDraw.filledRectangle(.827, .30, .0215, .1);
      StdDraw.filledRectangle(.7543, .30, .0215, .1);
      
      
      //.0363
      //q to [
      StdDraw.text(.1364, .58, "q");
      StdDraw.text(.1727, .92, "2");
      StdDraw.text(.209, .58, "w");
      StdDraw.text(.2817, .58, "e");
      StdDraw.text(.3181, .92, "4");
      StdDraw.text(.3544, .58, "r");
      StdDraw.text(.3908, .92, "5");
      StdDraw.text(.4271, .58, "t");
      StdDraw.text(.4998, .58, "y");
      StdDraw.text(.5262, .92, "7");
      StdDraw.text(.5725, .58, "u");
      StdDraw.text(.6089, .92, "8");
      StdDraw.text(.6452, .58, "i");
      StdDraw.text(.6816, .92, "9");
      StdDraw.text(.7179, .58, "o");
      StdDraw.text(.7906, .58, "p");
      StdDraw.text(.827, .92, "-");
      StdDraw.text(.8633, .58, "[");
      StdDraw.text(.9, .92, "=");
      
      //.0363
      //z to / and then space
      StdDraw.text(.1364, .08, "z");
      StdDraw.text(.209, .08, "x");
      StdDraw.text(.2454, .42, "d");
      StdDraw.text(.2817, .08, "c");
      StdDraw.text(.3181, .42, "f");
      StdDraw.text(.3544, .08, "v");
      StdDraw.text(.3908, .42, "g");
      StdDraw.text(.4271, .08, "b"); 
      StdDraw.text(.4998, .08, "n");
      StdDraw.text(.5262, .42, "j");
      StdDraw.text(.5725, .08, "m");
      StdDraw.text(.6089, .42, "k");
      StdDraw.text(.6452, .08, ",");
      StdDraw.text(.7179, .08, ".");
      StdDraw.text(.7543, .42, ";");
      StdDraw.text(.7906, .08, "/");
      StdDraw.text(.827, .42, "'");
      StdDraw.text(.8633, .08, "space");
      
          // create 37 guitar strings
      String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
      PianoKeyPress[] geetar = new PianoKeyPress[37];
      double count = 0.0;
      for(int i = 0; i < geetar.length; i++)
      {
         geetar[i] = new PianoKeyPress(440 * Math.pow(1.05956, count - 24));
         count ++;
      }
          
   //          double CONCERT_A = 440.0;
   //          double CONCERT_C = CONCERT_A * Math.pow(1.05956, 3.0);  
   //          GuitarString stringA = new GuitarString(CONCERT_A);
   //          GuitarString stringC = new GuitarString(CONCERT_C);
      double begin = 0;
      double save = 0;
      while (true) {
      
              // check if the user has typed a key; if so, process it   
         if (StdDraw.hasNextKeyTyped()) {
            char key = StdDraw.nextKeyTyped();
            if(keyboard.indexOf(key) != -1)
               geetar[keyboard.indexOf(key)].pluck();
         }
      
              // compute the superposition of samples
         double sample = 0;
         for(int i = 0; i < keyboard.length(); i++)
            sample += geetar[i].sample();
      
              // play the sample on standard audio
         StdAudio.play(sample);
         
              //Sound wave?
         
              // advance the simulation of each guitar string by one step   
         for(int i = 0; i < keyboard.length(); i++)
            geetar[i].tic();
      }
   }
}4