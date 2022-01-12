# import random

# cards = []
# figures = ["J", "Q", "K"]
# fullo = [i for i in range(1, 11)] + figures
# # colors = ["C", "D", "S", "H"]
# colors=['\u2660','\u2663','\u2665','\u2666',]

# for i in fullo:
#     for j in colors:
#         cards.append([i,j])

# random.shuffle(cards)

# def sum_score(crds):
#     score=0
#     for card in crds:
#         if card[0] in figures:
#             score=score+10
#         else:
#             score=score+card[0]
#     return score

# def print_cards(crds):
#     tmp = ""
#     for c in crds:
#         tmp = tmp + str(c[0]) + c[1] + " "
#     return tmp


# player1=[]
# player1.append(cards.pop())
# player1.append(cards.pop())
# print(print_cards(player1))
# score_player1 = sum_score(player1)

# # player1=[]
# # player1.append(cards.pop())
# # player1.append(cards.pop())
# # print(player1)
# # score_player1 = sum_score(player1)

# # score_player1=0
# # for card in player1:
# #     if card[0] in figures:
# #         score_player1=score_player1+10
# #     else:
# #         score_player1=score_player1+card[0]
# # print(score_player1)

# # player2=[]
# # player2.append(cards.pop())
# # player2.append(cards.pop())
# # print(player2) 
# # score_player2 = sum_score(player2)

# player2=[]
# player2.append(cards.pop())
# player2.append(cards.pop())
# print(print_cards(player2))
# score_player2 = sum_score(player2)


# # score_player2=0
# # for card in player2:
# #     if card[0] in figures:
# #         score_player2=score_player2+10
# #     else:
# #         score_player2=score_player2+card[0]
# # print(score_player2)

# if score_player1>score_player2:
#     print("P1 win!")
# elif score_player2>score_player1:
#     print("P2 win")
# else:
#     print("Draw")



# ----------------- #

import random
from colorama import Fore, Back, Style
figures = ["J", "Q", "K"]
fullo = [i for i in range(1, 11)] + figures
colors = ["♣", "◆", "♠", "♥"]


def sum_cards(crds):
    score = 0
    for card in crds:
        if card[0] in figures:
            score = score + 10
        else:
            score = score + card[0]
    return score


def print_cards(crds):
    tmp = ""
    for c in crds:
        if c[1] in [ "◆", "♥"]:
            tmp=tmp+Fore.RED
        tmp = tmp + str(c[0]) + c[1] + " "
        if c[1] in [ "◆", "♥"]:
            tmp=tmp+Style.RESET_ALL
    return tmp

for i in range(10):
    cards = []

    for i in fullo:
        for j in colors:
            cards.append([i, j])
    random.shuffle(cards)
    player1 = []
    while sum_cards(player1) < 17:
        player1.append(cards.pop())
    print(print_cards(player1))
    score_p1 = sum_cards(player1)

    print("P2 joins the game!")
    player2 = []
    while sum_cards(player2) < 17:
        player2.append(cards.pop())
    print(print_cards(player2))
    score_p2 = sum_cards(player2)

    if score_p1 > 21:
        print("P1 burn!!!!")
    elif score_p2 > 21:
        print("P2 burn!!!!")
    elif score_p1 > score_p2:
        print("P1 wins!")
    elif score_p2 > score_p1:
        print("P2 wins!")
    else:
        print("Draw...")