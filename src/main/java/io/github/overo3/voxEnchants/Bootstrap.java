package io.github.overo3.voxEnchants;

import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.registry.data.EnchantmentRegistryEntry;
import io.papermc.paper.registry.event.RegistryEvents;
import io.papermc.paper.registry.keys.EnchantmentKeys;
import io.papermc.paper.registry.keys.tags.ItemTypeTagKeys;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.EquipmentSlotGroup;

// ! WARNING : UNSTABLE
public class Bootstrap implements PluginBootstrap {

    @SuppressWarnings("UnstableApiUsage")
    @Override
    public void bootstrap(BootstrapContext context) {
        context.getLifecycleManager().registerEventHandler(RegistryEvents.ENCHANTMENT.freeze().newHandler(event -> {
            event.registry().register(
                    EnchantmentKeys.create(Key.key("voxenchants:experience")),
                    b -> b.description(Component.text("Experience"))
                            .supportedItems(event.getOrCreateTag(ItemTypeTagKeys.PICKAXES))
                            .anvilCost(1)
                            .maxLevel(255)
                            .weight(1)
                            .minimumCost(EnchantmentRegistryEntry.EnchantmentCost.of(1,1))
                            .maximumCost(EnchantmentRegistryEntry.EnchantmentCost.of(3,1))
                            .activeSlots(EquipmentSlotGroup.MAINHAND)
                );
        }));
    }
}