class Node:
    __slots__ = ("_element", "_next", "_previous")

    def __init__(self, element, next = None, prev = None):
        self._element = element
        self._next = next
        self._previous = prev

class DoublyLinkedList:
    __slots__ = ("_size", "_head", "_tail")

    def __init__(self):
        self._size = 0
        self._head = None
        self._tail = None

    def __len__(self):
        return self._size
    
    def insert(self, element):
        newNode = Node(element)
        self._size += 1

        if self._head is None:
            self._head = newNode
        else:
            current = self._head
            while current._next:
                current = current._next
            
            current._next = newNode
            newNode._previous = current

    def top(self):
        if self._head is None:
            raise IndexError("Top from empty list")
        return self._head._element
    
    def display(self):
        current = self._head

        while current:
            print("{name}, {grade}".format(name = current._element._name, grade = current._element._grade))
            current = current._next

class Student:
    __slots__ = ("_name", "_grade")

    def __init__(self, name, grade):
        self._name = name
        self._grade = grade

    def __repr__(self):
        return "{name}, {grade}".format(name=self._name, grade=self._grade)


database = DoublyLinkedList()

database.insert(Student("Febri", 99))
database.insert(Student("Veda", 99))
database.insert(Student("Naura", 99))

database.display()