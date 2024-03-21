#include <fstream>
#include <string>
#include <iostream>
using namespace std;

int main()
{
	string text[4];
	
	for (int i = 0; i < 4; ++i){
		cin >> text[i];
	}
	
	ofstream outFile("data.txt");
	
	for (int i = 0; i < 4; ++i){
		outFile << text[i] << endl;
	}
	
	return 0;
}
