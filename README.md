# Wordle

A text-based version of Wordle, Dordle, and Quordle that utilizes the original Wordle database

## Getting Started

Follow these instructions to get Wordle running on your computer.

1. **Clone the Repository:**
    ```bash
    git clone https://github.com/dihan922/wordle
    cd wordle
    ```

2. **Compile source files:**
    ```bash
    javac words.java
    javac toolkit.java
    javac game.java
    ```

## Usage

1. **Start Program:**
    ```bash
    java game
    ```

2. **Gameplay:**
    - The user can choose to play either Wordle (1 word), Dordle (2 words), or Quordle (4 words)
    - The user can then guess a word and get feedback on their guess: 
        - Green highlight: letter placed in correct spot
        - Yellow highlight: letter in word but not in correct spot
        - No highlight: letter not in word
    - The game ends if the user guesses the word(s) correctly or if they run out of turns.

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
