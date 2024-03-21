def main():
   row = 5


   for i in range(5*2-1):
       print(chr(65+i), "", end="")
   print()
  
   for i in range(row-1, 0, -1):
       for j in range(row-i):
           print("  ", end="")


       print(chr(65), "", end="")


       for j in range(3, 2*i):
           print("  ", end="")
      
       if (1 != i):
           print(chr(65+i*2-2), "")
       else:
           print()
  
   for i in range(2, row):
       for j in range(row-i):
           print("  ", end="")
      
       print(chr(65), "", end="")
       for j in range(3, 2*i):
           print("  ", end="")
       print(chr(65+i*2-2), "", end="")
       print()


   for i in range(row*2-1):
       print(chr(65+i), "", end="")
   print()


if __name__ == "__main__":
   main()


