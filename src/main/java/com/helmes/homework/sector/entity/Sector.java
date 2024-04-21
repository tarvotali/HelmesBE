package com.helmes.homework.sector.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sectors")
@SecondaryTable(name = "sector_table", pkJoinColumns = @PrimaryKeyJoinColumn(name = "sector_id"))
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(table = "sector_table", name = "sector_name")
    private String sectorName;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Sector parentSector;

    @OneToMany(mappedBy = "parentSector", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("parentSector")
    private List<Sector> subSectors;

    public Sector(int id) {
        this.id = (long) id;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", sectorName='" + sectorName + '\'' +
                '}';
    }

}
