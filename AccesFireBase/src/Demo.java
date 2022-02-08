public class Demo implements Runnable {

    @Override
    public void run() {
        Firebase ref = new Firebase("https://testjava.firebaseio-demo.com/");
        ref.setValue(new Date().toString(), new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                System.out.println(System.currentTimeMillis() + " Done");
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Demo(), "TestThread");
        t.start();
        System.out.println(System.currentTimeMillis() + " Starting Threads:" + Thread.getAllStackTraces().keySet());
        t.join();
        System.out.println(System.currentTimeMillis() + " Finished Threads:" + Thread.getAllStackTraces().keySet());
        Thread.sleep(10000);
    }
}

