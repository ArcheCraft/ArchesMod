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

import com.google.gson.JsonObject
import net.minecraft.item.crafting.IRecipeSerializer
import net.minecraft.item.crafting.Ingredient
import net.minecraft.network.PacketBuffer
import net.minecraft.util.JSONUtils
import net.minecraft.util.ResourceLocation
import net.minecraftforge.common.crafting.CraftingHelper
import net.minecraftforge.registries.ForgeRegistryEntry

class CrusherRecipeSerializer : ForgeRegistryEntry<IRecipeSerializer<*>>(), IRecipeSerializer<ICrusherRecipe> {
    override fun read(recipeId: ResourceLocation, json: JsonObject): ICrusherRecipe {
        val output = JSONUtils.getJsonArray(json, "output").also { require(it.size() == 3) { "Invalid crusher recipe: Invalid count of inputs ${it.size()}" } }.map { CraftingHelper.getItemStack(JSONUtils.getJsonObject(it.asJsonObject, "item_stack"), true) to JSONUtils.getFloat(it.asJsonObject, "chance").toDouble() }
        val input = Ingredient.deserialize(JSONUtils.getJsonObject(json, "input"))
        return CrusherRecipe(recipeId, input, output)
    }
    
    override fun read(recipeId: ResourceLocation, buffer: PacketBuffer): ICrusherRecipe {
        val output = listOf(buffer.readItemStack() to buffer.readDouble(), buffer.readItemStack() to buffer.readDouble(), buffer.readItemStack() to buffer.readDouble())
        val input = Ingredient.read(buffer)
        return CrusherRecipe(recipeId, input, output)
    }
    
    override fun write(buffer: PacketBuffer, recipe: ICrusherRecipe) {
        recipe.ingredients[0].write(buffer)
        recipe.getOutputs().reversed().forEach { (i, d) -> buffer.writeDouble(d); buffer.writeItemStack(i, false) }
    }
}