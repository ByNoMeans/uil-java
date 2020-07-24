fhand = open("cross.dat")
sets = int(fhand.readline())

DBG = 0

for set in range(sets):
   
   # *** LINE 1 (data set) ***
   line1 = fhand.readline().rstrip()
   data = line1.split()
   word1 = data[0]
   word2 = data[2]
   if DBG: print(word1,word2)
   word2Dict = {}
   # put word2 characters in a dictionary
   for char in word2:
      word2Dict[char] = 1
   pos1 = 0
   found = 0
   # find the first character in word1 that occurs in word2
   for char1 in word1:
      if word2Dict.get(char1,0):
         found = 1
         break
      pos1 = pos1 + 1
   if DBG: print(found,char1,pos1)
   if not found:
      print("none\n")
   else:
      # find char1's position in word2
      pos2 = 0
      for char2 in word2:
         if char2 == char1:
            break
         pos2 = pos2 + 1
      if DBG: print(char1,pos1,pos2)
      # print out the words
      pos = 0
      for char in word2:
         if pos == pos2:   # positions match print horizontal word
            print(word1)
         else:
            print(' ' * pos1 + char)
         pos = pos + 1
      print('')
         
      
      
      
      
      
