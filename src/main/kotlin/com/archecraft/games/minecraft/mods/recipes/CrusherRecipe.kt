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
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.IRecipeSerializer
import net.minecraft.item.crafting.Ingredient
import net.minecraft.util.NonNullList
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World
import net.minecraftforge.items.wrapper.RecipeWrapper

class CrusherRecipe(private val id: ResourceLocation, private val input: Ingredient, private val outputs: List<Pair<ItemStack, Double>>) : ICrusherRecipe {
    init {
        require(outputs.size == 3)
    }
    
    override fun getInput(): Ingredient = input
    
    override fun getOutputs(): List<Pair<ItemStack, Double>> = outputs
    
    override fun matches(inv: RecipeWrapper, worldIn: World): Boolean = input.test(inv.getStackInSlot(0))
    
    override fun getCraftingResult(inv: RecipeWrapper): ItemStack = ItemStack.EMPTY
    
    override fun getRecipeOutput(): ItemStack = ItemStack.EMPTY
    
    override fun isDynamic(): Boolean = true
    
    override fun getId(): ResourceLocation = id
    
    override fun getSerializer(): IRecipeSerializer<*> = ModRecipeSerializers.CRUSHER_SERIALIZER
    
    override fun getIngredients(): NonNullList<Ingredient> = NonNullList.from((null as Ingredient?), input)
}