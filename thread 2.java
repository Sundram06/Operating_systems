public class runnable implements Runnable
{
    public void run()
    {
    System.out.println(Thread.currentThread().getName());
    }
}
    
class Main1
{
    public static void main(String args[])
    {
        Thread th = new Thread(new runnable());
        th.setName("runnable");
        th.run();
        th.start();
    }
}

