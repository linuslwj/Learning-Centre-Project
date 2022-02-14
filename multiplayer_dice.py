from random import randint

def getPlayers():
    players = {}
    while True:
        name = input('Enter name: ') .capitalize()
        if name == '': break
        players[name] =  {'won': 0, 'guess': 0}
    return players

def rollDice():
    return randint(1, 6)

def playGuessingGame(players, diceValue):
    for tries in range(1,4):
        for k, v in players.items():
            v['guess'] = getPlayerGuess(k, tries)   
        if checkGuess(players, diceValue):
            break
    else:   
        print("Sorry, value is {}".format(diceValue))

def printScoreSummary(players):
    for k, v in players.items():
        print("{} won {} game{}".format(k, v['won'], '' if v['won'] <2 else 's'))

def getPlayerGuess(name, tries):
    return int(input("Try {}. {}, enter guess: ".format(tries, name)))

def checkGuess(players, diceValue):
    correct = False
    for k, v in players.items():
        if diceValue == v['guess']:
            print("{}, you got it!".format(k))
            v['won'] += 1
            correct = True
        else: print("{},incorrect".format(k))
    return correct


def main():
    players = getPlayers()
    playAgain = 'y'
    while playAgain[0].lower() in 'yY':
        diceValue = rollDice()
        playGuessingGame(players, diceValue)
        printScoreSummary(players)
        playAgain = input("Continue? y/n: ")
    print("End game")

main()