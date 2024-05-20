
// C program to demonstrate working of wait()
#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>

int main()
{
  int pid = fork();
  if (pid == 0)
    printf("CHILD: hello from child\n");
  else
  {
    printf("PARENT: hello from parent\n");
    wait(NULL);
    printf("PARENT: child has terminated\n");
  }

  if (pid == 0)
  {
    printf("CHILD:Bye\n");
  }
  else
  {
    printf("PARENT:Bye\n");
  }
  return 0;
}