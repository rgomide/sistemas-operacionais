#include <stdio.h>
#include <stdlib.h>

int main() {
  int i, tamanho = 5, *vet;
  
  vet = (int *) malloc(tamanho * sizeof(int));

  for (i = 0; i < tamanho; i++) {
    vet[i] = i + 1;
  }

  for (i = 0; i < tamanho; i++) {
    printf("%d\n", vet[i]);
  }

  free(vet);

  return 0;
}