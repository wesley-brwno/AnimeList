package net.online.animelist.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Anime {
    private String name;
    private int episodes;
    private Genre genre;
    private Status status;
    private LocalDate createdAt;

    public Anime() {
    }

    public Anime(String name, int episodes, Genre genre, Status status, LocalDate createdAt) {
        this.name = name;
        this.episodes = episodes;
        this.genre = genre;
        this.status = status;
        this.createdAt = createdAt;
    }

    public enum Genre {
        ACTION, ADVENTURE, HORROR, ROMANCE, SCI_FI, SLICE_OF_lIFE
    }

    public enum Status {
        FINISHED, ONGOING, TO_WATCH
    }
}

