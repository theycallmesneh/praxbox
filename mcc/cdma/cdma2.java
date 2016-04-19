import java.util.*;
class cdma2{
public static void main(String[] args) {
//input a = 1 1 -1 -1 1 1 -1
//input b = -1 1 1 -1 1 1 -1
Scanner sc=new Scanner(System.in);
System.out.println("Enter the size of the array");
int n=sc.nextInt();
int A[]=new int[n];
int B[]=new int[n];
System.out.println("Enter array A");
for (int i=0;i<n ;i++ ) {
System.out.print("Value "+(i+1)+"= ");
A[i]=sc.nextInt();
}
System.out.println("\nEnter array B");
for (int i=0;i<n ;i++ ) {
System.out.print("Value "+(i+1)+"= ");
B[i]=sc.nextInt();
}
int As[]=new int[n];
int Bs[]=new int[n];
int C[]=new int[n];
for (int i=0;i<n ;i++ ) {
As[i]=1*A[i];
Bs[i]=-1*B[i];
}
for (int i=0;i<n ;i++ ) {
C[i]=As[i]+Bs[i];
}
System.out.println("Array C is: ");
for (int i=0;i<n ;i++ ) {
System.out.print(C[i]+" ");
}
int Ap[]=new int[n];
int Bp[]=new int[n];
int x1=0,x2=0;
for (int i=0;i<n ;i++ ) {
x1=x1+C[i]*A[i];
x2=x2+C[i]*B[i];
}
System.out.println("\nValue of inner product of A is : "+x1);
System.out.println("Value of inner product of B is : "+x2);
}
}
