package net.online.animelist.controller;

import lombok.extern.slf4j.Slf4j;
import net.online.animelist.model.Anime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
public class ListContoller {

    public List<Anime> animes = Arrays.asList(
            new Anime("One Piece", 1000, Anime.Genre.ADVENTURE, Anime.Status.ONGOING, LocalDate.now()),
            new Anime("Naruto", 700, Anime.Genre.ACTION, Anime.Status.FINISHED, LocalDate.now()),
            new Anime("Demon slayer", 100, Anime.Genre.ADVENTURE, Anime.Status.TO_WATCH, LocalDate.now()),
            new Anime("Your lie in april", 50, Anime.Genre.ROMANCE, Anime.Status.FINISHED, LocalDate.now()),
            new Anime("Steins:Gate", 25, Anime.Genre.SCI_FI, Anime.Status.FINISHED, LocalDate.now())
    );

    public List<Anime> animesMultable = new ArrayList<>(animes);

    @GetMapping("/list")
    public String addDataToView(Model model) {
        model.addAttribute("animes", animes);
        model.addAttribute("anime", new Anime());
        model.addAttribute("genres", Anime.Genre.values());
        model.addAttribute("statuses", Anime.Status.values());
        return "list";
    }

    @PostMapping("/processInputData")
    public String processInputData(@ModelAttribute Anime anime) {
        System.out.println(anime.toString());
        log.info("Anime inserido {}", anime.toString());
        anime.setCreatedAt(LocalDate.now());
        animesMultable.add(anime);
        animes = animesMultable;
        return "redirect:/list";
    }
}
