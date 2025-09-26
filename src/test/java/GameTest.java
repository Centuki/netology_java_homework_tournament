import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GameTest {
    @Test
    public void shouldWinFirstBetweenTwoPlayers() {
        Game tournament = new Game();

        Player player1 = new Player(1, "Иван", 90);
        Player player2 = new Player(2, "Петр", 85);

        tournament.register(player1);
        tournament.register(player2);

        int actual = tournament.round("Иван", "Петр");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondBetweenTwoPlayers() {
        Game tournament = new Game();

        Player player1 = new Player(1, "Иван", 85);
        Player player2 = new Player(2, "Петр", 90);

        tournament.register(player1);
        tournament.register(player2);

        int actual = tournament.round("Иван", "Петр");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeDrawBetweenTwoPlayers() {
        Game tournament = new Game();

        Player player1 = new Player(1, "Иван", 85);
        Player player2 = new Player(2, "Петр", 85);

        tournament.register(player1);
        tournament.register(player2);

        int actual = tournament.round("Иван", "Петр");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindSecondPlayerByName() {
        Game tournament = new Game();

        Player player1 = new Player(1, "Иван", 85);
        Player player2 = new Player(2, "Петр", 90);

        tournament.register(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            tournament.round("Иван", "Петр");
        });
    }

    @Test
    public void shouldNotFindFirstPlayerByName() {
        Game tournament = new Game();

        Player player1 = new Player(1, "Иван", 85);
        Player player2 = new Player(2, "Петр", 90);

        tournament.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            tournament.round("Иван", "Петр");
        });
    }

    @Test
    public void shouldReturnAllPlayers() {
        Game tournament = new Game();

        Player player1 = new Player(1, "Иван", 85);
        Player player2 = new Player(2, "Петр", 90);
        Player player3 = new Player(3, "Александр", 30);
        Player player4 = new Player(4, "Степан", 50);
        Player player5 = new Player(5, "Мария", 70);

        tournament.register(player1);
        tournament.register(player2);
        tournament.register(player3);
        tournament.register(player4);
        tournament.register(player5);

        List<Player> expected = Arrays.asList(player1, player2, player3, player4, player5);
        List<Player> actual = tournament.getPlayers();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRegisterPlayerSecondTime() {
        Game tournament = new Game();

        Player player1 = new Player(1, "Иван", 85);

        tournament.register(player1);
        tournament.register(player1);

        List<Player> expected = Arrays.asList(player1);
        List<Player> actual = tournament.getPlayers();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetPlayerId() {
        Player player1 = new Player(1, "Иван", 85);

        int actual = player1.getId();
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }
}
