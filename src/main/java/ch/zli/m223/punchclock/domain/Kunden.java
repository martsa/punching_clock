package ch.zli.m223.punchclock.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Kunden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "kunden")
    private Set<Entry> entries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Set<Entry> getEntry() {
        return entries;
    }
    @JsonIgnore
    public void setEntry(Set<Entry> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        String result = String.format("Kunden[id=%d,name='%s']%n", id, name);


        return result;
    }
}

