package com.bibbi.domain.model

data class Mission(
    val id: String,
    var content: String
) {
    companion object {
        fun newMission(id: String, content: String): Mission {
            return Mission(id = id, content = content)
        }
    }

    fun updateContent(newContent: String) {
        this.content = newContent
    }
}
