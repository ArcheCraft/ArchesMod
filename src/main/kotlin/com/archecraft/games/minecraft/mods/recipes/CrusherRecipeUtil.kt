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

import com.archecraft.games.minecraft.mods.setup.ModRecipeSerializers
import com.google.common.base.Preconditions
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import net.minecraft.data.IFinishedRecipe
import net.minecraft.data.RecipeProvider
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.IRecipeSerializer
import net.minecraft.item.crafting.Ingredient
import net.minecraft.util.ResourceLocation
import net.minecraft.util.registry.Registry
import java.util.function.Consumer

inline fun RecipeProvider.crusherRecipe(consumer: Consumer<IFinishedRecipe>, id: ResourceLocation, func: CrusherRecipeDataBuilder.() -> Unit) {
    val builder = CrusherRecipeDataBuilder()
    builder.func()
    builder.build(consumer, id)
}


class CrusherRecipeDataBuilder {
    private var input: Ingredient? = null
    
    private val output: MutableList<Pair<ItemStack, Double>> = mutableListOf()
    
    
    fun setInput(ingredient: Ingredient) {
        input = ingredient
    }
    
    fun addOutput(item: ItemStack, chance: Double) {
        output += item to chance
    }
    
    fun build(consumer: Consumer<IFinishedRecipe>, id: ResourceLocation) {
        Preconditions.checkState(output.size == 3, "Crusher recipe output count must be 3. If you have less, maybe fill with empty ItemStacks?")
        val recipe = CrusherRecipeData(id, input ?: throw IllegalStateException("Failed to serialize crusher recipe: Missing input"), output)
        consumer.accept(recipe)
    }
}

private class CrusherRecipeData(private val id: ResourceLocation, private val input: Ingredient, private val outputs: List<Pair<ItemStack, Double>>) : IFinishedRecipe {
    override fun serialize(json: JsonObject) {
        val input = input.serialize()
        json.add("input", input)
        
        val output = JsonArray()
        outputs.forEach { (i, d) ->
            val j = JsonObject()
            j.addProperty("item_stack", Registry.ITEM.getKey(i.item).toString())
            j.addProperty("chance", d)
            output.add(j)
        }
        json.add("output", output)
    }
    
    override fun getID(): ResourceLocation = id
    
    override fun getSerializer(): IRecipeSerializer<*> = ModRecipeSerializers.CRUSHER_RECIPE_SERIALIZER
    
    override fun getAdvancementJson(): JsonObject? = null
    
    override fun getAdvancementID(): ResourceLocation? = null
}
