/* Seberapa Kuat Password Anda
 * Source Soal : https://tlx.toki.id/problems/ngoding-seru-2015-oct-pemula/H
 * Source Jawaban : https://tlx.toki.id/submissions/1020277
 */

#include <ctype.h>
#include <stdio.h>
#include <string.h>
#pragma optimize("Ofast", on)

bool isStrong (char *p)
{
    if(strlen(p) < 9) return false;
    bool num = false, upper = false, lower = false, unique = false;

    for(int i = 0; p[i]; ++i) {
        if (!unique && (p[i] == '_' || p[i] == '?' || p[i] == '!')) unique = true;
        else if(!num && isdigit(p[i])) num = true;
        else if(isalpha(p[i])) {
            if(!upper && isupper(p[i])) upper = true;
            else lower = true;
        }
    }

    return num && upper && lower && unique;
}

bool middle (char *p)
{
    if(strlen(p) < 13) return false;

    for(int i = 0; p[i]; ++i) {
        if(!isalpha(p[i])) return false;
    }
    
    return true;
}

int main()
{
    char str[21];
    scanf("%s", str);

    if(isStrong(str)) puts("Kuat");
    else if(middle(str)) puts("AgakKuat");
    else puts("Lemah");

    return 0;   
}
