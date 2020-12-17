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

package com.archecraft.games.minecraft.mods.data

import com.archecraft.games.minecraft.mods.data.client.ModBlockStateProvider
import com.archecraft.games.minecraft.mods.data.client.ModItemModelProvider
import com.archecraft.games.minecraft.mods.data.server.*
import com.archecraft.games.minecraft.mods.data.server.recipes.ModRecipeProvider
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent

object DataGenerators {
    fun gatherData(event: GatherDataEvent) {
        val gen = event.generator
        val efh = event.existingFileHelper
        
        if (event.includeClient()) {
            gen.addProvider(ModBlockStateProvider(gen, efh))
            gen.addProvider(ModItemModelProvider(gen, efh))
        }
        
        if (event.includeServer()) {
            val blockTags = ModBlockTagsProvider(gen, efh)
            gen.addProvider(blockTags)
            gen.addProvider(ModItemTagsProvider(gen, blockTags, efh))
            
            gen.addProvider(ModLootTableProvider(gen))
            gen.addProvider(ModRecipeProvider(gen))
        }
    }
}