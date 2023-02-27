package ru.thecatrix.voicechatcontext;

import net.luckperms.api.context.ContextCalculator;
import net.luckperms.api.context.ContextConsumer;
import net.luckperms.api.context.ContextSet;
import net.luckperms.api.context.ImmutableContextSet;
import org.bukkit.entity.Player;

public class LuckpermsContextPlugin implements ContextCalculator<Player> {
    @Override
    public void calculate(Player target, ContextConsumer contextConsumer) {
        contextConsumer.accept("voicechat", String.valueOf(VoicechatContext.playerVoicechat.get(target.getUniqueId())));
    }

    String[] Voicechat = {"true", "false"};

    @Override
    public ContextSet estimatePotentialContexts() {
        ImmutableContextSet.Builder builder = ImmutableContextSet.builder();
        for (String Voicechat : Voicechat) {
            builder.add("voicechat", Voicechat);
        }
        return builder.build();
    }
}
