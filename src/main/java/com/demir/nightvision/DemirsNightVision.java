package com.demir.nightvision;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

/**
 * Demir's Night Vision Mod
 * 
 * A simple Fabric mod that toggles Night Vision effect with the N key.
 * The keybind is configurable through Minecraft's Controls menu.
 */
public class DemirsNightVision implements ClientModInitializer {
    
    // Mod identifier
    public static final String MOD_ID = "nightvisiondemir";
    
    // Keybinding for toggling night vision
    private static KeyBinding nightVisionKey;
    
    // Track whether night vision is currently enabled
    private static boolean nightVisionEnabled = false;
    
    @Override
    public void onInitializeClient() {
        // Register the keybinding
        // Default: N key, category: "Demir's Night Vision"
        nightVisionKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.nightvisiondemir.toggle",  // Translation key
                InputUtil.Type.KEYSYM,           // Input type
                GLFW.GLFW_KEY_N,                 // Default key: N
                "category.nightvisiondemir.main" // Category translation key
        ));
        
        // Register client tick event to check for key press
        ClientTickEvents.END_CLIENT_TICK.register(this::onClientTick);
    }
    
    /**
     * Called every client tick to check for key press and toggle effect
     */
    private void onClientTick(MinecraftClient client) {
        // Check if the key was pressed (wasPressed handles key repeat)
        while (nightVisionKey.wasPressed()) {
            toggleNightVision(client);
        }
    }
    
    /**
     * Toggle the Night Vision effect on/off
     */
    private void toggleNightVision(MinecraftClient client) {
        // Make sure we have a player
        if (client.player == null) {
            return;
        }
        
        // Toggle state
        nightVisionEnabled = !nightVisionEnabled;
        
        if (nightVisionEnabled) {
            // Apply Night Vision effect
            // Duration: 999999 ticks (about 13.8 hours) - effectively permanent
            // Amplifier: 0 (level 1)
            // Ambient: false
            // Show particles: false
            // Show icon: true
            StatusEffectInstance nightVision = new StatusEffectInstance(
                    StatusEffects.NIGHT_VISION,
                    999999,  // Duration in ticks
                    0,       // Amplifier (0 = level 1)
                    false,   // Ambient
                    false,   // Show particles
                    true     // Show icon
            );
            client.player.addStatusEffect(nightVision);
            
            // Send ON message to player (green color: §a)
            client.player.sendMessage(Text.literal("§aNight Vision: ON"), true);
        } else {
            // Remove Night Vision effect
            client.player.removeStatusEffect(StatusEffects.NIGHT_VISION);
            
            // Send OFF message to player (red color: §c)
            client.player.sendMessage(Text.literal("§cNight Vision: OFF"), true);
        }
    }
}
