package pl.javastart.sellegro.auction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {

    List<Auction> findAllByOrderByPriceAsc();

    List<Auction> findAllByOrderByPriceDesc();

    List<Auction> findAllByOrderByTitleAsc();

    List<Auction> findAllByOrderByColorAsc();

    List<Auction> findAllByOrderByEndDateAsc();
}
