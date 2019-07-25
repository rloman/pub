package nl.youngcapital.pub.api;

import nl.youngcapital.pub.model.Beer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/beers")
public class BeerController {


    private List<Beer> beers = new ArrayList<>();


    @GetMapping
    public List<Beer> findAll() {
        return this.beers;
    }

    @PostMapping
    public Beer create(@RequestBody Beer input) {

        this.beers.add(input);

        int size = this.beers.size();

        Beer lastBeer = this.beers.get(size - 1);

        lastBeer.setId(size);

        return lastBeer;
    }

    @GetMapping("{id}")
    public Beer findById(@PathVariable long id) {
        Beer result = this.beers.get((int) (id - 1));

        return result;
    }

    @GetMapping("name/{name}")
    public Beer findByName(@PathVariable String name) {
        return new Beer(); // for now
    }
}
