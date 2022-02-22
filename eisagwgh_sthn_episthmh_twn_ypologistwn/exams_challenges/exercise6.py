# Imports
import random

# Wins of Pieces
black_queen_wins = 0
white_bishop_and_white_rook_wins = 0

for i in range(100):
    # Positions of Pieces 
    black_queen = [(random.randrange(1,9)),(random.randrange(1,9))]
    white_bishop = [(random.randrange(1,9)),(random.randrange(1,9))]
    white_rook = [(random.randrange(1,9)),(random.randrange(1,9))]

    # Calculation Scores
    black_queen_score = 0
    white_bishop_and_white_rook_score = 0
    # Black Queen
    for i in range(1,9):
        if white_bishop[0] == black_queen[0] and white_bishop[1] == i:
            black_queen_score += 1
        elif white_bishop[0] == i and white_bishop[1] == black_queen[1]:
            black_queen_score += 1
        if white_rook[0] == black_queen[0] and white_rook[1] == i:
            black_queen_score += 1
        elif white_rook[0] == i and white_rook[1] == black_queen[1]:
            black_queen_score += 1
    for i in range(1,9):
        if white_bishop[0] == black_queen[0]+i and white_bishop[1] == black_queen[1]+i:
            black_queen_score += 1
        if white_rook[0] == black_queen[0]+i and white_rook[1] == black_queen[1]+i:
            black_queen_score += 1
    for i in range(1,9):
        if white_bishop[0] == black_queen[0]-i and white_bishop[1] == black_queen[1]-i:
            black_queen_score += 1
        if white_rook[0] == black_queen[0]-i and white_rook[1] == black_queen[1]-i:
            black_queen_score += 1
    # White Bishop
    for i in range(1,9):
        if black_queen[0] == white_bishop[0]+i and black_queen[1] == white_bishop[1]+i:
            white_bishop_and_white_rook_score += 1
    for i in range(1,9):
        if black_queen[0] == white_bishop[0]-i and black_queen[1] == white_bishop[1]-i:
            white_bishop_and_white_rook_score += 1
    # White Rook
    for i in range(1,9):
        if black_queen[0] == white_rook[0] and black_queen[1] == i:
            white_bishop_and_white_rook_score += 1
        elif black_queen[0] == i and black_queen[1] == white_rook[1]:
            white_bishop_and_white_rook_score += 1

    # Comparison Scores
    if black_queen_score > white_bishop_and_white_rook_score:
        black_queen_wins += 1
    elif black_queen_score < white_bishop_and_white_rook_score:
        white_bishop_and_white_rook_wins += 1

# Display and Comparison Scores
print("Black Queen Wins:", black_queen_wins)
print("White Bishop and White Rook Wins:", white_bishop_and_white_rook_wins)
if black_queen_wins > white_bishop_and_white_rook_wins:
    print("Black Queen Wins!")
elif black_queen_wins < white_bishop_and_white_rook_wins:
    print("White Bishop and White Rook Win!")
else:
    print("Draw...")