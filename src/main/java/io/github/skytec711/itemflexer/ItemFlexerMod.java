package io.github.skytec711.itemflexer;

import net.minecraftforge.fml.common.Mod;

@Mod(ItemFlexer.MOD_ID)
public class ItemFlexerMod {

    private final ItemFlexerForge mod;

    public ItemFlexerMod() {
        mod = new ItemFlexerForge();
    }
}
