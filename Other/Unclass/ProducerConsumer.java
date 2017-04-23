package cn.sjdeng.demo;
 

public class ProducerConsumer {  
    public static void main(String[] args) {  
        SysStack sysStack = new SysStack();  
        Producer producer = new Producer(sysStack);  
        Consume consume = new Consume(sysStack);  
        Thread tp = new Thread(producer);  
        Thread tc = new Thread(consume);  
        tp.start();  
        tc.start();  
    }  
}  
  
class SteamBread{  
    int id;//馒头编号  
    public SteamBread(int id) {  
        this.id = id;  
    }  
    public String toString(){  
        return "steamBread:"+id;  
    }  
}  
  
class SysStack{  
    int index = 0;  
    SteamBread[] stBreads = new SteamBread[6];  
      
    //放入框中，相当于入栈  
    public synchronized void push(SteamBread sb){  
        while(index == stBreads.length){//栈满  
            try{  
                this.wait();//让当前线程等待  
            }catch(InterruptedException e){  
                e.printStackTrace();  
            }  
        }  
        this.notify();//唤醒在此对象监视上等待的单个线程，即消费者线程  
        stBreads[index]=sb;  
        this.index++;  
    }  
    //从框中拿出，相当于出栈  
    public synchronized SteamBread pop(){  
        while(index == 0){//栈空  
            try {  
                this.wait();//阻塞  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
        this.notify();//唤醒  
        this.index--;  
        return stBreads[index];  
    }  
}  
  
class Consume implements Runnable{  
    SysStack sysStack = null;  
    public Consume(SysStack ss){  
        super();  
        this.sysStack = ss;  
    }  
    public void run(){  
        for(int i=0; i<20; i++){//开始消费馒头  
            SteamBread steamBread = sysStack.pop();  
            System.out.println("消费了"+steamBread);  
            try{  
                Thread.sleep(100);  
            }catch(InterruptedException e){  
                e.printStackTrace();  
            }  
        }  
    }  
}  
  
class Producer implements Runnable{  
    SysStack sysStack = null;  
    public Producer(SysStack ss) {  
        this.sysStack = ss;  
    }  
    @Override  
    public void run() {  
        //开始生产馒头  
        for(int i=0;i<20;i++){  
            SteamBread steamBread = new SteamBread(i);  
            sysStack.push(steamBread);  
            System.out.println("生产了"+steamBread);  
            try {  
                Thread.sleep(10);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
    }  
      
}  