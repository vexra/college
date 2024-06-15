/* Jamuan makan
 * Source Soal : https://tlx.toki.id/courses/competitive/chapters/06/problems/B
 * Source Jawaban : https://tlx.toki.id/submissions/1139481
 */

#include <iostream>
#include <algorithm>

bool cmp( std::pair<long long, long long> a, std::pair<long long, long long> b )
{
    if (a.first + a.second < b.first + b.second) return true;
    return false;
}

using namespace std;

int main()
{
    long long n, cnt = 1;
    cin >> n;

    pair<long long, long long> arr[n];


    for (long long i = 0; i < n; ++i) {
        cin >> arr[i].first >> arr[i].second;
    }

    sort(arr, arr+n, cmp);

    for (long long i = 0, j = 1; j < n; ++j) {
        if ((arr[i].second + arr[i].first - 1) < arr[j].first) {
            ++cnt;
            i = j;
        }   
    }

    cout << cnt << endl;
}
