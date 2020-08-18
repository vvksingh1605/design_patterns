package ObserverPattern

interface VoteSubscription {
    fun register(votesObserver: VotesObserver)
    fun unregister(votesObserver: VotesObserver)
    fun notifyObservers()
}