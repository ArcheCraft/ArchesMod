/*
 *  Copyright (C) 2020  Noah Dörr
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.archecraft.games.minecraft.mods.setup

import com.archecraft.games.minecraft.mods.ArchesMod
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.tags.*
import net.minecraft.util.ResourceLocation

object ModTags {
    object Blocks {
        val ORES_FERRITE = forge("ores/ferrite")
        val ORES_CUPRITE = forge("ores/cuprite")
        val STORAGE_BLOCKS_COPPER = forge("storage_blocks/copper")
        
        private fun forge(path: String): ITag.INamedTag<Block> = BlockTags.makeWrapperTag(ResourceLocation("forge", path).toString())
        
        private fun mod(path: String): ITag.INamedTag<Block> = BlockTags.makeWrapperTag(ResourceLocation(ArchesMod.ID, path).toString())
    }
    
    object Items {
        val ORES_FERRITE = forge("ores/ferrite")
        val ORES_CUPRITE = forge("ores/cuprite")
        val STORAGE_BLOCKS_COPPER = forge("storage_blocks/copper")
        
        val INGOTS_COPPER = forge("ingots/copper")
        
        private fun forge(path: String): ITag.INamedTag<Item> = ItemTags.makeWrapperTag(ResourceLocation("forge", path).toString())
        
        private fun mod(path: String): ITag.INamedTag<Item> = ItemTags.makeWrapperTag(ResourceLocation(ArchesMod.ID, path).toString())
    }
}