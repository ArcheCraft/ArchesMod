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

package com.archecraft.games.minecraft.mods.data.server.recipes

import net.minecraft.data.IFinishedRecipe
import net.minecraft.data.RecipeProvider
import net.minecraft.util.ResourceLocation
import net.minecraftforge.common.crafting.ConditionalRecipe
import net.minecraftforge.common.crafting.conditions.ICondition
import java.util.function.Consumer


fun RecipeProvider.conditional(consumer: Consumer<IFinishedRecipe>, id: ResourceLocation, build: ConditionalRecipeBuilder.() -> Unit) {
    val builder = ConditionalRecipe.builder()
    ConditionalRecipeBuilder(builder).build()
    builder.build(consumer, id)
}

fun RecipeProvider.withConditional(consumer: Consumer<IFinishedRecipe>, id: ResourceLocation, build: ConditionalRecipeBuilder.Conditions.(Consumer<IFinishedRecipe>) -> Unit) {
    val builder = ConditionalRecipe.builder()
    ConditionalRecipeBuilder.Conditions { builder.addCondition(it) }.build(builder.consumer())
    builder.build(consumer, id)
}

class ConditionalRecipeBuilder(private val builder: ConditionalRecipe.Builder) {
    fun addRecipe(recipe: IFinishedRecipe, condBuilder: Conditions.() -> Unit) {
        val list: MutableList<ICondition> = mutableListOf()
        
        val conditions = Conditions { list += it }
        conditions.condBuilder()
        
        list.forEach { builder.addCondition(it) }
        builder.addRecipe(recipe)
    }
    
    class Conditions(private val callback: (ICondition) -> Unit) {
        fun addCondition(condition: ICondition) {
            callback(condition)
        }
    }
}

fun ConditionalRecipe.Builder.consumer(): Consumer<IFinishedRecipe> = ConsumerWrapper<IFinishedRecipe>().also { addRecipe(it) }.Wrapper()

class ConsumerWrapper<T> : Consumer<Consumer<T>> {
    private var consumer: Consumer<T>? = null
    
    override fun accept(t: Consumer<T>) {
        consumer = t
    }
    
    inner class Wrapper : Consumer<T> {
        override fun accept(t: T) {
            consumer?.accept(t)
        }
    }
}