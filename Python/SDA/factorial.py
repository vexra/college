def factorial_use_recursion(val):
    if val < 1:
        return 1
    return val * factorial_use_recursion(val-1)

def factoral_use_loop(val):
    res = 1
    for i in range(val):
        res *= val
        val -= 1
    return res

print(factorial_use_recursion(5))
print(factoral_use_loop(5))