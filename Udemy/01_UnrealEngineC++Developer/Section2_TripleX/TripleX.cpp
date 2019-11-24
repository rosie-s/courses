#include <iostream>

void PrintLogo()
{
    // Print logo to the terminal                                                                                    
    std::cout << R"(
                      _______   _       _       __   __
                     |__   __| (_)     | |      \ \ / /
                        | |_ __ _ _ __ | | ___   \ V / 
                        | | '__| | '_ \| |/ _ \   > <  
                        | | |  | | |_) | |  __/  / . \ 
                        |_|_|  |_| .__/|_|\___| /_/ \_\
                                 | |                   
                                 |_|                   
                    )" << std::endl;
}

void PrintIntroduction(int Difficulty)
{
    // Print welcome messages to the terminal
    std::cout << "\n\nYou are a secret agent breaking into a level " << Difficulty << " secure server room....\n";
    std::cout << "Enter the correct code to continue!\n\n";
}

bool PlayGame(int Difficulty)
{
    PrintIntroduction(Difficulty);

    const int CodeA = rand();
    const int CodeB = rand();
    const int CodeC = rand();

    const int CodeSum = CodeA + CodeB + CodeC;
    const int CodeProduct = CodeA * CodeB * CodeC;

    // Print sum and product to the terminal
    std::cout << "|| There are 3 numbers in the code";
    std::cout << "\n|| The codes add up to: " << CodeSum;
    std::cout << "\n|| The codes multiply to give: " << CodeProduct << std::endl;

    // Store player's guess
    int GuessA, GuessB, GuessC;
    std::cin >> GuessA >> GuessB >> GuessC;

    int GuessSum = GuessA + GuessB + GuessC;
    int GuessProduct = GuessA * GuessB * GuessC;

    // Check it the player's guess is correct
    if (GuessSum == CodeSum && GuessProduct == CodeProduct)
    {
        std::cout << "\n*** Well done Agent P! You have extracted a file! Keep going! ***";
        return true;
    }
    else
    {
        std::cout << "\n*** You entered the wrong code! Careful Agent P! Try again! ***";
        return false;
    }
}

int main()
{          
    PrintLogo();
    int LevelDifficulty = 1;
    const int MaxDifficulty = 5;

    while(LevelDifficulty <= MaxDifficulty) // Loop game until all levels are completed
    {
        bool bLevelComplete = PlayGame(LevelDifficulty);
        std::cin.clear(); // Clears any errors
        std::cin.ignore(); // Discards the buffer

        if (bLevelComplete)
        {
            ++LevelDifficulty;
        }
        
    }
    std::cout << "\n*** Great work Agent P! You got all the files! Now get out of there! ***";
    return 0;
}