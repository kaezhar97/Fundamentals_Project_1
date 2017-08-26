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
      do {
         //****************************************************
         // PUT CODE HERE
         // Append remainder to result
         // Divide by 2
         //****************************************************
      }
      while (value != 0);

      return result;
   }

   private boolean inSignedRange(int value, int numbits) {
      //************************************************************
      // PUT CODE HERE

      // Return true if the passed value can be represented in the specified number of bits
      // for Two's complement
      //************************************************************
      return true;
   }

   // Two's Complement
   public String toSigned(int value, int numbits) {
      // Check if no overflow
      if (!inSignedRange(value, numbits))
         return "OVERFLOW";
      else {
         // Normally, we flip the bits and add one
         // But binary addition is a bit difficult to program.
         // Suggest, subtract one from value and then flip the bits.

         //*************************************************************
         // PUT CODE HERE
         // 
         // If the value is negative, convert it to the positive value
         // you want to convert before flipping
         //*************************************************************
         String result = zeroPadFront(toUnsigned(value), numbits);

         //*************************************************************
         // PUT CODE HERE
         //
         // If the value was negative, flip the bits
         //*************************************************************
         return result;
      }
   }

   // Floating Point
   public String toFloat(float value) {
      // Helpful variables
      String sign, mantissa, exponent;

      //*****************************************************
      // PUT CODE HERE
      // 
      // Set sign bit to "0" or "1" based on value
      //*****************************************************
      
      // Use toUnsigned() to get integer portion
      String integerPortion = toUnsigned((int) value);
      value -= (int) value;

      float sum = 0;
      int power = -1;
      String decimalPortion = "";

      while (sum < value && (integerPortion.length()-1)+decimalPortion.length() <= 23) {
         //************************************************************************************
         // PUT CODE HERE
         //
         // Compute decimal portion of fixed-point
         // Determine hypothetical sum, if not greater than value append '1' and update sum
         // Otherwise append '0'
         // Be sure to decrement your power each time
         //**********************************************************************************
      }

      //*************************************************************************************
      // PUT CODE HERE
      // 
      // Compute mantissa.  Everything after the first '1' in the concatenated integer and decimal portions.
      // Be sure to zero-pad
      //************************************************************************************* 
     
      //*************************************************************************************
      // PUT CODE HERE
      //
      // Compute exponent.  Use the integer portion unless that part is zero,
      // Then look at the decimal portion.
      // In either case, you want to find the position of the first '1'.
      // Then be sure to bias and zero-pad.
      //*************************************************************************************

      return "";//sign + " " + mantissa + " " + exponent;
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