
package dataproject;



public class Istack <E>{
    AL<E> arr = new AL<>();
    public int getSize (){return arr.size;}
    public void push(E number){arr.add(number);}
    public E pop(){
        if (arr.size==0)
            return arr.get(0);
        E x =arr.get(arr.size-1);
    arr.remove(arr.size-1);
    return x;}
    public E peek (){return arr.get(arr.size-1);}
    public String toString(){if(arr.size==0)return "[ ]";return arr.toTxt();}
}
