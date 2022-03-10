public class DArray {
    double array[] = new double[10];
    int capacity = 10;
    int length = 0;

    public void append(double value){
        array[length] = value;
        length++;
        if(length >= capacity){
            capacity*=2;
            double newarray[] = new double[capacity*2];
            for(int i = 0; i < length; i++){
                newarray[i] = array[i];
            }
            array = newarray;
        }
    }
    public double getindex(int i){
        return array[i];
    }
    public void printall(){
        for(int i = 0; i < length; i++){
            System.out.println(array[i]);
        }
    }
    public double sum(){
        double sum = 0.0;
        for(int i = 0; i < length; i++){
            sum += array[i];
        }
        return sum;
    }
    public void clear(){
        array = new double[10];
        length = 0;
        capacity = 10;
    }
}