# --- Scenario 1 ---

def factorial(n):
    if n == 0:  # base case
        return 1
    return n * factorial(n - 1)


def sum_n(n):
    if n == 1:  # base case
        return 1
    return n + sum_n(n - 1)


# --- Main Program ---
n = int(input("Enter a number: "))

print("Factorial of", n, "=", factorial(n))
print("Sum from 1 to", n, "=", sum_n(n))


# --- Infinite Recursion Example (DO NOT RUN) ---
# This function will cause a recursion error because it lacks a base case.

"""
def bad_factorial(n):
    return n * bad_factorial(n - 1)
"""