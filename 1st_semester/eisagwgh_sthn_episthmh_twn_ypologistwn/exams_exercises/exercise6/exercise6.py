# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

import random

# Points of Pieces
black_points = 0
white_points = 0

# Generate Random Positions of Pieces
def getRandElements():
    queen = random.randrange(63)
    rook = random.randrange(62)
    if rook >= queen:
        rook += 1
    bishop = random.randrange(61)
    if bishop >= min(queen,rook):
        bishop += 1
    if bishop >= max(queen,rook):
        bishop += 1
    return [[queen // 8, queen % 8],[rook // 8, rook % 8],[bishop // 8, bishop % 8]]

# 100 Custom Chess Games
for i in range(100):
    # Positions of Pieces 
    black_queen, white_bishop , white_rook = getRandElements()

    # Movements of Pieces
    # Queen Cross Movements 
    black_queen_0 = black_queen[0] - black_queen[1]
    black_queen_1 = black_queen[0] + black_queen[1]
    # Bishop Cross Movements 
    white_bishop_0 = white_bishop[0] - white_bishop[1]
    white_bishop_1 = white_bishop[0] + white_bishop[1]
    # Rook Cross Movements 
    white_rook_0 = white_rook[0] - white_rook[1]
    white_rook_1 = white_rook[0] + white_rook[1]

    # Calculation of Points
    # Black Points
    black_points += (black_queen[0] == white_bishop[0]) + (black_queen[0] == white_rook[0])
    black_points += (black_queen[1] == white_bishop[1]) + (black_queen[1] == white_rook[1])
    black_points += (black_queen_0 == white_bishop_0) + (black_queen_0 == white_rook_0)
    black_points += (black_queen_1 == white_bishop_1) + (black_queen_1 == white_rook_1) 
    # White Points
    white_points += black_queen[1] == white_rook[1]
    white_points += black_queen[0] == white_rook[0]
    white_points += black_queen_0 == white_bishop_0
    white_points += black_queen_1 == white_bishop_1

# Display Points
print("Black Points:", black_points)
print("White Points:", white_points)