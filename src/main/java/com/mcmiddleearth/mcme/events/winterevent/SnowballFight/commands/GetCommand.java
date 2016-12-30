/**
 * * This file is part of winterEvent, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 Henry Slawniak <http://mcme.co/> and Created by SugarKoala. woo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.mcmiddleearth.mcme.events.winterevent.SnowballFight.commands;

import com.mcmiddleearth.mcme.events.winterevent.WinterCore;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class GetCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!WinterCore.active) {
            return true;
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to run this command.");
            return true;
        }
        Player player = (Player) sender;
        player.getInventory().addItem(new ItemStack(Material.SNOW_BALL, 1));
        player.getInventory().addItem(new ItemStack(Material.SNOW_BALL, 1));
        player.getInventory().addItem(new ItemStack(Material.SNOW_BALL, 1));
        player.getInventory().addItem(new ItemStack(Material.SNOW_BALL, 1));
        player.getInventory().addItem(new ItemStack(Material.SNOW_BALL, 1));
        player.getInventory().addItem(new ItemStack(Material.SNOW_BALL, 64));
        player.getInventory().addItem(new ItemStack(Material.SNOW_BALL, 64));
        player.getInventory().addItem(new ItemStack(Material.SNOW_BALL, 64));
        player.getInventory().addItem(new ItemStack(Material.SNOW_BALL, 64));
        player.sendMessage("Snowballs!");
        player.updateInventory();
        return true;
    }
}
