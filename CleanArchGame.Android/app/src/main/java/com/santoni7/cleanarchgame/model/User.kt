package com.santoni7.cleanarchgame.model

class User(
    val id: Int,
    val name: String,
    val gamesRecord: UserStatistics?,
    val isAnonymous: Boolean // For second local player
) {

    override fun equals(other: Any?): Boolean =
        other is User && other.id == id && other.gamesRecord == gamesRecord && other.isAnonymous == isAnonymous

    override fun hashCode(): Int {
        return id.hashCode() xor gamesRecord.hashCode() xor isAnonymous.hashCode()
    }

    override fun toString(): String {
        return "User(id=$id, gamesRecord=$gamesRecord)"
    }

    companion object {
        const val ANONYMOUS_USER_ID = -1
        const val ANONYMOUS_USER_NAME = "ANONYMOUS"
        fun makeAnonymous(): User = User(ANONYMOUS_USER_ID, ANONYMOUS_USER_NAME, null, true)
    }
}