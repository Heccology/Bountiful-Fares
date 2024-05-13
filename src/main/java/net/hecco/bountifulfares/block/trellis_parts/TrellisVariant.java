package net.hecco.bountifulfares.block.trellis_parts;

import net.hecco.bountifulfares.BountifulFares;

public class TrellisVariant {
    public final String MOD_ID;
    public final String TYPE_ID;
    public TrellisVariant(String modId, String id) {
        this.MOD_ID = modId;
        this.TYPE_ID = id;
        BountifulFares.TrellisIndex.add(this);
    }

    public String getName() {
        return this.TYPE_ID;
    }

    public String getTrellisName() {
        return this.TYPE_ID + "_trellis";
    }

    public String getId() {
        return this.MOD_ID;
    }

    public String getNameWithId() {
        return this.MOD_ID + "_" + this.TYPE_ID + "_trellis";
    }

}
