package com.anilstack.ds.stacks;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ApplyDiscountToPrices {

    //prices update with two decimal points discount 50%
    public static void main(String[] args) {
        String s = "there are $1 $2 and 5$ candies in the shop";
        System.out.println(ApplyDiscountToPrices.discountPrices(s,50));
    }

    private static String discountPrices(String sentence, int discount) {

        String[] strList = sentence.split(" ");
        String ans = "";
        for (String s : strList) {
            if (isValid(s)) {

                Long val = Long.parseLong(s.substring(1));
                //S.P = C.P * (1-DISCOUNT/100)
                ans += ("$" + String.format("%.2f", val * (1 - discount / 100.0d)));
            } else {
                ans += s;
            }
            ans += " ";
        }

        return ans.substring(0, ans.length() - 1);
    }

    //$25,          valid cases
    // $123Anil, $  invalid cases
    private static boolean isValid(String s) {

        if (s.length() < 2) {
            return false;
        }

        if (s.charAt(0) != '$') {
            return false;
        }

        for (int i = 1; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
