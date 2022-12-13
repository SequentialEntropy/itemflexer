package io.github.skytec711.itemflexer;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ItemFlexer.MOD_ID)
public class ItemFlexerForge extends ItemFlexer {
    public ItemFlexerForge() {
        super();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        ItemFlexer.registerCommands(event.getDispatcher(), event.getBuildContext());
    }
}
