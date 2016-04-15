from random import shuffle

def main(numCandidates, numVotes):
	indicesFilled = []
	votFile = open("testVote.vot", 'w')
	write = ""

	for vote in range(numVotes):
		voteString = ""
		voteList = [f + 1 for f in range(numCandidates)]
		shuffle(voteList)

		for i in voteList:
			voteString += str(i) + " "

		write += voteString + "\n"


	votFile.write(write[:-1])