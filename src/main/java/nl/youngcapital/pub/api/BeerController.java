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

        input.setId(this.beers.size());

        return this.beers.get(this.beers.size()-1);
    }
}
