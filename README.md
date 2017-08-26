Florida International University
CDA3103: Fundamentals of Computer Systems
Interactive Project 1: Data Representation

For the first IP you will complete a Java class that can take an integer (signed or unsigned) or single-precision floating point value and convert it to its binary equivalent (as a Java String).  For extra credit you can also incorporate double-precision values.  
These types of converters do exist, but building one yourself will help train your mind in learning how to perform these conversions algorithmically.  Later in the class and as you progress in the curriculum, we will need to build hardware for arithmetic.  So it is good to understand the logical steps involved.
I have provided on Moodle two files.  Convert2Binary.java is a main() function that I have written (you should not modify this file), which asks the user the type of conversion they would like to perform (unsigned, signed, or floating point) and accepts the value to convert.  It then will call the appropriate function from a class ToBinary, which you will modify.  Your modifications should be restricted to areas within the blocks marked PUT CODE HERE.
I have written a few helper functions in ToBinary that you can call:
1. private String flipBits(String bits): return bits with ‘0‘s changed to ‘1‘s and ‘1‘s changed to ‘0‘s
2. private String zeroPadFront(String bits, int n): return bits, padded with enough ‘0‘s in front such that it becomes length n
3. private String zeroPadRear(String bits, int n): return bits, padded with enough ‘0‘s at the back such that it becomes length n

You will complete the following functions:
1. public String toUnsigned(int value): convert value to a binary non-negative integer (arbitrary length)
2. public String toSigned(int value, int numbits): convert value to a Two’s Complement integer with the specified number of bits
3. public String toFloat(float value): convert value to a 32-bit IEEE floating point value (1 bit sign, 23 bit mantissa and 8 bit exponent).
4. (For extra credit, 10 points) public String toDouble(double value): convert value to a 64-bit IEEE double-precision value (1 bit sign, 52 bit mantissa and 11 bit exponent).

You may use online Java documentation (i.e. JavaDoc) for help with programming-based tasks (i.e. String parsing), but please do not use any pre-built binary converters.  The purpose of this project is for you to become very familiar with how these conversions work and how to do them on your own (vital for the course). 

Your group will submit one copy of ToBinary.java on Moodle by the end of class on Tuesday 9/5 (we will have some time after the mini-exam to make final changes).
