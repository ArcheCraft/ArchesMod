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
import com.archecraft.games.minecraft.mods.setup.ModBlocks
import com.archecraft.games.minecraft.mods.setup.ModTags
import net.minecraft.data.BlockTagsProvider
import net.minecraft.data.DataGenerator
import net.minecraftforge.common.Tags
import net.minecraftforge.common.data.ExistingFileHelper

class ModBlockTagsProvider(gen: DataGenerator, existingFileHelper: ExistingFileHelper) : BlockTagsProvider(gen, ArchesMod.ID, existingFileHelper) {
    override fun registerTags() {
        getOrCreateBuilder(ModTags.Blocks.ORES_CUPRITE).add(ModBlocks.CUPRITE_ORE)
        getOrCreateBuilder(ModTags.Blocks.ORES_FERRITE).add(ModBlocks.FERRITE_ORE)
        getOrCreateBuilder(ModTags.Blocks.STORAGE_BLOCKS_COPPER).add(ModBlocks.COPPER_BLOCK)
        
        getOrCreateBuilder(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_CUPRITE).addTag(ModTags.Blocks.ORES_FERRITE)
        getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_COPPER)
    }
}