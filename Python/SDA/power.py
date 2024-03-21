def power_use_recursion(base, exponent):
    if exponent == 0:
        return 1
    return base * power_use_recursion(base, exponent-1)

def power_use_loop(base, exponent):
    total = 1
    for i in range(exponent):
        total *= base
    return total