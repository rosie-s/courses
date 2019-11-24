#include <iostream>

void PrintIntroduction()
{
    // Print welcome messages to the terminal                                                                                    
    std::cout << R"(
                    .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.   .----------------. 
                    | .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. | | .--------------. |
                    | |  _________   | || |  _______     | || |     _____    | || |   ______     | || |   _____      | || |  _________   | | | |  ____  ____  | |
                    | | |  _   _  |  | || | |_   __ \    | || |    |_   _|   | || |  |_   __ \   | || |  |_   _|     | || | |_   ___  |  | | | | |_  _||_  _| | |
                    | | |_/ | | \_|  | || |   | |__) |   | || |      | |     | || |    | |__) |  | || |    | |       | || |   | |_  \_|  | | | |   \ \  / /   | |
                    | |     | |      | || |   |  __ /    | || |      | |     | || |    |  ___/   | || |    | |   _   | || |   |  _|  _   | | | |    > `' <    | |
                    | |    _| |_     | || |  _| |  \ \_  | || |     _| |_    | || |   _| |_      | || |   _| |__/ |  | || |  _| |___/ |  | | | |  _/ /'`\ \_  | |
                    | |   |_____|    | || | |____| |___| | || |    |_____|   | || |  |_____|     | || |  |________|  | || | |_________|  | | | | |____||____| | |
                    | |              | || |              | || |              | || |              | || |              | || |              | | | |              | |
                    | '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' | | '--------------' |
                    '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'   '----------------' 
                    )" << std::endl; 
    std::cout << "You are a secret agent breaking into a secure server room....\n";
    std::cout << "Enter the correct code to continue!\n\n";
}

void PlayGame()
{
    PrintIntroduction();

    const int CodeA = 1;
    const int CodeB = 2;
    const int CodeC = 3;

    const int CodeSum = CodeA + CodeB + CodeC;
    const int CodeProduct = CodeA * CodeB * CodeC;

    // Print sum and product to the terminal
    std::cout << "** There are 3 numbers in the code";
    std::cout << "\n** The codes add up to: " << CodeSum;
    std::cout << "\n** The codes multiply to give: " << CodeProduct << std::endl;

    // Store player's guess
    int GuessA, GuessB, GuessC;
    std::cin >> GuessA >> GuessB >> GuessC;

    int GuessSum = GuessA + GuessB + GuessC;
    int GuessProduct = GuessA * GuessB * GuessC;

    // Check it the player's guess is correct
    if (GuessSum == CodeSum && GuessProduct == CodeProduct)
    {
        std::cout << "\nYou Win!";
    }
    else
    {
        std::cout << "\nYou Lose!";
    }
}

int main()
{
    PlayGame();
    return 0;
}