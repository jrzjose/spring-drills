package org.springmix.webapp.data.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="ROOMS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="ROOM_ID")
    private UUID roomId;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="NUMBER")
    private String number;
    
    @Column(name="BED_INFO")
    private String bedInfo;
}
