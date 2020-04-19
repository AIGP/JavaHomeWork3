package HomeWork4;

public class OneThread implements Runnable {

    String letter;
    Thread self;
    int sequence;
    int loopNumber;
    int maxLoopNumber;

    OneThread(String letter, int sequence, int maxLoopNumber){
        this.self=new Thread(this);
        this.letter=letter;
        this.sequence=sequence;
        this.maxLoopNumber=maxLoopNumber;
    }

    void start(){
        this.loopNumber=0;
        self.start();
    }

    @Override
    public void run() {
        synchronized (ThreeTreads.mon) {
            while (loopNumber < maxLoopNumber) {
                if (sequence == ThreeTreads.mainSequence) {
                    System.out.println(letter+": "+loopNumber);
                    loopNumber++;
                    ThreeTreads.mainSequence++;
                    if (ThreeTreads.mainSequence >= ThreeTreads.quantity) {
                        ThreeTreads.mainSequence = 0;
                    }
                    ThreeTreads.mon.notifyAll();
                    if(loopNumber < maxLoopNumber){
                        try {
                            ThreeTreads.mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    try {
                        ThreeTreads.mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void join() throws InterruptedException {
        self.join();
    }



}
