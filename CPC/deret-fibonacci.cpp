/* Deret Fibonacci
 * Source Soal : https://tlx.toki.id/problems/osn-2010/0B/
 * Source Jawaban : https://tlx.toki.id/submissions/213304
 */

#include <iostream>
using namespace std;

const long long P=1000000000000000;
int i;
long long N[2], C[2] = {5, 0}, B[2] = {3, 0};
char S;

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0);  cout.tie(0);
	
	while (cin >> S) {
		N[0] = 10 * N[0] + S - '0';
		N[1] = N[1] * 10 + N[0] / P;
		N[0] = N[0] % P;
	}

	for (i = 6; C[1] < N[1] || (C[1] == N[1] && C[0] <= N[0]); i++) {
		if ((C[1] == N[1] && C[0] == N[0])) {
			cout << i << '\n';
			return 0;
		}

		B[0] += C[0];
		B[1] += C[1] + B[0] / P;
		B[0] = B[0] % P;
		swap(B[0], C[0]);
		swap(B[1], C[1]);
	}

	cout << 0 << '\n';

	return 0;
}
