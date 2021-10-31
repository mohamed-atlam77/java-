/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mohamed
 */
public class MohamedSamyAtlam {
    
    /**
     * Takes a radius of a circle and returns the area of that circle.
     * @param radius The value of the radius of the circle.
     * @return The area of the circle for a given radius.
     */
    public static float areaOfCircle(float radius){
        return radius*radius*radius;
    }
    
    
    /**
     * Takes a height and width of a rectangle and returns the area of that rectangle.
     * @param height The value of the height of a rectangle.
     * @param width The value of the width of a rectangle.
     * @return The area of the rectangle for the given height and width.
     */
    public static float areaOfRectangle(float height,float width){
        return width * height;
    }
    
    
    /**
     * Takes a side of a cube and returns the lateral area of that cube.
     * @param side The value of the side of the cube.
     * @return The lateral area of the cube for a given side length.
     */
    public static float lateralAreaOfCube(float side){
        return 4*side*side;
    }
    
    
    /**
     * Takes a side of a cube and returns the total surface area of that cube.
     * @param side The value of the side of the cube.
     * @return The total surface area of the cube for a given side length.
     */
    public static float totalSurfaceAreaOfCube(float side){
        return 6*side*side;
    }
    
    
    /**
     * Takes a word or a sentence and returns number of vowels in it.
     * @param str The word or the sentence.
     * @return Number of vowels in it.
     */
    public static String countVowels(String str){
        str=str.toLowerCase();
        int count=0;
        char[] vowels={'a','e','i','o','u'};
        if (str.isEmpty()){
            return "Your sting is empty";
        }
            
        for(int i=0; i<str.length();i++){
            for (char vowel: vowels){
                if(vowel == str.charAt(i)){
                    count+=1;
                }
            }
        }
        return "Number of vowels in " + str + " is " + count ;
    }
    
    
    /**
     * Takes a decimal number and converts the number into octal and i use 
      it as a helper function.
     * @param num The decimal number.
     * @return Octal number in a String type but it adds '0' to the
        beginning  the result.
     */
    public static String result(int num){
        if(num==0)
            return "0";
        else if (num==1)
            return "1";
        return result((int)(num/8)) + num%8 ;
    }
    
    
    /**
     * Takes a decimal integer number and returns an octal number.
     * @param num The decimal number.
     * @return Octal number in a String type.
     */
    public static String decimalToOctal(int num){
        String number= result(num);
        char first_char= number.charAt(0);
        if (number.length()>1 && first_char=='0')
            return number.substring(1);
        return number;
    }
    
    
    /**
     * Takes a decimal floating number and returns an octal number.
     * @param num The decimal number.
     * @param precision Determines the number of digits after the
      floating point in octal number.
     * @return Octal number in a String type.
     */
    public static String decimalToOctal(double num, int precision){
        int i_num=(int)num;      // integer part of the number
        double f_num;         // float part of the number
        if(i_num==0)
            f_num= num;
        else
            f_num= num%i_num;
        
        String i_result= MohamedSamyAtlam.decimalToOctal(i_num);
        
        int temp_num = (int)(f_num * Math.pow(8, precision));
        String f_result = MohamedSamyAtlam.decimalToOctal(temp_num);
        
        return i_result+"."+f_result;
    }
    
    
    /**
     * Takes an octal integer number and returns a decimal number.
     * @param num The octal number.
     * @return decimal number in a String type.
     */
    public static String octalToDecimal(int num){
        String str=Integer.toString(num);
        int str_len= str.length();
        int sum=0;
        for(int i =0; i<str_len;i++ ){
            int digit= (int)(str.charAt(i)-'0');
            if(digit>=8){
                System.out.print("ErrorMessage: \nOctalNumbers can't have "
                        + "a digit or value which is greater than or equal to 8");
                return "";
            }
            sum+=digit*Math.pow(8, (str_len-1)-i);
        }
        
        return Integer.toString(sum);
    }
    
    
    /**
     * Takes an octal floating number and returns a decimal number.
     * @param num The octal number.
     * @return decimal number in a String type.
     */
    public static String octalToDecimal(double num){
        int i_num = (int)num;
        float f_num = (float)(num%i_num);
        int i_sum;
        try{
            i_sum= Integer.valueOf(octalToDecimal(i_num));
        }
        
        catch(NumberFormatException ex){
            /*The NumberFormatException is thrown when we try to convert a 
             string into a numeric value such as float or integer*/
            return "";
        }
        String str = Float.toString(f_num);
        str=str.substring(2);
        int str_len= str.length();
        double f_sum=0.0;
        for(int i =0 ; i < str_len;i++){
            int digit= (int)(str.charAt(i)-'0');
            if(digit>=8){
                System.out.print("ErrorMessage: \nOctalNumbers can't have "
                        + "a digit or value which is greater than or equal to 8");
                return "";
            }
            f_sum+= digit*Math.pow(8, -(i+1));
        }
        return Double.toString(i_sum+f_sum);
    }
    
    
    /**
     * Takes two arrays of integers and returns the addition, subtraction or 
      multiplication of them.
     * @param arr1 Array of integer numbers.
     * @param arr2 Array of integer numbers.
     * @param symbol The operation to do on the arrays: '+' or '-' or '*'.
     * @return Array of integer numbers.
     */
    public static int[][] matrix(int[][] arr1, int[][] arr2, char symbol){
        int[][] empty_arr={{}};
        int rows_arr1 = arr1.length;
        int columns_arr1 = arr1[0].length;
        int columns_arr2 = arr2[0].length;
        switch(symbol){
            case '+':
                try{
                    int[][] arr3 = new int[rows_arr1][columns_arr1];
                    if(arr1.length != arr2.length){
                        System.out.print("ErrorMessage:Incompatible arrays.\n"
                                + "You should use arrays which have the number "
                                + "of rows and columns.\n"
                                + "Try again.");
                            return empty_arr;
                    }
                    for(int i=0; i<arr1.length; i++){
                        if((arr1[i].length!=arr2[i].length)||
                           (i+1<=arr1.length-1 && arr1[i].length != arr1[i+1].length)){    
                            System.out.print("ErrorMessage:Incompatible arrays.\n"
                                + "You should use arrays which have the number "
                                + "of rows and columns.\n"
                                + "Try again.");
                            return empty_arr;
                        }
                        for(int j=0; j<arr1[0].length; j++){
                            arr3[i][j]= arr1[i][j]+arr2[i][j];
                        }
                    }
                    
                    return arr3;
                }
                catch(Exception ex){
                    System.out.print("ErrorMessage:Incompatible arrays.\n"
                                + "You should use arrays which have the number "
                                + "of rows and columns.\n"
                                + "Try again.");
                }
                break;
            case '-':
                try{
                    int[][] arr3 = new int[rows_arr1][columns_arr1];
                    if(arr1.length != arr2.length){
                        System.out.print("ErrorMessage:Incompatible arrays.\n"
                                + "You should use arrays which have the number "
                                + "of rows and columns.\n"
                                + "Try again.");
                            return empty_arr;
                    }
                    for(int i=0; i<arr1.length; i++){
                        if((arr1[i].length!=arr2[i].length)||
                           (i+1<=arr1.length-1 && arr1[i].length != arr1[i+1].length)){    
                            System.out.print("ErrorMessage:Incompatible arrays.\n"
                                + "You should use arrays which have the number "
                                + "of rows and columns.\n"
                                + "Try again.");
                            return empty_arr;
                        }
                        for(int j=0; j<arr1[0].length; j++){
                            arr3[i][j]= arr1[i][j]-arr2[i][j];
                        }
                    }
                    return arr3;
                }
                catch(Exception ex){
                    System.out.print("ErrorMessage:Incompatible arrays.\n"
                            + "You should use arrays which have the number "
                            + "of rows and columns.\n"
                            + "Try again.");
                }
                break;
            case '*':
                try{
                    int[][] arr3 = new int[rows_arr1][columns_arr2];
                    
                    for (int i =0; i< arr1.length ; i++) {
                        if ((arr2.length != arr1[i].length) || 
                            (i+1<=arr1.length-1 && arr1[i].length != arr1[i+1].length)) {
                            System.out.print("ErrorMessage:Incompatible arrays\n"
                                    + "Number of columns in array1 should equal to "
                                    + "number of rows in array2 \n"
                                    + "Try again.");
                            return empty_arr;
                        }
                    }
                    for (int i=0; i<rows_arr1; i++) {
                        for (int j = 0; j<columns_arr2; j++) {
                            for (int k = 0; k<columns_arr1;k++){
                                arr3[i][j] += arr1[i][k] * arr2[k][j];
                            }
                        }
                    }
                    return arr3;
                }
                catch(Exception ex){
                    System.out.print("EXECUTION ERROR");
                }
                break;
            default:{
                System.out.print("You should enter '+', '-' or '*' ");
            }    
        
        }
        return empty_arr;
    }
    
    
    /**
     * Takes two arrays: array of integers and array of floats 
     and returns the addition, subtraction or multiplication of them.
     * @param arr1 Array of integer numbers.
     * @param arr2 Array of float numbers.
     * @param symbol The operation to do on the arrays: '+' or '-' or '*'.
     * @return Array of float numbers.
     */
    public static double[][] matrix(int[][] arr1, double[][] arr2, char symbol){
        double[][] empty_arr={{}};
        int rows_arr1 = arr1.length;
        int columns_arr1 = arr1[0].length;
        int columns_arr2 = arr2[0].length;
        switch(symbol){
            case '+':
                try{
                    double[][] arr3 = new double[rows_arr1][columns_arr1];
                    if(arr1.length != arr2.length){
                        System.out.print("ErrorMessage:Incompatible arrays.\n"
                                + "You should use arrays which have the number "
                                + "of rows and columns.\n"
                                + "Try again.");
                            return empty_arr;
                    }
                    for(int i=0; i<arr1.length; i++){
                        if((arr1[i].length!=arr2[i].length)||
                           (i+1<=arr1.length-1 && arr1[i].length != arr1[i+1].length)){    
                            System.out.print("ErrorMessage:Incompatible arrays.\n"
                                + "You should use arrays which have the number "
                                + "of rows and columns.\n"
                                + "Try again.");
                            return empty_arr;
                        }
                        for(int j=0; j<arr1[0].length; j++){
                            arr3[i][j]= arr1[i][j]+arr2[i][j];
                        }
                    }
                    return arr3;
                }
                catch(Exception ex){
                    System.out.print("ErrorMessage:Incompatible arrays.\n"
                            + "You should use arrays which have the number "
                            + "of rows and columns.\n"
                            + "Try again.");
                }
                break;
            case '-':
                try{
                    double[][] arr3 = new double[rows_arr1][columns_arr1];
                    if(arr1.length != arr2.length){
                        System.out.print("ErrorMessage:Incompatible arrays.\n"
                                + "You should use arrays which have the number "
                                + "of rows and columns.\n"
                                + "Try again.");
                            return empty_arr;
                    }
                    for(int i=0; i<arr1.length; i++){
                        if((arr1[i].length!=arr2[i].length)||
                           (i+1<=arr1.length-1 && arr1[i].length != arr1[i+1].length)){    
                            System.out.print("ErrorMessage:Incompatible arrays.\n"
                                + "You should use arrays which have the number "
                                + "of rows and columns.\n"
                                + "Try again.");
                            return empty_arr;
                        }
                        for(int j=0; j<arr1[0].length; j++){
                            arr3[i][j]= arr1[i][j]-arr2[i][j];
                        }
                    }
                    return arr3;
                }
                catch(Exception ex){
                    System.out.print("ErrorMessage:Incompatible arrays.\n"
                            + "You should use arrays which have the number "
                            + "of rows and columns.\n"
                            + "Try again.");
                }
                break;
            case '*':
                try{
                    double[][] arr3 = new double[rows_arr1][columns_arr2];

                    for (int i =0; i< arr1.length ; i++) {
                        if ((arr2.length != arr1[i].length) || 
                            (i+1<=arr1.length-1 && arr1[i].length != arr1[i+1].length)) {
                            System.out.print("ErrorMessage:Incompatible arrays\n"
                                    + "Number of columns in array1 should equal to "
                                    + "number of rows in array2 \n"
                                    + "Try again.");
                            return empty_arr;
                        }
                    }
                    for (int i=0; i<rows_arr1; i++) {
                        for (int j = 0; j<columns_arr2; j++) {
                            for (int k = 0; k<columns_arr1;k++){
                                arr3[i][j] += arr1[i][k] * arr2[k][j];
                            }
                        }
                    }
                    return arr3;
                }
                catch(Exception ex){
                    System.out.print("EXECUTION ERROR");
                }
                break;
            default:{
                System.out.print("You should enter '+', '-' or '*' ");
            }

        }
        return empty_arr;
    }
    
    
    /**
     * Takes two arrays of floats and returns the addition, subtraction or 
      multiplication of them.
     * @param arr1 Array of float numbers.
     * @param arr2 Array of float numbers.
     * @param symbol The operation to do on the arrays: '+' or '-' or '*'.
     * @return Array of float numbers.
     */
    public static double[][] matrix(double[][] arr1, double[][] arr2, char symbol){
        double[][] empty_arr={{}};
        int rows_arr1 = arr1.length;
        int columns_arr1 = arr1[0].length;
        int columns_arr2 = arr2[0].length;
        switch(symbol){
            case '+':
                try{
                    double[][] arr3 = new double[rows_arr1][columns_arr1];
                    if(arr1.length != arr2.length){
                        System.out.print("ErrorMessage:Incompatible arrays.\n"
                                + "You should use arrays which have the number "
                                + "of rows and columns.\n"
                                + "Try again.");
                            return empty_arr;
                    }
                    for(int i=0; i<arr1.length; i++){
                        if((arr1[i].length!=arr2[i].length)||
                           (i+1<=arr1.length-1 && arr1[i].length != arr1[i+1].length)){    
                            System.out.print("ErrorMessage:Incompatible arrays.\n"
                                + "You should use arrays which have the number "
                                + "of rows and columns.\n"
                                + "Try again.");
                            return empty_arr;
                        }
                        for(int j=0; j<arr1[0].length; j++){
                            arr3[i][j]= arr1[i][j]+arr2[i][j];
                        }
                    }
                    return arr3;
                }
                catch(Exception ex){
                    System.out.print("ErrorMessage:Incompatible arrays.\n"
                            + "You should use arrays which have the number "
                            + "of rows and columns.\n"
                            + "Try again.");
                }
                break;
            case '-':
                try{
                    double[][] arr3 = new double[rows_arr1][columns_arr1];
                    if(arr1.length != arr2.length){
                        System.out.print("ErrorMessage:Incompatible arrays.\n"
                                + "You should use arrays which have the number "
                                + "of rows and columns.\n"
                                + "Try again.");
                            return empty_arr;
                    }
                    for(int i=0; i<arr1.length; i++){
                        if((arr1[i].length!=arr2[i].length)||
                           (i+1<=arr1.length-1 && arr1[i].length != arr1[i+1].length)){    
                            System.out.print("ErrorMessage:Incompatible arrays.\n"
                                + "You should use arrays which have the number "
                                + "of rows and columns.\n"
                                + "Try again.");
                            return empty_arr;
                        }
                        for(int j=0; j<arr1[0].length; j++){
                            arr3[i][j]= arr1[i][j]-arr2[i][j];
                        }
                    }
                    return arr3;
                }
                catch(Exception ex){
                    System.out.print("ErrorMessage:Incompatible arrays.\n"
                            + "You should use arrays which have the number "
                            + "of rows and columns.\n"
                            + "Try again.");
                }
                break;
            case '*':
                try{
                    double[][] arr3 = new double[rows_arr1][columns_arr2];

                    for (int i =0; i< arr1.length ; i++) {
                        if ((arr2.length != arr1[i].length) || 
                            (i+1<=arr1.length-1 && arr1[i].length != arr1[i+1].length)) {
                            System.out.print("ErrorMessage:Incompatible arrays\n"
                                    + "Number of columns in array1 should equal to "
                                    + "number of rows in array2 \n"
                                    + "Try again.");
                            return empty_arr;
                        }
                    }
                    for (int i=0; i<rows_arr1; i++) {
                        for (int j = 0; j<columns_arr2; j++) {
                            for (int k = 0; k<columns_arr1;k++){
                                arr3[i][j] += arr1[i][k] * arr2[k][j];
                            }
                        }
                    }
                    return arr3;
                }
                catch(Exception ex){
                    System.out.print("EXECUTION ERROR");
                }
                break;
            default:{
                System.out.print("You should enter '+', '-' or '*' ");
            }

        }
        return empty_arr;
    }
    
    public static void main(String[] args){
        
        /* This Calculator can calculate:
            - Area of a circle.
            - Area of a rectangle.
            - Lateral & Surface area of a cube. 
            - Count vowels in a string.
            - Convert decimal number to octal and vice-versa and you can 
              enter integer or float number but if you enter a float number
              you should determine the digits you need to see after the 
              floating point(precision).
            - You can add, subtract, multiply two matrices but if you need 
              to print the result you should loop over the array or the
              matrix.
        */
        
        
        /*
            Note that: when you convert decimal Number to octal or 
            vice-versa, the type of the result will be String. So, if 
            you need to use the result in arethmatic operations, you
            need to convert the result into Integer or Double types.
        */
        
        
        
    }
    
   
    
}
