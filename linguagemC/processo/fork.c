#include <stdio.h>
#include <unistd.h>

/* This program forks and and the prints whether the process is
 *   - the child (the return value of fork() is 0), or
 *   - the parent (the return value of fork() is not zero)
 *
 * When this was run 100 times on the computer the author is
 * on, only twice did the parent process execute before the
 * child process executed.
 *
 * Note, if you juxtapose two strings, the compiler automatically
 * concatenates the two, e.g., "Hello " "world!"
 *
 * REFERENCE: https://ece.uwaterloo.ca/~dwharder/icsrts/Tutorials/fork_exec/
 *
 */

int main(void)
{
  int parentPid = getpid();
  printf("The process identifier (pid) of the parent process is %d\n", parentPid);

  int pid = fork();

  int currentPid = getpid();

  if (pid == 0)
  {
    printf("After the fork, the process identifier (pid) "
           "of the child is %d\n",
           currentPid);
  }
  else
  {
    printf("After the fork, the process identifier (pid) "
           "of the parent is still %d\n - fork() returned %d\n",
           currentPid, pid);
  }

  return 0;
}