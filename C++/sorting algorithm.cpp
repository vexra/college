// Buat kode program untuk mengimplementasikan algoritma Sorting: Bubble Sort, Selection Sort, Merge Sort dan Quick Sort. Lalu lengkapi data pada tabel berikut.

#include <iostream>
using namespace std;

//Function Declaration
void BubbleSort(int *arr, int size);
void SelectionSort(int *arr, int size);
void MergeSort(int *arr, int left, int right);
void Merge(int *arr, int aLeft, int aRight, int bLeft, int bRight);
void QuickSort(int *arr, int left, int right);

//Bubble Sort
void BubbleSort(int *arr, int size) {
    for (int i = 0; i < size - 1; ++i) {
        for (int j = 0; j < size - i - 1; ++j) {
            if (arr[j] > arr[j+1]) {
                swap(arr[j], arr[j+1]);
            }
        }
    }
}

//Selection Sort
void SelectionSort(int *arr, int size) {
    for (int i = 0; i < size; ++i) {
        int minIndex = i;
        for (int j = i+1; j < size; ++j) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }

        swap(arr[i], arr[minIndex]);
    }
}

//Merge Sort
void MergeSort(int *arr, int left, int right) {
    if (left == right) return;
    int mid = (left + right) / 2;
    MergeSort(arr, left, mid);
    MergeSort(arr, mid+1, right);
    Merge(arr, left, mid, mid+1, right);
}

void Merge(int *arr, int aLeft, int aRight, int bLeft, int bRight) {
    int size = bRight - aLeft + 1;
    int tmp [size];
    int tIndex = 0;
    int aIndex = aLeft;
    int bIndex = bLeft;

    while (aIndex <= aRight && bIndex <= bRight) {
        if (arr[aIndex] <= arr[bIndex]) {
            tmp[tIndex] = arr[aIndex];
            ++aIndex;
        }

        else {
            tmp[tIndex] = arr[bIndex];
            ++bIndex;
        }

        ++tIndex;
    }

    while (aIndex <= aRight) {
        tmp[tIndex] = arr[aIndex];
        ++tIndex;
        ++aIndex;
    }

    while (bIndex <= bRight) {
        tmp[tIndex] = arr[bIndex];
        ++tIndex;
        ++bIndex;
    }

    for (int i = 0; i < size; ++i) {
        arr[aLeft+i] = tmp[i];
    }
}

//Quick Sort
int partition(int *arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j <= high - 1; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(arr[i], arr[j]);
        }
    }

    swap(arr[i + 1], arr[high]);
    return i + 1;
}

void QuickSort(int *arr, int low, int high) {
    if (low < high) {
        int pivot = partition(arr, low, high);

        QuickSort(arr, low, pivot - 1);
        QuickSort(arr, pivot + 1, high);
    }
}

int main() 
{
    int arr[1000000];
    
    for (int i = 0; i < 1000000; i++) {
    cout << i << endl;
    	arr[i] = 10;
    }
    
    BubbleSort(arr, 1000000);

    for (int i = 0; i < 1000000; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;

} 
