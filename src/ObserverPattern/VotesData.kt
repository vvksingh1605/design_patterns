package ObserverPattern

class VotesData:VoteSubscription {
    var votedata= ArrayList<VoteModel>()
    val observerList=ArrayList<VotesObserver>();
    override fun register(votesObserver: VotesObserver) {
        observerList.add(votesObserver)
    }

    override fun unregister(votesObserver: VotesObserver) {
        observerList.remove(votesObserver);
    }

    override fun notifyObservers() {
        for(observ in observerList){
            observ.onVoteRughanChange(votedata)
        }
    }
// this will be called when data updates
    fun onVotesChanged( votesMap:ArrayList<VoteModel>){
        votedata=votesMap
        notifyObservers()


    }


}