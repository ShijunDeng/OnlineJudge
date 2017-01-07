#include <stdlib.h>
#include <stdio.h>
#define PRINT_COMPARE_RESULT(a, b) \
    if (a > b) { \
        printf( #a " > " #b "\n"); \
    } \
    else if (a < b) { \
        printf( #a " < " #b "\n"); \
    } \
    else { \
        printf( #a " = " #b "\n" ); \
    }

int main() {
    int a = -1;
    unsigned short b = 2;
    unsigned int c = 2;

    PRINT_COMPARE_RESULT(a,b);
    PRINT_COMPARE_RESULT(a,c);

    return 0;
}
