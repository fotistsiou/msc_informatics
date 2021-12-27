# Guidelines #

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

# Python Variables #

a = "Hello World" # assign value
print(a) # print variable

# Python Strings #

b = "Hello World from Python!"
print(b[0]) # Print the 1st character
print(b[-1]) # Print the last character
print(b[3:]) # Print characters from the 4rd to the last character and the 4rd character
print(b[:3]) # Print characters up to the 4rd character, not the 4rd character
print(b[3:10]) # Print characters from the 4rd to the 11th character and the 4rd character but not the 11th character
print(b[3:10][::-1]) # Print above but reversed
print(b.count("o")) # Returns the number of times a specified value occurs in a string
print(b.find("o")) # Searches the string for the value "o" and returns the position of where it was found
print(b[4:].find("o")) # Returns the position of 2nd "o"