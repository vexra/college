#include <iostream>
using namespace std;

int main()
{
    char value;
    cin >> value;
    
    switch(value) {
        case 'A':
            cout << "Nilai kamu 100";
            break;
        case 'B':
            cout << "Nilai kamu 76 - 99";
            break;
        case 'C':
            cout << "Nilai kamu dibawah 76 :(";
            break;
        default:
            cout << "Nilai Invalid";
    }
}