#include <iostream>
#include <cstdlib>

using namespace std;

int main() {
    int a;

    while (true) {
        cin >> a;

        if (a % 2 == 0) {
            cout << "genap" << endl;
        } else {
            break;
        }
    }
}