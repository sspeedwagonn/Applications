package net.civicraft.applications;

import org.bukkit.entity.Player;

public class Application {
    private Player player;
    private final int score;

    public Application(Player player, ScoreManager sm) {
        this.player = player;
        this.score = sm.judge(this);
    }

    public int getScore() {
        return score;
    }


    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
}
