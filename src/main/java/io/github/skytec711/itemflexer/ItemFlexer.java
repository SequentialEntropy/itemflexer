package io.github.skytec711.itemflexer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.brigadier.CommandDispatcher;

import io.github.skytec711.itemflexer.commands.Flex;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;

public abstract class ItemFlexer {
    public static final String MOD_ID = "itemflexer";
    public static final Logger LOGGER = LogManager.getLogger();
    public static ItemFlexer INSTANCE;

    public ItemFlexer() {
        LOGGER.info("{} loaded", MOD_ID);
        INSTANCE = this;
    }

    public static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext ctx) {
        Flex.register(dispatcher);
    }
}