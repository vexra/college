/* Pasar Rakyat
 * Source Soal : https://tlx.toki.id/problems/osn-2010/2E/
 * Source Jawaban : https://tlx.toki.id/submissions/909934
 */

#include <stdio.h>
#include <numeric>
#include <algorithm>

int main()
{
	unsigned N, VAL, tmp = 1;
	scanf("%d", &N);

	while(N--) {
		scanf("%d", &VAL);
		tmp = tmp*VAL / std::__gcd(tmp, VAL);
	}

	printf("%d\n", tmp);

	return 0;
}
