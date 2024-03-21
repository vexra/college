#include <iostream>
#include <ctime>
using namespace std;

template<typename T> class AgeCalculator {
public:
    // Constructor
    AgeCalculator(T newDay, T newMonth, T newYear) : day(newDay), month(newMonth), year(newYear) {}

    // Setter
    void setDay(T newDay);
    void setMonth(T newMonth);
    void setYear(T newYear);

    // Getter
    T getDay();
    T getMonth();
    T getYear();

    // Member function for calculating age based on day of birth
    void printAge();

    // Member function for calculating the number of days in a given month in a given year
    int numberOfDays(int month, int year);

    // Member function for leap year checking
    bool isLeapYear(int year);



private:
    T day;
    T month;
    T year;
};

template<typename T>
void AgeCalculator<T>::setDay(T newDay)
{
    this->day = newDay;
}

template<typename T>
void AgeCalculator<T>::setMonth(T newMonth)
{
    this->month = newMonth;
}

template<typename T>
void AgeCalculator<T>::setYear(T newYear)
{
    this->year = newYear;
}

template<typename T>
T AgeCalculator<T>::getDay() 
{
    return this->day;
}

template<typename T>
T AgeCalculator<T>::getMonth()
{
    return this->month;
}

template<typename T>
T AgeCalculator<T>::getYear()
{
    return this->year;
}

template<typename T>
void AgeCalculator<T>::printAge()
{
    time_t now = time(0);
    tm *ltm = localtime(&now);

    int currentYear = 1900 + ltm->tm_year;
    int currentMonth = 1 + ltm->tm_mon;
    int currentDay = ltm->tm_mday;

    int years = currentYear - this->year;
    int months = currentMonth - this->month;
    int days = currentDay - this->day;

    if (days < 0) {
        --months;
        days += 30;
    }

    if (months < 0) {
        --years;
        months += 12;
    }

    cout << "Umur anda adalah " << years << " tahun " << months << " bulan " << days << " hari" << endl;

}

template<typename T>
int AgeCalculator<T>::numberOfDays(int month, int year)
{
    int days[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    if (isLeapYear(year) && month == 2) return days[month-1]+1;
    
    return days[month-1];
}

template<typename T>
bool AgeCalculator<T>::isLeapYear(int year)
{
    int query = year ? year : this->year;

    return query % 4 == 0 && (query % 100 != 0 || query % 400 == 0);
}

int main()
{
    int day, month, year;

    cout << "Masukkan tanggal, bulan, dan tahun lahir anda: ";
    cin >> day >> month >> year;

    AgeCalculator<int> person(day, month, year);

    person.printAge();
    cout << person.isLeapYear(2004) << endl;
    cout << person.numberOfDays(9, 2004) << endl;
}