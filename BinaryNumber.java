// zening fang
import java.util.Arrays;

public class BinaryNumber{
    // define the array field
    private int data[];
    // define the field
    private boolean overflow = false;
    //create a binary number  of length consisting all zeros
    public BinaryNumber(int length){
        data = new int[length];
        for(int i = 0; i < length; i++){
            data[i] = 0;
        }
    }
    //Create a binary number given a string
    public BinaryNumber(String str){
        data = new int[str.length()];
        for(int i = 0; i < str.length(); i++){
            data[i] = java.lang.Character.getNumericValue(str.charAt(i));
        }
    }
    //give the length of a binary number
    public int getLength(){
        return data.length;
    }
    //give a digit of a binary number given an index
    public int getDigit(int index){
        if((index <= this.data.length -1) && (index >= 0)){
            return data[index];
        }
        else{
            throw new IndexOutOfBoundsException("the index is out of bounds");
        }
    }
    //Transform a binary number to its decimal notation
    public int toDecimal(){
        int result = 0;
        for(int i = 0; i < data.length; i++){
            result = (int) (result + data[i] * Math.pow(2, i));
        }
        return result;
    }
    //Transform a binary number to a String. return overflow if it happens
    public String toString(){
        if(overflow){
            return "overflow";
        }
        else{
            String s = "";
            for(int i = 0; i < data.length; i++){
                s = s + Integer.toString(data[i]);
            }
            return s;
        }
    }
    // Shift all digits in a binary number the place to the right
    public void shitfR(int amount){
        int[] newArray = Arrays.copyOf(data, data.length + amount);
        for(int i = data.length - 1; i >= 0; i--){
            newArray[i + amount] = newArray[i];
        }
        for(int i = 0; i < amount; i++){
            newArray[i] =0;
        }
    }
    // add two binary number with the same length.
    public void add(BinaryNumber aBinaryNumber){
        int carryDigit = 0;
        if(data.length != aBinaryNumber.data.length) {
			System.out.println("The length of two binary numbers is not equal.");
		}
        else{
            for(int i=0; i<data.length; i++){
                int sum = data[i] + aBinaryNumber.data[i] + carryDigit;
                if(sum == 0){
                    data[i] = sum + carryDigit;
                    carryDigit = 0;
                    overflow = false;
                }
                else if(sum == 1){
                    data[i] = sum;
                    carryDigit = 0;
                    overflow = false;
                }
                else if(sum == 2){
                    data[i] = 0;
                    carryDigit = 1;
                    overflow = true;
                }
                else if(sum == 3){
                    data[i] = 1;
                    carryDigit = 1;
                    overflow = true;
                }
            }
        }
    }
    //Clear the overflow flag
    public void clearOverflow() {
		overflow = false;
	}
    
}