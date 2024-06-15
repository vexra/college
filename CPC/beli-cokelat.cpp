/* Beli Cokelat
 * Source Soal : https://tlx.toki.id/courses/competitive/chapters/06/problems/D
 * Source Jawaban : https://tlx.toki.id/submissions/1138959
 */

#include <iostream>
#include <cmath>
#include <algorithm>

struct test {
    long long H;
    long long B;
};

bool cmp (test a, test b)
{
    if (a.H < b.H) return true;
    return false;
}

using namespace std;

int main()
{
    int n;
    long long d, cnt = 0, tmp;
    cin >> n >> d;
    
    test arr[n];

    for (int i = 0; i < n; ++i) {
        cin >> arr[i].H >> arr[i].B;
    }

    sort(arr, arr+n, cmp);

    for (int i = 0; i < n; ++i) {
        tmp = min(arr[i].B, d/arr[i].H);
        d -= tmp * arr[i].H;
        cnt += tmp;
    }
    
    cout << cnt << endl;
    
    return 0;
}
