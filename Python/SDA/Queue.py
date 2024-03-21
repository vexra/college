class Queue:
    def __init__(self):
        self.data = []

    def __repr__(self):
        return str(self.data)

    def enqueue(self, element):
        self.data.append(element)

    def dequeue(self):
        return self.data.pop(0)

    def front(self):
        return self.data[0]
    
    def rear(self):
        return self.data[-1]

    def isEmpty(self):
        return len(self.data) == 0
    
    def size(self):
        return len(self.data)
    
    def printQueue(self):
        for i in range(len(self.data)):
            print(f'{i+1}. {self.data[i]}')
    
    def clear(self):
        self.data = []
    
def printMenu():
    print('1. Add to queue')
    print('2. Pop from queue')
    print('3. Print queue')
    print('4. Exit program')

if __name__ == "__main__":
    print('>>> Welcome to queue program ')
    qq = Queue()

    while True:
        printMenu()
        menu = int(input())

        if menu == 1:
            a = input("Input to queue: ")
            qq.enqueue(a)

        elif menu == 2:
            print(qq.dequeue(), 'Popped out from queue')

        elif menu == 3:
            qq.printQueue()
        
        elif menu == 4:
            print('>>> Thank you for using our program')
            print('>>> See You')
            break

        else:
            print('>>> Invalid Menu!')