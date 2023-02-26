package ru.thecatrix.voicechatcontext;

import de.maxhenkel.voicechat.api.VoicechatApi;
import de.maxhenkel.voicechat.api.VoicechatPlugin;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import de.maxhenkel.voicechat.api.events.PlayerConnectedEvent;
import de.maxhenkel.voicechat.api.events.PlayerDisconnectedEvent;

public class VoicechatApiPlugin implements VoicechatPlugin {

    @Override
    public String getPluginId() {
        return "voicechatcontext";
    }

    @Override
    public void initialize(VoicechatApi api) {

    }

    @Override
    public void registerEvents(EventRegistration registration) {
        registration.registerEvent(PlayerConnectedEvent.class, this::onPlayerConnected);
        registration.registerEvent(PlayerDisconnectedEvent.class, this::onPlayerDisconnected);
    }

    public void onPlayerConnected(PlayerConnectedEvent event) {
        VoicechatContext.playerVoicechat.put(event.getConnection().getPlayer().getUuid(), true);
    }

    public void onPlayerDisconnected(PlayerDisconnectedEvent event) {
        VoicechatContext.playerVoicechat.put(event.getPlayerUuid(), false);
    }
}
