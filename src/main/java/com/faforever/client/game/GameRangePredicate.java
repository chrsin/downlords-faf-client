package com.faforever.client.game;

import com.faforever.client.player.Player;
import com.faforever.client.util.RatingUtil;

import java.util.Optional;
import java.util.function.Predicate;

public class GameRangePredicate implements Predicate<Game> {
  private final Optional<Player> player;

  public GameRangePredicate(Optional<Player> player) {
    this.player = player;
  }

  @Override
  public boolean test(Game game) {
    if(!player.isPresent())
      return true;

    float rating = RatingUtil.getGlobalRating(player.get());
    return game.getMaxRating() >= rating && game.getMinRating() <= rating;
  }
}