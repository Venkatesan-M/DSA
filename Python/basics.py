class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age
    def greet(self):
        print(f"Hello, my Name is {self.name} and I'm {self.age} year old!")

class Dog:
    def __init__(self, name, breed, owner):
        self.name = name
        self.breed = breed
        self.owner = owner

    def bark(self):
        print("Whoof Whoof!")


class Owner:
    def __init__(self, name, addr, contact):
        self.name = name
        self.addr = addr
        self.contact = contact
    
owner = Owner("Venkatesan", "China", "6374900460")

dog = Dog("Lee", "David", owner)

dog.bark()
print(dog.name)
print(dog.owner.addr)


person = Person("Venkatesan", 29)
person.greet()