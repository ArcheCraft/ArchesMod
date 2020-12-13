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
import com.archecraft.games.minecraft.mods.recipes.crusherRecipe
import net.minecraft.data.*
import net.minecraft.util.ResourceLocation
import java.util.function.Consumer

class ModRecipeProvider(generatorIn: DataGenerator) : RecipeProvider(generatorIn) {
    override fun registerRecipes(consumer: Consumer<IFinishedRecipe>) {
        crusherRecipe(consumer, ResourceLocation(ArchesMod.ID, "test")) {  }
    }
}