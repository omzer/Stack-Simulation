
package dataproject;
/*
هاي أرري ليست من تصميمي إستخدمتها بالبرنامج
*/
public class AL <E>{
E arr [] = (E[])new Object [3];
int size =0;
    private void cap (){
    if (arr.length==size){
    E[] arrTemp =  (E[]) new Object [size*2];
    for(int i=0;i<size;i++)
        arrTemp[i]=arr[i];
    arr=arrTemp;
    }
    }
    public E get (int index){if(size==0)return null;return arr[index];}
    public void add (E ob){
    cap();
   arr[size]=ob;
   size++;
    }
    public void add (E ob ,int ind){
       cap();
    if(ind>size){System.out.println("Enter valid index");return;}
   if(ind==size){add(ob);return ;}   
   for(int i=size;i>=ind;i--)
       arr[i+1]=arr[i];
   arr[ind]=ob;
size++;
   }
    public String toTxt (){String a ="";
    a="[ ";
    for(int i=0;i<size;i++)
        a+=arr[i] + " , ";
    a=a.substring(0,a.length()-2);
    a+="]";
    return a ;}
    public void remove (int ind){
        cap();
        if(ind >=size){System.out.println("Enter valid index");return ;}
        for(int i=ind;i<size;i++)
            arr[i]=arr[i+1];
        size--;
      
    }
}
