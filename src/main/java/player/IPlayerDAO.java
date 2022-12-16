package player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public interface IPlayerDAO {
    public ArrayList<Player> findAll();
    public Player findBest3pts();
    public List<Player> findBy(Predicate<Player> filter);
    public Player findById(String id);
    public void addPlayer(Player player);
    public Boolean deletePlayerByID(String id);
    public Boolean updatePlayerByID(String id, Player play);
}
