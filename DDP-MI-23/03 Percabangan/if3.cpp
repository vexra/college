#include <iostream>
using namespace std;

int main()
{
    int value;
    cin >> value;
    
    if (value >= 0 && value <= 9) {
        cout << "Satuan";
    } else if (value >= 10 && value <= 99) {
        cout << "Puluhan";
    } else if (value >= 100 && value <= 999) {
        cout << "Ratusan";
    } else {
        cout << "Tidak Tahu";
    }
}