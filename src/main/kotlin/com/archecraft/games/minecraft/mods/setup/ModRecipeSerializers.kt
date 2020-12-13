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

import com.archecraft.games.minecraft.mods.recipes.CrusherRecipeSerializer
import com.archecraft.games.minecraft.mods.recipes.ICrusherRecipe
import net.minecraft.item.crafting.IRecipe
import net.minecraft.item.crafting.IRecipeType
import net.minecraft.util.ResourceLocation
import net.minecraft.util.registry.Registry

object ModRecipeSerializers {
    val CRUSHER_RECIPE_SERIALIZER = CrusherRecipeSerializer()
    val CRUSHER_TYPE = registerType<ICrusherRecipe>(ICrusherRecipe.RECIPE_TYPE_ID)
    val CRUSHER_SERIALIZER by Registration.RECIPE_SERIALIZERS.register("crusher") { CRUSHER_RECIPE_SERIALIZER }
    
    fun register() {}
    
    
    private fun <T : IRecipe<*>> registerType(recipeTypeId: ResourceLocation): IRecipeType<T> = Registry.register(Registry.RECIPE_TYPE, recipeTypeId, RecipeType())
    
    private class RecipeType<T : IRecipe<*>> : IRecipeType<T> {
        override fun toString(): String = Registry.RECIPE_TYPE.getKey(this).toString()
    }
}