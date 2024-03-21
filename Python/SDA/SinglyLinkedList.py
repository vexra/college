class Node:
    def __init__(self, data=None):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    def is_empty(self):
        return not bool(self.head)

    def add_front(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node

    def add_rear(self, data):
        if not self.head:
            self.add_front(data)
            return
        
        curr_node = self.head
        while curr_node.next:
            curr_node = curr_node.next
        
        new_node = Node(data)
        
        curr_node.next = new_node
    
    def remove_front(self):
         if not bool(self.is_empty()):
             first_element_data=self.head.data 
             next_element=self.head.next 
             
             delattr(self,'head') # to completely delete the attribute head from the object.
           
             setattr (self,'head',next_element) # set the second element as head of linked list. 
            
             return first_element_data


    def remove_rear(elf):    
          '''Removes and returns value of last element'''
          
          pass