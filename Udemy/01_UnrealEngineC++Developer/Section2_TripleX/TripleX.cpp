#include <iostream>

int main()
{
    std::cout << "You are a secret agent breaking into a secure server room....";
    std::cout << std::endl;
    std::cout << "Enter the correct code to continue";

    const int a = 1;
    const int b = 2;
    const int c = 3;

    const int sum = a + b + c;
    const int product = a * b * c;

    std::cout << std::endl;
    std::cout << sum << std::endl;
    std::cout << product << std::endl;

    return 0;
}