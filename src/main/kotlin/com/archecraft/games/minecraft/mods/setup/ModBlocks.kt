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

import com.archecraft.games.minecraft.mods.blocks.CrusherBlock
import net.minecraft.block.*
import net.minecraft.block.material.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraftforge.common.ToolType
import kotlin.properties.ReadOnlyProperty

object ModBlocks {
    val FERRITE_ORE by register("ferrite_ore") { create(hardness = 3.0F, resistance = 10.0F, harvestLevel = 1, requiresTool = true)  }
    val CUPRITE_ORE by register("cuprite_ore") { create(hardness = 3.0F, resistance = 10.0F, harvestLevel = 1, requiresTool = true)  }
    
    val COPPER_BLOCK by register("copper_block") { create(Material.IRON, sound = SoundType.METAL, hardness = 2.0F, resistance = 10.0F) }
    
    val CRUSHER by register("crusher") { CrusherBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)) }
    
    fun register() {}
    
    private fun <T : Block> registerNoItem(name: String, block: () -> T) = Registration.BLOCKS.register(name, block)
    
    private fun <T : Block> register(name: String, block: () -> T): ReadOnlyProperty<Any?, T> {
        val ret = registerNoItem(name, block)
        val b by ret
        Registration.ITEMS.register(name) { BlockItem(b, Item.Properties().group(ModGroups.ARCHES_BLOCKS)) }
        return ret
    }
    
    
    private fun create(material: Material = Material.ROCK, hardness: Float = 1.0F, resistance: Float = hardness, harvestLevel: Int = 0, harvestTool: ToolType = ToolType.PICKAXE, sound: SoundType = SoundType.STONE, requiresTool: Boolean = false, add: AbstractBlock.Properties.() -> Unit = {}): Block =
        Block(AbstractBlock.Properties.create(material).hardnessAndResistance(hardness, resistance).harvestLevel(harvestLevel).harvestTool(harvestTool).sound(sound).apply { if (requiresTool) setRequiresTool() }.apply(add))
}