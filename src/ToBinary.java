import java.util.Stack;

class ToBinary {
   // Constructor
   public ToBinary() {}
 
   // Helper Function
   private String flipBits(String bits) {
      String result = "";
      for (int i = 0; i < bits.length(); i++)
         if (bits.charAt(i) == '0') result += '1';
         else result += '0';
      return result;
   }

   // Helper Function
   private String zeroPadFront(String s, int n) {
      String result = s;
      for (int i = s.length(); i < n; i++)
         result = "0" + result;
      return result;
   }

   // Helper Function
   private String zeroPadRear(String s, int n) {
      String result = s;
      for (int i = s.length(); i < n; i++)
         result += "0";
      return result;
   }

   // Unsigned
   public String toUnsigned(int value) {
      String result = "";
      int count = 0;
      Stack<Integer> values = new Stack<>();
      do {
         int reminder = value % 2;
         value = value / 2;
         count++;
         values.push(reminder);
      } 
      while (value != 0);
      
      while(!values.isEmpty()){
          result += Integer.toString(values.pop());
      }

      return result;
   }

   private boolean inSignedRange(int value, int numbits) {
      //************************************************************
      // PUT CODE HERE
      int minBits = this.toUnsigned(Math.abs(value)).length()+1; /** The minimum number of bits required to represent a signed number 
                                                           is the minimum number of bits required to represent its unsigned 
                                                           version plus one bit for the sign. For example:
                                                           For a value of 15, the minimum number of bits necessary to represent it
                                                           in unsigned binary is 4. Therefore, we need one more bit for the signed version.
                                                           Thus, 5 bits are the minimum required for its signed version.*/
      
      if (numbits < minBits)
      {
          return false;
      }
      
      else 
      {
          return true;
      }
      // Return true if the passed value can be represented in the specified number of bits
      // for Two's complement
      //************************************************************
      
   }

   // Two's Complement
   public String toSigned(int value, int numbits) {
      // Check if no overflow
      if (!inSignedRange(value, numbits))
         return "OVERFLOW";
      else {
          boolean isNeg = false;    /* Stores whether or not the value is a 
                                       negative number. */
          
          //Checks if the value is a negative number
          if (value < 0)
          {
              value = value + 1;           //If yes, add 1 to the value and
              value = Math.abs(value);     //make the value positive
              isNeg = true;                 //The value is a negative number.
          }
        
         //Stores the unflipped signed binary version
         String result = zeroPadFront(toUnsigned(value), numbits);
         
         // Checks if the value was negative
         if (isNeg)
         {
             result = flipBits(result); // if it was, the bits are flipped
         }

         return result;     //Returns the Signed Binary 
      }
   }

   // Floating Point
   public String toFloat(float value) {
      // Helpful variables
      String sign, mantissa, exponent;
      
      // Checks if the value is positive or negative
      if (value >= 0)
      {
          //if positive, the sign becomes a "0"
          sign = "0";
      }
      
      //If negative, the sign becomes a "1" and value becomes positive
      else
      {
          sign = "1";
          value = Math.abs(value);
      }

      
      // Stores binary before the decimal point
      String integerPortion = toUnsigned((int) value);
      value -= (int) value; //turns the double to just a decimal value

      float sum = 0;        //The hypothetical sum
      int power = -1;       //The current power of the decimal value
      String decimalPortion = "";   //Stores binary after the decimal point

      //Checks if value does not exceed the amount of bits
      while (sum < value && (integerPortion.length()-1)+decimalPortion.length() <= 23) {     
          
          /*If the hypothetical sum is added to the current power after the 
          decimal point, check if it's less than the value*/
          if (sum + Math.pow(2,power) <= value)
          {
              /*If it is, turn the current power's binary to a 1 and add the 
              value to the sum*/
              sum += Math.pow(2, power);
              decimalPortion += "1";
          }
          
          //Otherwise, leave the current power's binary as a 0.
          else
          {
              decimalPortion += "0";
          }
          
          power--; //Decrement the power        
      }

     integerPortion = integerPortion.substring(1); // Delete the first number
     
     //Combine both portions and pad the mantissa to the appropriate bits
     mantissa = integerPortion + decimalPortion;
     mantissa = zeroPadRear(mantissa, 23-mantissa.length());
    
     //Make the exponent value equal to the length of the integer portion
     int exponentValue = integerPortion.length();
     exponentValue += 127; //Add 127 to the exponentValue
     
     //Change the exponent to a binary value
     exponent = toUnsigned(exponentValue);
     
     //Return the toFloat Binary Value 
     return sign + " " + mantissa + " " + exponent;
   }
  
   // Double Precision
   public String toDouble(double value) {
      // Uncomment this line if you do the extra credit
      return "EXTRA CREDIT NOT DONE";

      //**********************************************************
      // PUT EXTRA CREDIT CODE HERE
      //**********************************************************
   }
}
