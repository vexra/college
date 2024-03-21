#KELOMPOK 4
# 2217051004 Cakrawangsa Veda Alkautsar
# 2217051019 Muhammad Febri Ardiyan Saputra
# 2217051110 Muhammad Fahreza Yusuf
#
# Tema      : Karakter Game
# Deskripsi : Program yang membuat dasar dari karakter game seperti Health Point, Name, Attack Speed, dan sebagainya
#             Progam yang dibuat hanya untuk dasar dan bukan membuat karakter sesungguhnya
# Copyright : All Rights Reserved


#Class Entity adalah untuk semua unit dalam game yang bernyawa
class Entity:
    def __init__(self, name, HP):
        self.name = name
        self.healtPoint = HP

    def __str__(self):
        return f'Name = {self.name}\n\tHealt Point\t\t: {self.healtPoint}\n\tDamage Per Second\t\t: {self.damagePerSecond}'


#Class Hero adalah sebuah class untuk hero yang bisa dimainkan oleh user
class Hero(Entity):
    def __init__(self, name, HP, heroType, basicAttack, passiveAttack, skill1, skill2, skill3, mana, level,
                 attackRange, attackSpeed, emblem):
        super().__init__(name, HP)

        self.isPlayable = True
        self.maxItem = 8
        self.heroType = heroType
        self.basicAttack = basicAttack
        self.passiveAttack = passiveAttack
        self.skill1 = skill1
        self.skill2 = skill2
        self.skill3 = skill3
        self.mana = mana
        self.level = level
        self.attackRange = attackRange
        self.attackSpeed = attackSpeed
        self.emblem = emblem

    def __str__(self):
        return """
        Is playable\t\t: {0.isPlayable}\n\t
        Maximum of Item\t\t: {0.maxItem}\n\t
        Type of hero\t\t: {0.heroType}\n\t
        Basic attack\t\t: {0.basicAttack}\n\t
        Passive attack\t\t: {0.passiveAttack}\n\t
        Skill 1\t\t: {0.skill1}\n\t
        Skill 2\t\t: {0.skill2}\n\t
        Skill 3\t\t: {0.skill3}\n\t
        Mana\t\t: {0.mana}\n\t
        Level\t\t: {0.level}\n\t
        Attack range\t\t: {0.attackRange}\n\t
        Attack Speed\t\t: {0.attackSpeed}\n\t
        Emblem\t\t: {0.emblem}\n\t
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
        Is playable\t\t: {0.isPlayable}\n\t
        Basic attack\t\t: {0.basicAttack}\n\t
        Passive attack\t\t: {0.passiveAttack}\n\t
        level\t\t: {0.level}\n\t
        """.format(self)

def __main__():
    print('heelo world')

__main__()