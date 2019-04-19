import java.util.logging.Level;
import java.util.logging.Logger;

public class runnable implements Runnable
{
    public void run()
    {
       for(int i=1;i<5;i++)
       {
            System.out.println(Thread.currentThread().getName()+" " + i);
           try {
               Thread.sleep(100);
           } catch (InterruptedException ex) {
               Logger.getLogger(runnable.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
}
    
class Main1
{
    public static void main(String args[])
    {
        Thread th = new Thread(new runnable());
        //th.setName("runnable");
        //th.run();
        Thread th1 = new Thread(new runnable());
        Thread th2 = new Thread(new runnable());
        Thread th3 = new Thread(new runnable());
        Thread th4 = new Thread(new runnable());
        th.start();
        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}

