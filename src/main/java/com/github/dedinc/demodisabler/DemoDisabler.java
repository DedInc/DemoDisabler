package com.github.dedinc.demodisabler;

import com.mojang.authlib.yggdrasil.YggdrasilSocialInteractionsService;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;

@Mod("demodisablermod")
public class DemoDisabler {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Minecraft mc = Minecraft.getInstance();
    private static boolean disabled = false;

    public DemoDisabler() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onInitGuiPost(GuiScreenEvent.InitGuiEvent.Post event) {
        if (disabled) return;

        if (event.getGui() instanceof MainMenuScreen) {
            disableDemoMode();
        }
    }

    private void disableDemoMode() {
        try {
            Field demoField = Minecraft.class.getDeclaredField("field_71459_aj");
            demoField.setAccessible(true);

            Field allowsMultiplayerField = Minecraft.class.getDeclaredField("field_238175_ae_");
            allowsMultiplayerField.setAccessible(true);

            Field allowsChatField = Minecraft.class.getDeclaredField("field_238176_af_");
            allowsChatField.setAccessible(true);

            demoField.setBoolean(mc, false);
            allowsMultiplayerField.setBoolean(mc, true);
            allowsChatField.setBoolean(mc, true);

            Field serviceField = Minecraft.class.getDeclaredField("field_244734_au");
            serviceField.setAccessible(true);
            YggdrasilSocialInteractionsService service = (YggdrasilSocialInteractionsService) serviceField.get(mc);

            Field serversAllowedField = YggdrasilSocialInteractionsService.class.getDeclaredField("serversAllowed");
            serversAllowedField.setAccessible(true);
            serversAllowedField.setBoolean(service, true);

            Field chatAllowedField = YggdrasilSocialInteractionsService.class.getDeclaredField("chatAllowed");
            chatAllowedField.setAccessible(true);
            chatAllowedField.setBoolean(service, true);

            LOGGER.info("Demo mode has been disabled.");
            disabled = true;

            mc.popGuiLayer();
            mc.setScreen(new MainMenuScreen());
        } catch (Exception e) {
            LOGGER.error("Failed to disable demo mode: ", e);
        }
    }
}