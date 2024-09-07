package com.bibbi.domain.model

data class Mission(
    val id: String,
    val content: String
) {
    companion object {
        fun newMission(id: String, content: String): Mission {
            return Mission(id = id, content = content)
        }
    }

    fun updateContent(newContent: String): Mission {
        return this.copy(content = newContent)
    }
}
