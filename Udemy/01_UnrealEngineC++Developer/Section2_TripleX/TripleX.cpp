#include <iostream>
#include <ctime>

// Functions definitions
void PrintLogo();
void PrintIntroduction(int Difficulty);
bool PlayGame(int Difficulty, int MaxDifficulty);

int main()
{
    srand(time(NULL)); // Create new random sequence based on the time of day

    PrintLogo();
    int LevelDifficulty = 1;
    const int MaxDifficulty = 2;

    while (LevelDifficulty <= MaxDifficulty) // Loop game until all levels are completed
    {
        bool bLevelComplete = PlayGame(LevelDifficulty, MaxDifficulty);
        std::cin.clear();  // Clears any errors
        std::cin.ignore(); // Discards the buffer

        if (bLevelComplete)
        {
            ++LevelDifficulty;
        }
    }

    return 0;
}

// Functions
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
                    )"
              << std::endl;
    std::cout << "\n************************************************************************";
}

void PrintIntroduction(int Difficulty)
{
    // Print welcome messages to the terminal
    if (Difficulty == 1)
    {
        std::cout << "\n\nSecret agent Agent P, you need to break into a level " << Difficulty << " secure server room....\n";
    }
    else
    {
        std::cout << "\n\nNow break into the level " << Difficulty << " secure server room....\n";
    }
    std::cout << "Enter the correct code to continue!\n\n";
}

bool PlayGame(int Difficulty, int MaxDifficulty)
{
    PrintIntroduction(Difficulty);

    const int CodeA = rand() % Difficulty + Difficulty;
    const int CodeB = rand() % Difficulty + Difficulty;
    const int CodeC = rand() % Difficulty + Difficulty;

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
        if (Difficulty != MaxDifficulty)
        {
            std::cout << "\n*** Well done Agent P! You have extracted a file! Keep going! ***";
            std::cout << "\n************************************************************************";
            return true;
        }
        std::cout << "\n************************************************************************";
        std::cout << "\n*** Great work Agent P! You got all the files! Now get out of there! ***";
        std::cout << "\n************************************************************************";
    }
    else
    {
        std::cout << "\n*** You entered the wrong code! Careful Agent P! Try again! ***";
        std::cout << "\n************************************************************************";
        return false;
    }
}