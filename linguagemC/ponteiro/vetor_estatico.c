#include <stdio.h>

int main() {
  int a[5], i;

  for (i = 0; i < 5; i++) {
    a[i] = i + 1;
  }

  for (i = 0; i < 5; i++) {
    printf("%d\n", a[i]);
  }

  return 0;
}