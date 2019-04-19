public class thread extends Thread
{
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
    }
    
}
class Main
{
    public static void main(String args[])
    {
        thread th = new thread();
        th.setName("thread");
        th.run();
        
    }
}
