package ObserverPattern

fun main() {

    val votesCountDisplayObserver = votesCountDisplay()
    val winnerDisplay = WinnerDisplay()
    val votesData = VotesData()
    votesData.register(votesCountDisplayObserver)
    votesData.register(winnerDisplay)

    // change data by mocking
    val data1 = VoteModel("Modi", 20000)
    val data2 = VoteModel("arvindKejriwal", 40000)
    votesData.onVotesChanged(ArrayList<VoteModel>().apply { add(data1) }.apply { add(data2) })
//

    votesData.unregister(votesCountDisplayObserver)
    votesData.unregister(winnerDisplay)


}


// observing the vote count and unaware of the vote counter
class votesCountDisplay : VotesObserver {
    override fun onVoteRughanChange(data: ArrayList<VoteModel>) {
        displayData(data)
    }


    private fun displayData(data: ArrayList<VoteModel>) {
        data.forEach {
            print("votes counts of ${it.politicainName} is " + it.voteCount + "\n")

        }


    }

}


// observing the vote count and unaware of the vote counter
class WinnerDisplay : VotesObserver {
    override fun onVoteRughanChange(data: ArrayList<VoteModel>) {
        val winner = getWinnerName(data)
        print("And current winner is " + winner)
    }

    private fun getWinnerName(data: ArrayList<VoteModel>): String {
        if (data.isEmpty()) return "No data available"
        var winner = data[0]
        data.forEach {
            if (it.voteCount > winner.voteCount) {
                winner = it
            }

        }
        return winner.politicainName

    }


}