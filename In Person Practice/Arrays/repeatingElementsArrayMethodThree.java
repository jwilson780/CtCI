//Method 3 : Repeating Array Elements -- Math for the win
//Let the numbers which are being repeated are X and Y. We make two equations for X and Y and the simple task left is to solve the two equations.
//We know the sum of integers from 1 to n is n(n+1)/2 and product is n!. We calculate the sum of input array, when this sum is subtracted from n(n+1)/2, we get X + Y because X and Y are the two numbers missing from set [1..n]. Similarly calculate product of input array, when this product is divided from n!, we get X*Y. Given sum and product of X and Y, we can find easily out X and Y.
/*
Let summation of all numbers in array be S and product be P

X + Y = S – n(n+1)/2
XY = P/n!

Using above two equations, we can find out X and Y. For array = 4 2 4 5 2 3 1, we get S = 21 and P as 960.

X + Y = 21 – 15 = 6

XY = 960/5! = 8

X – Y = sqrt((X+Y)^2 – 4*XY) = sqrt(4) = 2

Using below two equations, we easily get X = (6 + 2)/2 and Y = (6-2)/2
X + Y = 6
X – Y = 2
*/

class RepeatElement
{
    void printRepeating(int arr[], int size) 
    {
        /* S is for sum of elements in arr[] */
        int S = 0;
         
        /* P is for product of elements in arr[] */
        int P = 1;
         
        /* x and y are two repeating elements */
        int x, y;
         
        /* D is for difference of x and y, i.e., x-y*/
        int D;
         
        int n = size - 2, i;
 
        /* Calculate Sum and Product of all elements in arr[] */
        for (i = 0; i < size; i++) 
        {
            S = S + arr[i];
            P = P * arr[i];
        }
 
        /* S is x + y now */
        S = S - n * (n + 1) / 2;
         
        /* P is x*y now */
        P = P / fact(n);
        
        /* D is x - y now */
        D = (int) Math.sqrt(S * S - 4 * P);
         
 
        x = (D + S) / 2;
        y = (S - D) / 2;
 
        System.out.println("The two repeating elements are :");
        System.out.print(x + " " + y);
    }
 
    int fact(int n) 
    {
        return (n == 0) ? 1 : n * fact(n - 1);
    }
 
    public static void main(String[] args) {
        RepeatElement repeat = new RepeatElement();
        int arr[] = {4, 2, 4, 5, 2, 3, 1};
        int arr_size = arr.length;
        repeat.printRepeating(arr, arr_size);
    }
}
