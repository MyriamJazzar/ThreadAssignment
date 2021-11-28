public class ThreadAssignment {

    static class Counter {
        void count() {
            //todo implement me
            for(int i = 350; i>0; i--)
                System.out.println(i);
            System.out.println("Finish !");
            
        }
    }

    static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            synchronized (counter) {
        		counter.count();
        	}
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        
        MyThread th1 = new MyThread(counter);
        MyThread th2 = new MyThread(counter);
        
        th1.start();
        th2.start();
        
        try {
        th1.join();
        th2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Done !");
    }
}
