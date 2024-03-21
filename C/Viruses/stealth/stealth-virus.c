#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <unistd.h>

void stealth() {
    if (fork() == 0) {
        setsid();
        chdir("/");
        umask(0);

        // Menutup file descriptor yang tidak dibutuhkan
        for (int i = sysconf(_SC_OPEN_MAX); i >= 0; i--) {
            close(i);
        }
    }
}

int main() {
    stealth();

    // Code lainnya
    printf("test\n");
    getchar();

    return 0;
}