class Node:
    def __init__(self, data=None):
        self.data = data
        self.next = None
        self.prev = None

class DoublyLinkedList:
    def __init__(self):
        self.head = None

    def is_empty(self):
        return not bool(self.head)

    def add_front(self, data):
        new_node = Node(data)
        
        if not bool(self.is_empty()):
            new_node.next=self.head 
            setattr(new_node,'prev',None) # set the previous node to none
        
            setattr (self.head,'prev',new_node) #set the current head prev attribute to newly created node.