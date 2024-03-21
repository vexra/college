/* 2217051004
 *
 */

#include <iostream>

#define minimum(x,y) x < y ? x : y;
#define maximum(x,y) x > y ? x : y;

long long rekursif(long long digitAkhir, long long digit9) {
    if (digit9 == 0) 
        return 0;
    
    else if (digit9 == 1) 
        return digitAkhir;

    return digitAkhir * rekursif(digitAkhir, digit9 - 1);
}

using namespace std;

int main()
{
    int a =  minimum(10, 11);
    int b = maximum(10,11);
    long long c = rekursif(4, 0);

    const char *str = "04";
    int ff = 66;
    int * p_ff = &ff;

    cout << a << endl; // output 10
    cout << b << endl;  // output 11
    cout << c << endl; // output 4 kali 4 sebanyak 0 kali

    cout << str << endl; // output 04 isi dari pointer
    cout << &str << endl; // output alamat dari data

    cout << ff << endl;
    cout << p_ff << endl;
    cout << *p_ff << endl;
    cout << &ff << endl;
    cout << &p_ff << endl;

}