package com.bibbi.infrastructure.jpa.entity

import com.bibbi.domain.model.Mission
import jakarta.persistence.*
import lombok.*

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Getter
@Entity(name = "mission")
@Table(indexes = [
    Index(name = "mission_idx", columnList = "mission_id")
])
class MissionEntity private constructor(
    @Id
    @Column(name = "mission_id", columnDefinition = "CHAR(26)", nullable = false)
    val id: String,

    @Column(name = "content", nullable = false)
    var content: String
) : BaseEntity() {

    fun toDomain() = Mission(
        id = id,
        content = content
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MissionEntity

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    companion object {
        fun fromDomain(mission: Mission) = with(mission) {
            MissionEntity(
                id = id,
                content = content
            )
        }
    }
}
