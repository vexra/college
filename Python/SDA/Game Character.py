class Entity:
    def __init__(self, name, HP):
        self.name = name
        self.healthPoint = HP
 
    def __str__(self):
        return f'\tName\t\t: {self.name}\n\tHealth Point\t: {self.healthPoint}\n\t'
 
 
#Class Hero adalah sebuah class untuk hero yang bisa dimainkan oleh user
class Hero(Entity):
    def __init__(self, name, HP, heroType, basicAttack, passiveAttack, mana, level,
                 attackRange, attackSpeed, emblem):
        super().__init__(name, HP)
 
        self.isPlayable = True
        self.maxItem = 10
        self.heroType = heroType
        self.basicAttack = basicAttack
        self.passiveAttack = passiveAttack
        self.mana = mana
        self.level = level
        self.attackRange = attackRange
        self.attackSpeed = attackSpeed
        self.emblem = emblem
 
    def __str__(self):
        return """
        Name: {0.name}
        Health Point: {0.healthPoint}
        Is playable: {0.isPlayable}
        Maximum of Item: {0.maxItem}
        Type of hero: {0.heroType}
        Basic attack: {0.basicAttack}
        Passive attack: {0.passiveAttack}
        Mana: {0.mana}
        Level: {0.level}
        Attack range: {0.attackRange}
        Attack Speed: {0.attackSpeed}
        Emblem: {0.emblem}
        """.format(self)
 
 
#Class Non Playable Character adalah sebuah class yang digunakan untuk NPC seperti LORD dan Minion
class NPC(Entity):
    def __init__(self, name, HP, basicAttack, passiveAttack, level):
        super().__init__(name, HP)
 
        self.isPlayable = False
        self.basicAttack = basicAttack
        self.passiveAttack = passiveAttack
        self.level = level
 
    def __str__(self):
        return """
        Name: {0.name}
        Health Point: {0.healthPoint}
        Is playable = {0.isPlayable}
        Basic attack = {0.basicAttack}
        Passive attack = {0.passiveAttack}
        level = {0.level}
        """.format(self)
 
def printMenu():
    print("\nMenu\n1. Tambah Hero\n2. Tambah NPC\n3. Hapus Hero\n4. Hapus NPC\n5. Display Heroes\n6. Display NPC\n7. Exit Program")
 
if __name__ == "__main__":
    list_of_hero = []
    list_of_npc = []
 
    while True:
        printMenu()
        menu = int(input("\nMasukan Menu: "))
 
        if menu == 1:
            print("\n>>> Create New Hero")
            name = str(input("Name: "))
            hp = int(input("HP: "))
            heroType = str(input("heroType: "))
            basicAttack = str(input("basicAttack: "))
            passiveAttack = str(input("passiveAttack: "))
            mana = str(input("mana: "))
            level = str(input("level: "))
            attackRange = str(input("attackRange: "))
            attackSpeed = str(input("attackSpeed: "))
            emblem = str(input("emblem: "))
            print("")
 
            newHero = Hero(name, hp, heroType, basicAttack, passiveAttack, mana, level, attackRange, attackSpeed, emblem)
 
            list_of_hero.append(newHero)
 
        elif menu == 2:
            print("\n>>> Create New NPC")
            name = str(input("Name: "))
            hp = int(input("HP: "))
            basicAttack = int(input("basicAttack: "))
            passiveAttack = int(input("passiveAttack: "))
            level = int(input("level: "))
            print("")
 
            newNPC = NPC(name, hp, basicAttack, passiveAttack, level)
 
            list_of_npc.append(newNPC)
 
        elif menu == 3:
            heroName = str(input("\nMasukan nama hero yang ingin dihapus: "))
            found = False
 
            for i in range(len(list_of_hero)):
                if list_of_hero[i].name == heroName:
                    del list_of_hero[i]
                    found = True
                    break
 
            if found == True:
                print(f">> Hero {heroName} successfully deleted")
 
            else:
                print(f">>> Hero {heroName} Not Found")
 
        elif menu == 4:
            NPCName = str(input("\nMasukan nama NPC yang ingin dihapus: "))
            found = False
 
            for i in range(len(list_of_npc)):
                if list_of_npc[i].name == NPCName:
                    del list_of_npc[i]
                    found = True
                    break
 
            if found == True:
                print(f">>> NPC {NPCName} successfully deleted")
 
            else:
                print(f">>> NPC {NPCName} Not Found")

        elif menu == 5:
            print("\nList of Hero:")

            if len(list_of_hero) == 0:
                print(">>> There is no hero available!")

            else:
                for i in range(len(list_of_hero)):
                    hero = list_of_hero[i]
                    print(f"Hero {i+1}:")
                    print(hero)

        elif menu == 6:
            print("\nList of NPC:")

            if len(list_of_npc) == 0:
                print(">>> There is no NPC available!")

            else:
                for i in range(len(list_of_npc)):
                    npc = list_of_npc[i]
                    print(f"NPC {i+1}:")
                    print(npc)
 
        elif menu == 7:
            print("\nThank you for using our program")
            print("\t>>> See you <<<")
            break 
 
        else:
            print(">>> Menu tidak tersedia!")
            print(">>> Silakan coba lagi")
 
