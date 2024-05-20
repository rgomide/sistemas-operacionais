
// C program to demonstrate working of wait()
#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>

int main()
{
  int value = 10;

  int pid = fork();
  if (pid == 0)
  {
    printf("\nCHILD:initial value=%d\n", value);
    printf("CHILD: hello from child\n");
    value = 20;
    printf("CHILD:value=%d\n", value);
  }
  else
  {
    printf("PARENT: hello from parent\n");
    wait(NULL);
    printf("PARENT: child has terminated\n");
    printf("PARENT:value=%d\n", value);
  }

  if (pid == 0)
  {
    printf("CHILD:Bye\n\n");
  }
  else
  {
    printf("PARENT:Bye\n");
  }
  return 0;
}