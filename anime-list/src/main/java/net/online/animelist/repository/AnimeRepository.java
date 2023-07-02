package net.online.animelist.repository;

import net.online.animelist.model.Anime;
import net.online.animelist.model.Anime.Genre;
import net.online.animelist.model.Anime.Status;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Repository
public class AnimeRepository {
    public List<Anime> animes = Arrays.asList(
            new Anime("One Piece", 1000, Genre.ADVENTURE, Status.ONGOING, LocalDate.now()),
            new Anime("Naruto", 700, Genre.ACTION, Status.FINISHED, LocalDate.now()),
            new Anime("Demon slayer", 100, Genre.ADVENTURE, Status.TO_WATCH, LocalDate.now()),
            new Anime("Your lie in april", 50, Genre.ROMANCE, Status.FINISHED, LocalDate.now()),
            new Anime("Steins:Gate", 25, Genre.SCI_FI, Status.FINISHED, LocalDate.now())
    );

    public List<Anime> list() {
        return animes;
    }
}
