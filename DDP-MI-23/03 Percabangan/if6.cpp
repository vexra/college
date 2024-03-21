#include <iostream>
using namespace std;

int main()
{
    int value;
    cin >> value;
    
    if (value >= 0) {
        if (value % 2 == 0) {
            cout << "Positif Genap";
        } else {
            cout << "Positif Ganjil";
        }
        
    } else {
        cout << "Negatif";
    }
}