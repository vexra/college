def fibonacci(n):
 
    fib_1 = 0
    fib_2 = 1
 
    print(fib_1)
    print(fib_2)
 
 
    for i in range(2, n):
        fib_variabel = fib_1 + fib_2
        print(fib_variabel, end=" ")
        fib_1 = fib_2
        fib_2 = fib_variabel
 
 
n = int(input("Tuliskan jumlah bilangan : "))
 
print('Deret Fibonacci untuk 10 bilangan adalah :')
fibonacci(n)
