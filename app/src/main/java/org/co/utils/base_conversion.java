package org.co.utils;

/**
 * a static class to help with base conversion
 */
public class base_conversion {
    /**
     * types of base
     */
    public static enum base {
        binary(2), ternary(3), octal(8), decimal(10), hexadecimal(16);
        public final int value;
        private base(int value) {
            this.value = value;
        }
    }

    /**
     * converts input base into output base 
     * @param input value of input
     * @param input_base base of input
     * @param output_base base of output to convert into
     * @return converted output in string
     */
    public static String convert_base(int input, base input_base, base output_base) {
        if (input_base == output_base) {
            return Integer.toString(input);
        } 
        if (input == 0) return "0"; 
        int decimal = convert_to_decimal(input, input_base);
        if (output_base == base.hexadecimal) {
            return decimal_to_hexadecimal(input);
        } else {
            StringBuilder b = new StringBuilder();
            while (decimal > 0) {
                int bit = decimal % output_base.value;
                b.append((char) ('0' + bit));
                decimal /= output_base.value;
            }
            return b.reverse().toString();
        }
    }

    /**
     * converts any base input into decimal
     * @param input input of any base
     * @param input_base base of input
     * @return decimal output converted from input
     */
    public static int convert_to_decimal(int input, base input_base) {
        if (input_base == base.decimal) return input;
        int temp = input;
        int decimal = 0;
        int base = 1;
        while (temp > 0) {
            int remainder = temp % 10;
            decimal += remainder * base;
            base *= input_base.value;
            temp /= 10;
        }
        System.out.println(decimal);
        return decimal; 
    }

    /**
     * converts decimal into hexadecimal
     * @param decimal input decimal
     * @return output hexadecimal
     */
    public static String decimal_to_hexadecimal(int decimal) {
        StringBuilder b = new StringBuilder();
        int temp = decimal;
        while (temp > 0) {
            int remainder = temp % 16;
            if (remainder < 10) {
                b.append((char)(remainder + 48));
            } else {
                b.append((char)(remainder + 55));
            }
            temp /= 16;
        }
        return b.reverse().toString();
    }
}
