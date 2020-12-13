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

package com.archecraft.games.minecraft.mods.data.server

import com.archecraft.games.minecraft.mods.ArchesMod
import com.archecraft.games.minecraft.mods.setup.ModItems
import com.archecraft.games.minecraft.mods.setup.ModTags
import net.minecraft.data.*
import net.minecraftforge.common.Tags
import net.minecraftforge.common.data.ExistingFileHelper

class ModItemTagsProvider(dataGenerator: DataGenerator, blockTagProvider: BlockTagsProvider, existingFileHelper: ExistingFileHelper) : ItemTagsProvider(dataGenerator, blockTagProvider, ArchesMod.ID, existingFileHelper) {
    override fun registerTags() {
        copy(ModTags.Blocks.STORAGE_BLOCKS_COPPER, ModTags.Items.STORAGE_BLOCKS_COPPER)
        copy(ModTags.Blocks.ORES_FERRITE, ModTags.Items.ORES_FERRITE)
        copy(ModTags.Blocks.ORES_CUPRITE, ModTags.Items.ORES_CUPRITE)
        
        copy(Tags.Blocks.ORES, Tags.Items.ORES)
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS)
        
        getOrCreateBuilder(ModTags.Items.INGOTS_COPPER).add(ModItems.COPPER_INGOT)
        
        getOrCreateBuilder(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_COPPER)
    }
}