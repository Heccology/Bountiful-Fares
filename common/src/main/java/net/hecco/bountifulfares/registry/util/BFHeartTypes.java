package net.hecco.bountifulfares.registry.util;

import net.minecraft.client.gui.Gui;

public class BFHeartTypes
{
    // This solely ensures the class remains loaded.
    static {
        Gui.HeartType.values();
    }

    // For reference, Vanilla values are:
    //                   CONTAINER
    //                   NORMAL
    //                   POISON
    //                   WITHERED
    //                   ABSORBING
    //                   FROZEN
    public static Gui.HeartType BF_RESTORATION;          // Restoration hearts

    /*
        To add a new heart overlay sprite, simply create a new 'public static' like the commented out code shows.
        GuiHeartsMixin has more info on this process - you'll reference your new variable there.
    */
}
