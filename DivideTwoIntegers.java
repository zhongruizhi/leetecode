class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        //the sign of quotient
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        } else if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        } else {
            long ldividend = Math.abs((long) dividend);
            long ldivisor = Math.abs((long) divisor);
            if (ldividend < ldivisor) {
                return 0;
            } else {
                long remainder = ldividend;
                int quotient = 0;
                while (remainder >= ldivisor) {
                    remainder -= ldivisor;
                    quotient++;
                }
                return sign > 0 ? quotient : -quotient;
            }
        }
    }

    public static void main(String[] args) {
        DivideTwoIntegers dtt = new DivideTwoIntegers();
        System.out.println(dtt.divide(-2147483648, 2));
        
    }
}