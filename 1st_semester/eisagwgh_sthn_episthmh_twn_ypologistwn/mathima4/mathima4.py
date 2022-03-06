# Guidelines from Fotis K. Tsioumas # 

# In order to run this code, have to follow below steps:
# 1. Open the terminal
# 2. Run: cd/<file_path>
# 3. Run: python3 <filename.py>

# Start Code #

# Python Dictionaries #

# Simple Dictionary
thisdict1 = {
  "name": "Fotis",
  "surname": "Tsioumas",
  "age": 26
}
print(thisdict1["name"])

# List from Dictionaries
thisdict2 = [{
  "name": "Fotis",
  "surname": "Tsioumas",
  "age": 26
},{"name": "Aspa",
  "surname": "Sideri",
  "age": 26}]
print(thisdict2[1]["name"])

# Change Field
thisdict1["age"] = 62
print(thisdict1["age"])

# Add Field
thisdict1["job"] = "Developer"
print(thisdict1)

# Print Keys
print(thisdict1.keys())