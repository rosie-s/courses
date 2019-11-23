#include <iostream>

int main()
{
    // Print welcome messages to the terminal
    std::cout << "You are a secret agent breaking into a secure server room....";
    std::cout << std::endl;
    std::cout << "Enter the correct code to continue" << std::endl;

    const int CodeA = 1;
    const int CodeB = 2;
    const int CodeC = 3;

    const int CodeSum = CodeA + CodeB + CodeC;
    const int CodeProduct = CodeA * CodeB * CodeC;

    // Print sum and product to the terminal
    std::cout << std::endl;
    std::cout << "** There are 3 numbers in the code" << std::endl;
    std::cout << "** The codes add up to: " << CodeSum << std::endl;
    std::cout << "** The codes multiply to give: " << CodeProduct << std::endl;

    int GuessA, GuessB, GuessC;

    std::cin >> GuessA;
    std::cin >> GuessB;
    std::cin >> GuessC;

    int GuessSum = GuessA + GuessB + GuessC;
    int GuessProduct = GuessA * GuessB * GuessC;

    if (GuessSum == CodeSum && GuessProduct == CodeProduct)
    {
        std::cout << "You Win!";
    }
    else
    {
        std::cout << "You Lose!";
    }
    
    return 0;
}