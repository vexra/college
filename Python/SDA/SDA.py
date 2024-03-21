class _Node:
    __slots__ = ("_element", "_next")

    def __init__(self, element, next = None):
        self._element = element
        self._next = next

class SinglyLinkedList:
    __slots__ = ("_size", "_head")

    def __init__(self):
        self._size = 0
        self._head = None

    def __len__(self):
        return self._size

    def push(self, element):
        self._head = _Node(element, self._head)
        self._size += 1

    def top(self):
        if self._head is None:
            raise IndexError("top from empty list")
        return self._head._element

    def pop(self):
        if self._head is None:
            raise IndexError("pop from empty list")

        answer = self._head._element
        self._head = self._head._next
        self._size -= 1

        return answer

class Angkutan:
    __slots__ = ("_nama", "_berat")

    def __init__(self, nama, berat):
        self._nama = nama
        self._berat = berat

    def __repr__(self):
        return "{nama}, {berat} kg".format(nama=self._nama, berat=self._berat)


kereta = SinglyLinkedList()

kereta.push(Angkutan("Baju", 500))
kereta.push(Angkutan("Batubara", 10000))
kereta.push(Angkutan("Kertas", 5000))

for i in range(len(kereta)):
    print(kereta.pop())

