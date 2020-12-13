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

import com.archecraft.games.minecraft.mods.ArchesMod
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister
import thedarkcolour.kotlinforforge.forge.MOD_BUS

object Registration {
    val BLOCKS = KDeferredRegister(ForgeRegistries.BLOCKS, ArchesMod.ID)
    val ITEMS = KDeferredRegister(ForgeRegistries.ITEMS, ArchesMod.ID)
    val RECIPE_SERIALIZERS = KDeferredRegister(ForgeRegistries.RECIPE_SERIALIZERS, ArchesMod.ID)
    val TILE_ENTITIES = KDeferredRegister(ForgeRegistries.TILE_ENTITIES, ArchesMod.ID)
    val CONTAINERS = KDeferredRegister(ForgeRegistries.CONTAINERS, ArchesMod.ID)
    
    fun register() {
        BLOCKS.register(MOD_BUS)
        ITEMS.register(MOD_BUS)
        RECIPE_SERIALIZERS.register(MOD_BUS)
        TILE_ENTITIES.register(MOD_BUS)
        CONTAINERS.register(MOD_BUS)
    
        ModBlocks.register()
        ModItems.register()
        ModRecipeSerializers.register()
        ModTileEntities.register()
        ModContainers.register()
    }
}