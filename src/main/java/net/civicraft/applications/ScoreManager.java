package net.civicraft.applications;

import org.bukkit.entity.Player;

//note to self: instead of strict being a boolean maybe make it to where there are either modes or score thresholds. and/or add strict as an additional param on reqs
public class ScoreManager {
    private Applications instance = Applications.getInstance();
    //integrate with civicore to access data about player behavior on server
    public int judge(Application app) {
        int playtime = playtimeScore(app.getPlayer());
        int warnings = warningScore(app.getPlayer());

        return playtime + warnings;
    }

    private int playtimeScore(Player player) {
        int hours = 44;
        int requirement = instance.getConfig().getInt("requirements.playtime");
        boolean strict = instance.getConfig().getBoolean("strict");

        if (strict && hours >= requirement) {
            return 3;
        } else {
            if (requirement == 0 || hours >= requirement) {
                return 3;
            } else if (hours < requirement * 0.33) {
                return 0;
            } else if (hours < requirement * 0.66) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    private int warningScore(Player player) {
        int warnings = 0;//considers all warnings, active and expired. prolly gonna change
        int requirement = instance.getConfig().getInt("requirements.warnings");
        if (warnings == 0 || warnings <= requirement) {
            return 3;
        }

        return 0;//placeholder until i come back
    }
}
