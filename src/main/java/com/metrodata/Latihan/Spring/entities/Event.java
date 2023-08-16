package com.metrodata.Latihan.Spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_m_events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 100, nullable = false)
    private String location;

    @Column(name = "start_date_time", nullable = false)
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time", nullable = false)
    private LocalDateTime endDateTime;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Sponsor> sponsors;

    @ManyToMany(mappedBy = "events")
    private List<Participant> participants;
}
