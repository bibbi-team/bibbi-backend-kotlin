package com.bibbi.domain.model

import java.time.LocalDate
import java.time.LocalDateTime


data class Member (
    val id : String,
    var familyId : String,
    var dayOfBirth : LocalDate,
    var name : String,
    var profileImageUrl : String?,
    var profileImgKey : String?,
    var familyJoinAt : LocalDateTime?,
    var deletedAt : LocalDateTime?,
) {

    fun updateProfileImg(profileImageUrl: String, profileImgKey: String) {
        this.profileImageUrl = profileImageUrl
        this.profileImgKey = profileImgKey
    }

    fun deleteProfileImg() {
        this.profileImageUrl = null
        this.profileImgKey = null
    }

    fun updateName(name: String) {
        this.name = name
    }

    fun deleteMember() {
        this.name = DELETED_MEMBER_NAME
        this.profileImageUrl = null
        this.profileImgKey = null

        this.deletedAt = LocalDateTime.now()
    }

    companion object {
        const val DELETED_MEMBER_NAME = "DeletedMember"
    }
}
