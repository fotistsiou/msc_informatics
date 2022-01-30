# Guidelines # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #


# ------- Create and Shuffle Cards ------- #
import random
figures = ["J", "Q", "K"]
fyllo = [i for i in range(1, 11)] + figures
colors = ["C", "D", "S", "H"]
cards = []
for i in fyllo:
    for j in colors:
        cards.append([i,j])
random.shuffle(cards)


# ------- Player 1 ------- #
player1 = []
score_player1 = 0
player1.append(cards.pop())
player1.append(cards.pop())
for card in player1:
    if card[0] in figures:
        score_player1 = score_player1 + 10
    else:
        score_player1 = score_player1 + card[0]
print("Player 1:", player1)
print("Score of Player 1:", score_player1)


# ------- Player 2 ------- #
player2 = []
score_player2 = 0
player2.append(cards.pop())
player2.append(cards.pop())
for card in player2:
    if card[0] in figures:
        score_player2 = score_player2 + 10
    else:
        score_player2 = score_player2 + card[0]
print("Player 2:",player2)
print("Score of Player 2:", score_player2)


# ------- Battle ------- #
if score_player1 > score_player2:
    print("Player 1 wins!")
elif score_player1 < score_player2:
    print("Player 2 wins!")
else:
    print("Draw...")