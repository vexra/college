#include <iostream>
using namespace std;

int main()
{
    int value;
    cin >> value;
    
    if (value % 2 == 0) {
        cout << "Genap";
    } else {
        cout << "Ganjil";
    }
}