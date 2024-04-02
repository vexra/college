#include <iostream>
#include <initializer_list>
#include <algorithm>
#include <cassert> // For Test
#include <random> // For Test
#include <functional> // For Test

// Legal types of template parameter T will support:
// - value initialization: return to zero
// - Copy semantics: copy construction and assignment
// - Comparison operations between the same types: ==, !=, >, >=, <, <=
//Possible types that meet the above requirements are: int, double, std::string, etc.
template<typename T>
class Set {
    using Iterator = typename std::vector<T>::iterator;
    using ConstIterator = typename std::vector<T>::const_iterator;
public:
    Set() = default;
    Set(std::initializer_list<T> l);
    explicit Set(const std::vector<T>& values);
    explicit Set(std::vector<T>&& values);
    void Add(const T&);
    void Add(T&&);
    void Remove(const T&);
    [[nodiscard]] bool Contains(const T&) const;
    [[nodiscard]] size_t Size() const noexcept { return repr_.size(); }

    void Swap(Set<T>& other);
    void Clear();
    [[nodiscard]] bool IsDisjointWith(const Set<T>& other) const;

    [[nodiscard]] Iterator begin() {
        return repr_.begin();
    }

    [[nodiscard]] Iterator end() {
        return repr_.end();
    }

    [[nodiscard]] ConstIterator begin() const {
        return repr_.begin();
    }
    
    [[nodiscard]] ConstIterator end() const {
        return repr_.end();
    }

private:
     std::vector<T> repr_;
};

template<typename T>
Set<T>::Set(std::initializer_list<T> l) {
     for (const T& v : l) {
         Add(v);
     }
}

template<typename T>
Set<T>::Set(const std::vector<T>& values) {
     for (const T& v : values) {
         Add(v);
     }
}

template<typename T>
Set<T>::Set(std::vector<T>&& values) {
     for (T& v : values) {
         Add(std::move(v));
     }
}

template<typename T>
void Set<T>::Add(const T& val) {
     if (!Contains(val)) {
         repr_.push_back(val);
     }
}

template<typename T>
void Set<T>::Add(T&& val) {
     if (!Contains(val)) {
         repr_.push_back(std::move(val));
     }
}

template<typename T>
void Set<T>::Remove(const T& val) {
     auto p = std::find(std::begin(repr_), std::end(repr_), val);
     if (p != std::end(repr_)) {
         repr_.erase(p);
     }
}

template<typename T>
bool Set<T>::Contains(const T& val) const {
     return std::find(std::begin(repr_), std::end(repr_), val) != std::end(repr_);
}

template<typename T>
void Set<T>::Swap(Set<T>& other) {
    using std::swap;
    swap(this->repr_, other.repr_);
}

template<typename T>
void Set<T>::Clear() {
    repr_.clear();
}

template<typename T>
std::ostream& operator<<(std::ostream& os, const Set<T>& s) {
     std::vector<T> output(s.begin(), s.end());
     std::sort(std::begin(output), std::end(output));
     os << '{';
     if (output.size() > 0) {
         os << output[0];
         for (size_t i = 1; i < output.size(); ++i) {
             os << ", " << output[i];
         }
     }
     os << '}';
     return os;
}

template<typename T>
bool operator==(const Set<T>& lhs, const Set<T>& rhs) {
    if (lhs.Size() != rhs.Size()) {
        return false;
    }

    for (const auto& val : lhs) {
        if (!rhs.Contains(val)) {
            return false;
        }
    }

    return true;
}

template<typename T>
bool operator!=(const Set<T>& lhs, const Set<T>& rhs) {
    return !(lhs == rhs);
}

template<typename T>
bool operator<=(const Set<T>& lhs, const Set<T>& rhs) {
    for (const auto& val : lhs) {
        if (!rhs.Contains(val)) {
            return false;
        }
    }
    return true;
}

template<typename T>
bool operator>=(const Set<T>& lhs, const Set<T>& rhs) {
    for (const auto& val : rhs) {
        if (!lhs.Contains(val)) {
            return false;
        }
    }
    return true;
}

template<typename T>
Set<T> operator&(const Set<T>& lhs, const Set<T>& rhs) {
    Set<T> result;
    for (const auto& val : lhs) {
        if (rhs.Contains(val)) {
            result.Add(val);
        }
    }
    return result;
}

template<typename T>
Set<T> operator|(const Set<T>& lhs, const Set<T>& rhs) {
    Set<T> result = lhs;
    for (const auto& val : rhs) {
        result.Add(val);
    }
    return result;
}

template<typename T>
bool Set<T>::IsDisjointWith(const Set<T>& other) const {
    for (const auto& val : repr_) {
        if (other.Contains(val)) {
            return false;
        }
    }
    return true;
}

template<typename T>
Set<T> operator^(const Set<T>& lhs, const Set<T>& rhs) {
    Set<T> result;
    for (const auto& val : lhs) {
        if (!rhs.Contains(val)) {
            result.Add(val);
        }
    }
    for (const auto& val : rhs) {
        if (!lhs.Contains(val)) {
            result.Add(val);
        }
    }
    return result;
}

template<typename T>
Set<T> operator-(const Set<T>& lhs, const Set<T>& rhs) {
    Set<T> result;
    for (const auto& val : lhs) {
        if (!rhs.Contains(val)) {
            result.Add(val);
        }
    }
    return result;
}

void Test1(); // Sample1
void Test2(); // Swap, Clear
void Test3(); // operator==, operator!=
void Test4(); // operator<=, operator>=
void Test5(); // operator&, operator|, IsDisjointWith
void Test6(); // operator^, operator-
void Test7(); // All

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    int id;
    std::cin >> id;
    void (*f[])() = { Test1, Test2, Test3, Test4, Test5, Test6, Test7 };
    f[id-1]();
}

void Test1() {
    //Implement the Swap(other) method to exchange content with the collection other
    //Implement the Clear() method to clear the content and make the collection empty
    Set<int> a = {3, 9, 5};
    Set<int> b = {3, 9, 1, 7, 5, 3};
    std::cout << "2.1) " << a << std::endl;
    std::cout << "2.2) " << b << std::endl;
    a.Swap(b);
    std::cout << "2.3) " << a << std::endl;
    std::cout << "2.4) " << b << std::endl;
    a.Clear();
    std::cout << "2.5) " << a << std::endl;
    // Print out in order:
    // 2.1) {3, 5, 9}
    // 2.2) {1, 3, 5, 7, 9}
    // 2.3) {1, 3, 5, 7, 9}
    // 2.4) {3, 5, 9}
    // 2.5) {}
}

void Test2() {
    //Implement the operator== operation and return whether the two sets are equal
    // Implement the operator!= operation and return whether the two sets are not equal
    // - Two sets are equal as long as all the elements have the same value and number, regardless of the order in which the elements are stored.
    // operator==, operator !=
    Set<int> a = {1, 3};
    Set<int> b = {1, 3, 2};
    Set<int> c = {3, 1};

    std::cout << "3.1) " << std::boolalpha << (a == a) << std::endl;
    std::cout << "3.2) " << std::boolalpha << (a == b) << std::endl;
    std::cout << "3.3) " << std::boolalpha << (a== c) << std::endl;
    std::cout << "3.4) " << std::boolalpha << (a != a) << std::endl;
    std::cout << "3.5) " << std::boolalpha << (a != b) << std::endl;
    std::cout << "3.6) " << std::boolalpha << (a != c) << std::endl;

    Set<std::string> d = {"1.5", "3.4"};
    Set<std::string> e = {"1.5", "3.5", "2.5"};
    Set<std::string> f = {"3.5", "1.5"};

    std::cout << "3.7) " << std::boolalpha << (d == e) << std::endl;
    std::cout << "3.8) " << std::boolalpha << (d == f) << std::endl;
    std::cout << "3.9) " << std::boolalpha << (d != e) << std::endl;
    std::cout << "3.10) " << std::boolalpha << (d != f) << std::endl;

    // print out in sequence
    // 3.1) true
    // 3.2) false
    // 3.3) true
    // 3.4) false
    // 3.5) true
    // 3.6) false
    // 3.7) false
    // 3.8) false
    // 3.9) true
    // 3.10) true
}


void Test3() {
    // Implement the operator<= operation and return whether all element values ​​in the set lhs appear in the set rhs
    // Implement the operator>= operation and return whether all element values ​​in the set rhs appear in the set lhs
    Set<int> a = {1, 3};
    Set<int> b = {1, 3, 2};
    Set<int> c = {3, 2};
    Set<int> g = {3, 1};

    std::cout << "4.1) " << std::boolalpha << (a <= g) << std::endl;
    std::cout << "4.2) " << std::boolalpha << (a >= g) << std::endl;
    std::cout << "4.3) " << std::boolalpha << (a <= b) << std::endl;
    std::cout << "4.4) " << std::boolalpha << (a >= b) << std::endl;
    std::cout << "4.5) " << std::boolalpha << (a <= c) << std::endl;
    std::cout << "4.6) " << std::boolalpha << (a >= c) << std::endl;
    std::cout << "4.7) " << std::boolalpha << (b <= c) << std::endl;
    std::cout << "4.8) " << std::boolalpha << (b >= c) << std::endl;

    Set<std::string> d = {"1.5", "3.5"};
    Set<std::string> e = {"1.5", "3.5", "2.4"};
    Set<std::string> f = {"3.5", "2.5"};

    std::cout << "4.9) " << std::boolalpha << (d <= e) << std::endl;
    std::cout << "4.10) " << std::boolalpha << (d >= e) << std::endl;
    std::cout << "4.11) " << std::boolalpha << (d <= f) << std::endl;
    std::cout << "4.12) " << std::boolalpha << (d >= f) << std::endl;
    std::cout << "4.13) " << std::boolalpha << (e <= f) << std::endl;
    std::cout << "4.14) " << std::boolalpha << (e >= f) << std::endl;

    //Print out in order:
    // 4.1) true
    // 4.2) true
    // 4.3) true
    // 4.4) false
    // 4.5) false
    // 4.6) false
    // 4.7) false
    // 4.8) true
    // 4.9) true
    // 4.10) false
    // 4.11) false
    // 4.12) false
    // 4.13) false
    // 4.14) false
}


void Test4() {
    // Implement the operator& operation and return a new set representing the intersection: including all element values ​​that appear in the sets lhs and rhs
    // Implement the operator| operation and return a new set representing the union: including all element values ​​that appear in the set lhs or rhs
    //Implement the IsDisjointWith method and return whether the intersection with the set other is empty

    Set<int> a = {1, 3};
    Set<int> b = {1, 3, 2};
    Set<int> c = {3, 2};
    Set<int> g = {4, 5};

    std::cout << "5.1) " << (a & a) << std::endl;
    std::cout << "5.2) " << (a & b) << std::endl;
    std::cout << "5.3) " << (a & c) << std::endl;
    std::cout << "5.4) " << (a | a) << std::endl;
    std::cout << "5.5) " << (a | b) << std::endl;
    std::cout << "5.6) " << (a | c) << std::endl;
    std::cout << "5.7) " << std::boolalpha << a.IsDisjointWith(b) << std::endl;
    std::cout << "5.8) " << std::boolalpha << a.IsDisjointWith(g) << std::endl;

    Set<std::string> d = {"1.5", "3.5"};
    Set<std::string> e = {"1.5", "3.5", "2.4"};
    Set<std::string> f = {"3.5", "2.5"};
    Set<std::string> h = {"4.5", "5.5"};

    std::cout << "5.9) " << (d & e) << std::endl;
    std::cout << "5.10) " << (d & f) << std::endl;
    std::cout << "5.11) " << (d | e) << std::endl;
    std::cout << "5.12) " << (d | f) << std::endl;
    std::cout << "5.13) " << (d | e | f) << std::endl;
    std::cout << "5.14) " << std::boolalpha << d.IsDisjointWith(e) << std::endl;
    std::cout << "5.15) " << std::boolalpha << d.IsDisjointWith(h) << std::endl;

    //Print out in order:
    // 5.1) {1, 3}
    // 5.2) {1, 3}
    // 5.3) {3}
    // 5.4) {1, 3}
    // 5.5) {1, 2, 3}
    // 5.6) {1, 2, 3}
    // 5.7) false
    // 5.8) true
    // 5.9) {1.5, 3.5}
    // 5.10) {3.5}
    // 5.11) {1.5, 2.4, 3.5}
    // 5.12) {1.5, 2.5, 3.5}
    // 5.13) {1.5, 2.4, 2.5, 3.5}
    // 5.14) false
    // 5.15) true
}

void Test5() {
    // Implement the operator^ operation and return a new set containing all element values ​​that only exist in one of the collections lhr or rhs
    // Implement the operator- operation and return a new set representing the difference set, including the element values ​​that appear in lhs but not in rhs in all sets
    Set<int> a = {1, 3};
    Set<int> b = {1, 3, 2};
    Set<int> c = {3, 2};
    Set<int>d;

    std::cout << "6.1) " << (a ^ a) << std::endl;
    std::cout << "6.2) " << (a ^ b) << std::endl;
    std::cout << "6.3) " << (a ^ c) << std::endl;
    std::cout << "6.4) " << (a - a) << std::endl;
    std::cout << "6.5) " << (a - b) << std::endl;
    std::cout << "6.6) " << (a - c) << std::endl;

    //Print out in order:
    // 6.1) {}
    // 6.2) {2}
    // 6.3) {1, 2}
    // 6.4) {}
    // 6.5) {}
    // 6.6) {1}
}


void Test6() {}

void Test7() {}