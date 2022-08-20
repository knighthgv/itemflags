/*
Copyright 2022 KnightHat

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package me.knighthat.plugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player))
            return true;

        Component title = Component.text("Custom GUI");
        Inventory inventory = Bukkit.createInventory(player, 18, title);

        hideEnchants(inventory);
        hideAttributes(inventory);
        hidePotionEffects(inventory);
        hideUnbreakable(inventory);
        hideDestroys(inventory);
        hideDye(inventory);

        player.openInventory(inventory);

        return true;
    }

    private void hideEnchants(Inventory inventory) {
        ItemStack item1 = new ItemStack(Material.ELYTRA);
        item1.editMeta(meta -> {

            meta.displayName(Component.text("Trước").color(TextColor.fromHexString("#d13d32")));
            meta.addEnchant(Enchantment.DURABILITY, 3, true);
        });
        inventory.setItem(1, item1);

        ItemStack item2 = new ItemStack(Material.ELYTRA);
        item2.editMeta(meta -> {

            meta.displayName(Component.text("Sau").color(TextColor.fromHexString("#32d132")));
            meta.addEnchant(Enchantment.DURABILITY, 3, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        });
        inventory.setItem(10, item2);
    }

    private void hideAttributes(Inventory inventory) {
        ItemStack item1 = new ItemStack(Material.DIAMOND_SWORD);
        item1.editMeta(meta -> {

            meta.displayName(Component.text("Trước").color(TextColor.fromHexString("#d13d32")));
        });
        inventory.setItem(2, item1);

        ItemStack item2 = new ItemStack(Material.DIAMOND_SWORD);
        item2.editMeta(meta -> {

            meta.displayName(Component.text("Sau").color(TextColor.fromHexString("#32d132")));
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        });
        inventory.setItem(11, item2);
    }

    private void hideUnbreakable(Inventory inventory) {
        ItemStack item1 = new ItemStack(Material.WOODEN_HOE);
        item1.editMeta(meta -> {

            meta.displayName(Component.text("Trước").color(TextColor.fromHexString("#d13d32")));
            meta.setUnbreakable(true);
        });
        inventory.setItem(3, item1);

        ItemStack item2 = new ItemStack(Material.WOODEN_HOE);
        item2.editMeta(meta -> {

            meta.displayName(Component.text("Sau").color(TextColor.fromHexString("#32d132")));
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        });
        inventory.setItem(12, item2);
    }

    private void hideDestroys(Inventory inventory) {
        ItemStack item1 = new ItemStack(Material.GOLDEN_BOOTS);
        item1.editMeta(meta -> {
            meta.displayName(Component.text("Trước").color(TextColor.fromHexString("#d13d32")));
        });
        Damageable damageable1 = (Damageable) item1.getItemMeta();
        damageable1.setDamage(20);
        item1.setItemMeta(damageable1);
        inventory.setItem(5, item1);

        ItemStack item2 = new ItemStack(Material.GOLDEN_BOOTS);
        item2.editMeta(meta -> {

            meta.displayName(Component.text("Sau").color(TextColor.fromHexString("#32d132")));
            meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        });
        Damageable damageable2 = (Damageable) item1.getItemMeta();
        damageable2.setDamage(20);
        item1.setItemMeta(damageable2);
        inventory.setItem(14, item2);
    }

    private void hidePotionEffects(Inventory inventory) {
        PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, 5, 10);

        ItemStack item1 = new ItemStack(Material.POTION);
        PotionMeta meta1 = (PotionMeta) item1.getItemMeta();
        meta1.addCustomEffect(effect, true);
        item1.setItemMeta(meta1);
        inventory.setItem(6, item1);

        ItemStack item2 = new ItemStack(Material.POTION);
        PotionMeta meta2 = (PotionMeta) item2.getItemMeta();
        meta2.addCustomEffect(effect, true);
        meta2.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        item2.setItemMeta(meta2);
        inventory.setItem(15, item2);
    }

    private void hideDye(Inventory inventory) {
        Color color = Color.fromRGB(175, 50, 209);

        ItemStack item1 = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta1 = (LeatherArmorMeta) item1.getItemMeta();
        meta1.setColor(color);
        item1.setItemMeta(meta1);
        inventory.setItem(7, item1);

        ItemStack item2 = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta2 = (LeatherArmorMeta) item2.getItemMeta();
        meta2.setColor(color);
        meta2.addItemFlags(ItemFlag.HIDE_DYE);
        item2.setItemMeta(meta2);
        inventory.setItem(16, item2);
    }
}
