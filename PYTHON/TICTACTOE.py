#2d array in python

import numpy as np
i = 0
size = 9
list= []
HIT = 0
P1 = 8
P2 = 1
matrix = np.array([0,0,0,0,0,0,0,0,0])  #initialize

#*******************************************************************************
print("")
print("")
print("]|>++++++++<||>      TICK TACK TOE       <||>++++++++<|[ \n-by SELVIN DESOUZA \n")
print ("============================================================")
print("Select Positions Based on the Below given numbers :")

print("  | 0 | 1 | 2 |   <|>   | X | O | X |")
print("  | 3 | 4 | 5 |   <|>   | X | X | O |")
print("  | 6 | 7 | 8 |   <|>   | O | X | O |")

print ("============================================================")
print("")
print("Patterns for both players are :")
print("|~~~~|>  PLAYER 1 : \"X\"    ||    PLAYER 2 : \"O\"  <|~~~~|")
print ("============================================================")
print("")
#********************************************************************************
def p1win():
    print("     =================================")
    print("     ||       PLAYER 1 WIN!!.       ||")
    print("     =================================")
#********************************************************************************
def p2win():
    print("     =================================")
    print("     ||       PLAYER 2 WIN!!.       ||")
    print("     =================================")
    
def wincheck(PTN):
    if(matrix[0] == matrix[1] == matrix[2] == PTN) or (matrix[3] == matrix[4] == matrix[5] == PTN) or (matrix[6] == matrix[7] == matrix[8] == PTN):
        HIT = 1 #horizontal check
        return HIT
    elif(matrix[0] == matrix[3] == matrix[6] == PTN) or (matrix[1] == matrix[4] == matrix[7] == PTN) or (matrix[2] == matrix[5] == matrix[8] == PTN):
        HIT = 1 #vertical check
        return HIT
    elif(matrix[0] == matrix[4] == matrix[8] == PTN) or (matrix[2] == matrix[4] == matrix[6] == PTN):
        HIT = 1 #diagonal check
        return HIT
    else:
        HIT = 0 #no match found
        return HIT
#****************************************************************************************
def printmatrix():
    print ("============================================================")
    displaylist=[]
    i=0
    while  i < size:
        if (matrix[i] == P1):
            displaylist.append("X")
        elif (matrix[i] == P2):
            displaylist.append("O")
        else:
            displaylist.append("~")
        i=i+1
    M=''.join(displaylist)
    print("  | 0 | 1 | 2 |   <|>   |",  M[0]  ,"|",  M[1]  ,"|",  M[2]  ,"|")
    print("  | 3 | 4 | 5 |   <|>   |",  M[3]  ,"|",  M[4]  ,"|",  M[5]  ,"|")
    print("  | 6 | 7 | 8 |   <|>   |",  M[6]  ,"|",  M[7]  ,"|",  M[8]  ,"|")
    print ("============================================================")
#********************************************************************************

while i< size:
    if(i%2==0):
        print ("Player 1 >>>")
        N=int(input("Enter the Position : "))
        while N in list or N<0 or N>8 :
            if(N<0 or N>8):
                print("Position out of range")
            elif N in list:
                print("Position already selected by Player")                
            N=int(input("Re-Enter the Position : "))
        matrix[N] = P1
        list.append(N)
        printmatrix()
        PTN = P1
        if (i>2):
            HIT = wincheck(PTN)
            if(HIT > 0):
                p1win()
                break
        i=i+1
    else:
        print ("Player 2 >>>")
        N=int(input("Enter the Position : "))
        while N in list or N<0 or N>8 :
            if(N<0 or N>8):
                print("Position out of range")
            elif N in list:
                print("Position already selected by Player")                
            N=int(input("Re-Enter the Position : "))
        matrix[N] = P2
        list.append(N)
        printmatrix()
        PTN = P2
        if (i>2):
            HIT = wincheck(PTN)
            if(HIT > 0):
                p2win()
                break
        i=i+1

if i == size :
    print("||-[]-||>    IT IS A TIE.    <|>    PLAY AGAIN.    <||-[]-||")

