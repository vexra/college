class Vehicle:
    def __init__(self, description, priority):
        self.description = description
        self.priority = priority
 
    def __lt__(self, other):
        return self.priority < other.priority
 
    def __repr__(self):
        return f"Vehicle({self.description}, {self.priority})"
 
 
class HeapPriorityQueue:
    def __init__(self):
        self.data = []
 
    def __len__(self):
        return len(self.data)
 
    def is_empty(self):
        return len(self.data) == 0
 
    def parent(self, j):
        return (j - 1) // 2
 
    def left(self, j):
        return 2 * j + 1
 
    def right(self, j):
        return 2 * j + 2
 
    def has_left(self, j):
        return self.left(j) < len(self.data)
 
    def has_right(self, j):
        return self.right(j) < len(self.data)
 
    def swap(self, i, j):
        self.data[i], self.data[j] = self.data[j], self.data[i]
 
    def upheap(self, j):
        parent = self.parent(j)
        if j > 0 and self.data[j] < self.data[parent]:
            self.swap(j, parent)
            self.upheap(parent)
 
    def downheap(self, j):
        if self.has_left(j):
            left = self.left(j)
            small_child = left
            if self.has_right(j):
                right = self.right(j)
                if self.data[right] < self.data[left]:
                    small_child = right
            if self.data[small_child] < self.data[j]:
                self.swap(j, small_child)
                self.downheap(small_child)
 
    def add(self, item):
        self.data.append(item)
        self.upheap(len(self.data) - 1)
 
    def remove_min(self):
        if self.is_empty():
            raise IndexError("Priority queue is empty.")
        self.swap(0, len(self.data) - 1)
        min_item = self.data.pop()
        self.downheap(0)
        return min_item
 
 
# Example usage
queue = HeapPriorityQueue()

queue.add(Vehicle("Ambulance", 2))
queue.add(Vehicle("Fireman", 1))
queue.add(Vehicle("Police", 3))
queue.add(Vehicle("Goverment", 4))
queue.add(Vehicle("Taxi", 5))
 
while not queue.is_empty():
    vehicle = queue.remove_min()
    print(f"Processing vehicle: {vehicle}")