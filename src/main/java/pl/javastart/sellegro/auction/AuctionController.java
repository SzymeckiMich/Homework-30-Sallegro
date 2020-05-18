package pl.javastart.sellegro.auction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AuctionController {

    private AuctionService auctionService;

    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping("/auctions")
    public String auctions(Model model,
                           @RequestParam(required = false) String sort,
                           AuctionFilters auctionFilters) {
        List<Auction> auctions;
        if (sort != null) {
            auctions = auctionService.findAllSorted(sort);
        } else {
            auctions = auctionService.findAllForFilters(auctionFilters);
        }

        model.addAttribute("cars", auctions);
        model.addAttribute("filters", auctionFilters);
        return "auctions";
    }
}
