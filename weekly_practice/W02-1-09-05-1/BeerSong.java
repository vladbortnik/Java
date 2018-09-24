
public class BeerSong {
    public static void main (String[] args) {
        int beerNum = 99;
        int takeDownNum = 1; 

        
        if (args.length == 1) {
            beerNum = Integer.parseInt(args[0]);
        } else if (args.length >= 2) {
            beerNum = Integer.parseInt(args[0]);
            takeDownNum = Integer.parseInt(args[1]);
        }

        String word = "bottles";


        // Bug 1: It says "1 bottles of beer on the wall" and after it says "bottle".
        

        while (beerNum > 0 ) {
            if (beerNum ==1) {
                word = "bottle";
            }
            
            System.out.println(beerNum + " " + word + " of beer on the wall");
            System.out.println(beerNum + " " + word + " of beer.");
            System.out.println("Take one down.");
            System.out.println("Pass it around.") ;
            beerNum -= takeDownNum;
            
            if (beerNum ==1) {          //  THIS 3 LINES WILL FIX BUG #1
                word = "bottle";
            }

            if (beerNum > 0) {
                System.out.println(beerNum + " " + word + " of beer on the wall");
            } else {
                System.out.println("No more bottles of beer on the wall.");
            } // end else
        } // end while loop
    } // end main method
} // end class
