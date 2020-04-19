package HomeWork4;

public class ThreeTreads {

    public static final Object mon = new Object();
    public volatile static int mainSequence = 0;
    public static int mainMaxLoop = 5;
    public static int quantity = 3;
    public static void main(String[] args) throws InterruptedException {
        OneThread[] threads=new OneThread[quantity];
        String[] letters={"A","B","C"};
        for (int i = 0; i < threads.length && i<letters.length; i++) {
            threads[i]=new OneThread(letters[i],i,mainMaxLoop);
            threads[i].start();
        }
        for (int i = 0; i < threads.length && i<letters.length; i++){
            threads[i].join();
        }
    }

}
