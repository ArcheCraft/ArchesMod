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

package com.archecraft.games.minecraft.mods

import com.archecraft.games.minecraft.mods.data.DataGenerators
import com.archecraft.games.minecraft.mods.setup.Registration
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(ArchesMod.ID)
object ArchesMod {
    const val ID: String = "archesmod"
    
    val LOGGER: Logger = LogManager.getLogger()
    
    init {
        Registration.register()
        
        MOD_BUS.addListener(ArchesMod::clientSetup)
        MOD_BUS.addListener(ArchesMod::commonSetup)
        
        MOD_BUS.addListener(DataGenerators::gatherData)
    }
    
    private fun commonSetup(event: FMLCommonSetupEvent) {
    
    }
    
    private fun clientSetup(event: FMLClientSetupEvent) {
    
    }
    
    
    fun rl(name: String) = ResourceLocation(ID, name)
}