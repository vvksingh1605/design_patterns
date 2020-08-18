package ObserverPattern

interface VotesObserver{
    fun onVoteRughanChange( data: ArrayList<VoteModel>)
}