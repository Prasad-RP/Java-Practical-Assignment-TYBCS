import java.util.*;
class Sum_Thread implements Runnable{
Thread t;
int a[] = new int[100];
int no,sum;

Sum_Thread(String s,int n){
Random r = new Random();
t=new Thread(this,s);
int j=0;
no=n;
for(int i=0;i<100;i++)
{
a[i]=r.nextInt(100);
j++;
}
t.start();

}//Sum_Thread

public void run(){
try{
for(int i=0;i<10;i++){
System.out.print(a[no]+" ");
sum=sum+a[no];
no++;

}
System.out.println("");
System.out.println("SUM: "+sum);
System.out.println("AVG: "+sum/10);
System.out.println("");
}//try
catch(Exception e){ e.printStackTrace();
}

}//run

}

public class SETB1 {

public static void main(String arg[]){
try{
Sum_Thread t1= new Sum_Thread("t1",1);
t1.t.join();

Sum_Thread t2= new Sum_Thread("t2",10);
t2.t.join();

Sum_Thread t3= new Sum_Thread("t3",20);
t3.t.join();

Sum_Thread t4= new Sum_Thread("t4",30);
t4.t.join();

Sum_Thread t5= new Sum_Thread("t5",40);
t5.t.join();

Sum_Thread t6= new Sum_Thread("t6",50);
t6.t.join();

Sum_Thread t7= new Sum_Thread("t7",60);
t7.t.join();

Sum_Thread t8= new Sum_Thread("t8",70);
t8.t.join();

Sum_Thread t9= new Sum_Thread("t9",80);
t9.t.join();

Sum_Thread t10= new Sum_Thread("t10",90);
t10	.t.join();
}//try
catch(Exception e){ e.printStackTrace();
}

}

}
