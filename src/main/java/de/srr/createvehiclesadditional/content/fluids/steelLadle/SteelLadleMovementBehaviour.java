package de.srr.createvehiclesadditional.content.fluids.steelLadle;

import com.simibubi.create.api.behaviour.movement.MovementBehaviour;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;

public class SteelLadleMovementBehaviour implements MovementBehaviour {

    @Override
    public void stopMoving(MovementContext context) {
        // Direkter Weg: falls die reale BlockEntity zu diesem Zeitpunkt bereits
        // im World-Grid existiert, sofort den Puls auslösen
        BlockEntity be = context.world.getBlockEntity(BlockPos.containing(context.position));
        if (be instanceof SteelLadleBlockEntity ladle) {
            ladle.triggerArrivalPulse();
            return;
        }

        // Fallback: falls die BlockEntity noch nicht existiert (Timing-Frage,
        // die ich ohne Contraption-Assembly-Source nicht zu 100% verifizieren kann),
        // Flag ins NBT schreiben, das beim Laden der echten BlockEntity ausgewertet wird
        if (context.blockEntityData != null)
            context.blockEntityData.putBoolean("PendingArrivalPulse", true);
    }
}
