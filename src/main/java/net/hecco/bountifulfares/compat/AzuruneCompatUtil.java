//
//All Rights Reserved
//
//The code in this directory is owned by Yirmiri. All rights are reserved by the original author.
//Explicit permission has been granted to Hecco for usage of this code in this software.
//
//SEE THE LICENSE FOR MORE INFORMATION

package net.hecco.bountifulfares.compat;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class AzuruneCompatUtil {
    /**
     * The two following methods allows the ability to get classes from other mods without having to add them as a dependency in the development environment
     * If there is a failure to get this class it will automatically turn into an Item or Block
     * @param string - Gets the path for the class, for example: net.example.examplemod.ExampleItem
     */
    public static Item createCompatibilityItem(String string) {
        try {
            return (Item) Class.forName(string).getConstructor(Item.Settings.class).newInstance(new Item.Settings());
        } catch (Exception exception) {
            return new Item(new Item.Settings());
        }
    }

    public static Block createCompatibilityBlock(String string) {
        try {
            return (Block) Class.forName(string).getConstructor(AbstractBlock.Settings.class).newInstance(AbstractBlock.Settings.create());
        } catch (Exception exception) {
            return new Block(AbstractBlock.Settings.create());
        }
    }
}
