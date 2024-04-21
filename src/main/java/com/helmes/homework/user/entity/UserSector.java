package com.helmes.homework.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_sector")
public class UserSector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSectorId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ElementCollection
    @CollectionTable(name = "user_sector_sectors", joinColumns = @JoinColumn(name = "user_sector_id"))
    @Column(name = "sector_id")
    private HashSet<Integer> sectorIds;
}
