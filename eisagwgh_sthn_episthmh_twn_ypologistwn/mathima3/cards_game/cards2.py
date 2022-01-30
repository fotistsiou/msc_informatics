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


# ------- Add Cards ------- #
def sum_cards(cards):
    score = 0
    for card in cards:
        if card[0] in figures:
            score = score + 10
        else:
            score = score + card[0]
    return score
    

# ------- Print Cards ------- #
def print_cards(cards):
    temp = ""
    for card in cards:
        temp += str(card[0]) + card[1] + " "
    return temp


# ------- Player 1 ------- #
player1 = []
while sum_cards(player1) < 16:
    player1.append(cards.pop())
print("Player 1:", print_cards(player1))
score_player1 = sum_cards(player1)


# ------- Player 2 ------- #
player2 = []
while sum_cards(player2) < 15:
    player2.append(cards.pop())
print("Player 2:", print_cards(player2))
score_player2 = sum_cards(player2)


# ------- Battle ------- #
if score_player1 > 21 and score_player2 <= 21:
    print("Player 1 burns... Player 2 wins!")
elif score_player1 <= 21 and score_player2 > 21:
    print("Player 2 burns... Player 1 wins!")
elif score_player1 > 21 and score_player2 > 21:
    print("Both Player burns...")
elif score_player1 > score_player2:
    print("Player 1 wins!")
elif score_player1 < score_player2:
    print("Player 2 wins!")
else:
    print("Draw...")