package ru.thecatrix.voicechatcontext;

import net.luckperms.api.context.ContextCalculator;
import net.luckperms.api.context.ContextConsumer;
import org.bukkit.entity.Player;

public class LuckpermsContextPlugin implements ContextCalculator<Player> {
    @Override
    public void calculate(Player target, ContextConsumer contextConsumer) {
        contextConsumer.accept("voicechat", String.valueOf(VoicechatContext.playerVoicechat.get(target.getUniqueId())));
    }
}
