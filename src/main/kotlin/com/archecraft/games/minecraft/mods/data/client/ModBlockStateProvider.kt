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

package com.archecraft.games.minecraft.mods.data.client

import com.archecraft.games.minecraft.mods.ArchesMod
import com.archecraft.games.minecraft.mods.setup.ModBlocks
import net.minecraft.data.DataGenerator
import net.minecraftforge.client.model.generators.BlockStateProvider
import net.minecraftforge.common.data.ExistingFileHelper

class ModBlockStateProvider(gen: DataGenerator, exFileHelper: ExistingFileHelper) : BlockStateProvider(gen, ArchesMod.ID, exFileHelper) {
    override fun registerStatesAndModels() {
        simpleBlock(ModBlocks.COPPER_BLOCK)
        simpleBlock(ModBlocks.CUPRITE_ORE)
        simpleBlock(ModBlocks.FERRITE_ORE)
    }
}