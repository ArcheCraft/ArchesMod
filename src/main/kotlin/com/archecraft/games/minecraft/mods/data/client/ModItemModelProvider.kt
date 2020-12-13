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
import net.minecraft.data.DataGenerator
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.client.model.generators.ModelFile
import net.minecraftforge.common.data.ExistingFileHelper

class ModItemModelProvider(generator: DataGenerator, existingFileHelper: ExistingFileHelper) : ItemModelProvider(generator, ArchesMod.ID, existingFileHelper) {
    override fun registerModels() {
        withExistingParent("copper_block", modLoc("block/copper_block"))
        withExistingParent("ferrite_ore", modLoc("block/ferrite_ore"))
        
        val itemGenerated = getExistingFile(mcLoc("item/generated"))
    
        builder(itemGenerated, "copper_ingot")
    }
    
    private fun builder(itemGenerated: ModelFile, name: String) {
        getBuilder(name).parent(itemGenerated).texture("layer0", "item/$name")
    }
}