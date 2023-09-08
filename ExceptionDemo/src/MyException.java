public class MyException extends Exception{
    int num;
    MyException(int num){
        this.num=num;
    }
    public String toString(){
        return "My Exception ["+ num +"]";
    }
}
