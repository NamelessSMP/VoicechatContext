package ru.thecatrix.voicechatcontext;

import net.luckperms.api.context.ContextCalculator;
import net.luckperms.api.context.ContextConsumer;
import net.luckperms.api.context.ContextSet;
import net.luckperms.api.context.ImmutableContextSet;

import org.bukkit.entity.Player;

public class LuckpermsContextPlugin implements ContextCalculator<Player> {
    private static final String KEY = "voicechat";

    @Override
    public void calculate(Player target, ContextConsumer contextConsumer) {
        contextConsumer.accept(KEY, String.valueOf(VoicechatContext.playerVoicechat.get(target.getUniqueId())));
    }

    @Override
    public ContextSet estimatePotentialContexts() {
        return ImmutableContextSet.builder()
                .add(KEY, "true")
                .add(KEY, "false")
                .build();
    }
}
