#include <stdio.h>
#include "avg.h"
int main(int argc, char* argv[]) {
double v1, v2,v3, m;
v1 = 5.2;
v2 = 7.9;
v3=3.4;
m = mean(v1, v2, v3);
printf("The mean of %3.2f, %3.2f and %3.2f is %3.2f\n", v1, v2,v3, m);
return 0;
}