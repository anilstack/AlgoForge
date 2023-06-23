package com.anilstack.ds.stacks;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class NextGreaterElementIII {
//given a number you need to generate a next smallest number(next higher number).
//1245 given number we need to generate 1254.
//12451 given number we need to generate 12514.
//carefully obeserve 451 there is a increasing path 1-->5 and decreasing path 5--->4.
//we need find immediate higher number we need to do some operation in immediate higher number.
//125431 given number 5431 this is a increasing path
//swap with next higher number in this case 2 and 3
public static void main(String[] args) {
        int n = 125431; //125413 , 135421(correct)
        System.out.println(NextGreaterElementIII.findNextHigherElementTest(n));
    }

    private static int findNextHigherElementTest(int n) {

        char[] ch = (n+"").toCharArray();

        int deflectionPoint = ch.length-1;

        while (deflectionPoint > 0) {
            if (ch[deflectionPoint] > ch[deflectionPoint-1]) {
                break;
            }
            deflectionPoint--;
        }

        if (deflectionPoint==0) return -1;

        int firstSwapIndex = deflectionPoint-1;
        int secondSwapIndex = ch.length-1;

        while (secondSwapIndex >= firstSwapIndex) {
            if (ch[firstSwapIndex] < ch[secondSwapIndex]) {
                break;
            }
            secondSwapIndex--;
        }

        //swap first deflection point
        char temp = ch[firstSwapIndex];
        ch[firstSwapIndex] = ch[secondSwapIndex];
        ch[secondSwapIndex] = temp;

        //swapping whole deflection numbers.
        reverseCharTest(ch,deflectionPoint);

        Long parseLong = Long.parseLong(new String(ch));
        if (parseLong <= Integer.MAX_VALUE) {
             return (int) parseLong.intValue();
        } else {
            return 0;
        }
    }


    private static void reverseCharTest(char[] ch, int deflectionPoint) {
        int start = deflectionPoint;
        int end = ch.length-1;
        while (end >= start) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[start] = temp;
            end--;
            start++;
        }
    }
    private static void reverseChar(char[] s, int deflectionPoint) {
        int start = deflectionPoint;
        int end = s.length-1;
        while (end>=start) {
            char temp = s[start];
            s[start] = s[end];
            s[start] = temp;
            end--;
            start++;
        }
    }

    private static int findNextHigherElement(int n) {

        char[] num = (n+"").toCharArray();
        int len = num.length;
        //lets findout first swapping index which is decreasing path in given number from last.

        int deflectionPoint = num.length-1;

        while (deflectionPoint>=0) {
            int defvalue = num[deflectionPoint];
            if (num[deflectionPoint] > num[deflectionPoint - 1]) {
                break;
            }
            deflectionPoint--;
        }
            if (deflectionPoint == 0) {
                return -1;
            }

            int firstSwappingIndex = deflectionPoint - 1;
            int secondSwappingIndex = num.length-1;

            while (secondSwappingIndex >= firstSwappingIndex) {
                if (num[firstSwappingIndex] < num[secondSwappingIndex]) {
                    break;
                }
                secondSwappingIndex--;
            }

            //swap
            char temp = num[firstSwappingIndex];
            num[firstSwappingIndex] = num[secondSwappingIndex];
            num[secondSwappingIndex] = temp;

            // swapping at the point of deflection
            reverseChar(num,deflectionPoint);
            long result = Long.parseLong(new String(num));
            if (result <= Integer.MAX_VALUE) {
                return (int) result;
            } else {
                return -1;
            }
    }

}
