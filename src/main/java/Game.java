import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    //Регистрация
    public void register(Player player) {
        if (!players.contains(player)) {
            players.add(player);
        }
    }

    //Поиск игрока
    private Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    //Раунд
    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

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
        return new ArrayList<>(players);
    }
}
