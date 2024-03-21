class Node:
  def __init__(self, element, parent, child):
    self._element = element
    self._parent = parent
    self._child = child

  def __eq__(self, other):
    return self.parent() == other.parent() and self.child() == other.child() and self.element() == other.element()

  def __repr__(self):
    return str(self.element())

  def parent(self):
    return self._parent

  def child(self):
    return self._child

  def element(self):
    return self._element

  def num_child(self):
    return len(self.child())


class OrganizationTree: 

  def __init__(self):
    self._root = None
    self._size = 0

  def __len__(self):
    return self._size

  def root(self):
    return self._root

  def is_root(self, node):
    return node.parent() == None

  def is_leaf(self, node):
    return node.child() == []

  def add_person(self, person, parent = None): 
    new_person = Node(person, parent, [])
    
    if self.root() is None:
      self._root = new_person
    else:
      parent.child().append(new_person) 
    
    self._size += 1
    return new_person


organization_tree = OrganizationTree()
Ceo = organization_tree.add_person("Ceo")
Gm = organization_tree.add_person("General Manager", Ceo)
Manager = organization_tree.add_person("Manager", Gm)
Employee = organization_tree.add_person("Employee", Manager)

print(Ceo.element()) 
print(Gm.element()) 
print(Manager.element())
print(Employee.element())

print(Ceo.parent()) 
print(Gm.parent()) 
print(Manager.parent())
print(Employee.parent())

print(Ceo.child())
print(Ceo.num_child())
print(organization_tree.is_root(Ceo))