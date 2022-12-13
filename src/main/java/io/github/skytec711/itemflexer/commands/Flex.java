package io.github.skytec711.itemflexer.commands;

import java.util.List;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class Flex {

    public static ItemStack stack;
    
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(build());
    }

    public static LiteralArgumentBuilder<CommandSourceStack> build() {
        return Commands
        .literal("flex")
        .executes(context -> {
            // Get the current held item and pass it to the logic
            ServerPlayer entity = context.getSource().getPlayer();
            stack = entity.getMainHandItem();

            return flexItem(stack, entity, context.getSource());
        })
        ;
    }

    private static int flexItem(ItemStack stack, ServerPlayer player, CommandSourceStack source) {

        if (!stack.isEmpty()) {
            int itemCount = stack.getCount();

            String message = " is showing off their (" + itemCount + "x) ";

            Component playerComponent = player.getDisplayName();
            Component literalComponent = Component.literal(message);
            Component itemComponent = stack.getDisplayName();

            MutableComponent components = MutableComponent.create(ComponentContents.EMPTY);

            components
            .append(playerComponent)
            .append(literalComponent)
            .append(itemComponent);

            List<ServerPlayer> playerList = player.getServer().getPlayerList().getPlayers();

            for (ServerPlayer iteratePlayer : playerList) {
                iteratePlayer.sendSystemMessage(components, false);
            }            
        }
        return 0;
    }

}
