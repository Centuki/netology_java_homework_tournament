import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Map<String, Player> players = new HashMap<>();

    //Регистрация
    public void register(Player player) {
        players.put(player.getName(), player);
    }

    //Поиск игрока
    public Player getPlayerByName(String name) {
        return players.get(name);
    }

    //Раунд
    public int round(String playerName1, String playerName2) {
        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);

        //Проверка регистрации
        if (player1 == null) {
            throw new NotRegisteredException("Игрок +" + playerName1 + "не зарегистрирован");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок +" + playerName2 + "не зарегистрирован");
        }

        //Победитель
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }

    //Метод получения списка игроков
    public List<Player> getPlayers() {
        return new ArrayList<>(players.values());
    }
}
