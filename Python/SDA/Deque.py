class Deque:
    def __init__(self):
        self.items = []

    def is_empty(self):
        return not bool(self.items)

    def add_front(self, data):
        self.items.insert(0, data)

    def add_rear(self, data):
        self.items.append(data)

    def remove_front(self):
        if self.is_empty():
            return None
        else:
            return self.items.pop(0)

    def remove_rear(self):
        if self.is_empty():
            return None
        else:
            return self.items.pop()

    def size(self):
        return len(self.items)