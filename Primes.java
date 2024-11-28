public class Primes {
    public static void main(String[] args) {
   
        printPrimeUntil(Integer.parseInt(args[0]));
    }
    public static void printPrimeUntil (int n){

        // build an array with all the elements to be ture except 1 and 0
        boolean[] arr = new boolean[n + 1];
        for (int i = 2; i <arr.length; i++) arr[i] = true;
        
        int currentIndex = 2;
        int counterOfPrimes = 0;
        while (currentIndex < Math.sqrt(arr.length - 1)){
            
            if (arr[currentIndex]){
                
                // cross out all the multiples of arr[currentIndex]
                for (int i = currentIndex + 1; i < arr.length; i ++){
                    if(i % currentIndex == 0) arr[i] = false;
                }

            }
            currentIndex += 1;
        }
        
        // print the conclusion
        System.out.println("Prime Numbers up to " + n + ":");
        
        for (int i = 0; i < arr.length; i++){
            if (arr[i]){
                System.out.println(i);
                counterOfPrimes += 1;
            }
        }
        
        System.out.println("There are " + counterOfPrimes + " primes between 2 and " + n + " (" + (int) (100 * ((double) counterOfPrimes / (arr.length - 1) ))+ "% are primes)");

    }
}

