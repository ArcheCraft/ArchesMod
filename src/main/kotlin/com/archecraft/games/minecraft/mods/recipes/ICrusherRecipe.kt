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

package com.archecraft.games.minecraft.mods.recipes

import com.archecraft.games.minecraft.mods.ArchesMod
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.*
import net.minecraft.util.RegistryKey
import net.minecraft.util.ResourceLocation
import net.minecraft.util.registry.Registry
import net.minecraftforge.items.wrapper.RecipeWrapper

interface ICrusherRecipe : IRecipe<RecipeWrapper> {
    override fun getType(): IRecipeType<*> = Registry.RECIPE_TYPE.getOrThrow(RegistryKey.getOrCreateKey(Registry.RECIPE_TYPE.registryKey, RECIPE_TYPE_ID))
    
    override fun canFit(width: Int, height: Int): Boolean = false
    
    fun getInput(): Ingredient
    
    fun getOutputs(): List<Pair<ItemStack, Double>>
    
    companion object {
        val RECIPE_TYPE_ID = ResourceLocation(ArchesMod.ID, "crusher")
    }
}