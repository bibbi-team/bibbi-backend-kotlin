package com.bibbi.domain.model

enum class MemberQuitReasonType (
    val description: String
) {

    NO_NEED_TO_SHARE_DAILY("가족과 일상을 공유하고 싶지 않아서"),
    FAMILY_MEMBER_NOT_USING("가족 구성원이 참여하지 않아서"),
    NO_PREFER_WIDGET_OR_NOTIFICATION("위젯이나 알림 기능을 선호하지 않아서"),
    SERVICE_UX_IS_BAD("서비스 이용이 어렵거나 불편해서"),
    NO_FREQUENTLY_USE("자주 사용하지 않아서");
}