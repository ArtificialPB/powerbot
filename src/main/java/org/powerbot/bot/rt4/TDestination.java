package org.powerbot.bot.rt4;

import org.powerbot.script.TextPaintListener;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;

import java.awt.*;

import static org.powerbot.bot.DebugHelper.drawLine;

public class TDestination extends ClientAccessor implements TextPaintListener {

	public TDestination(final ClientContext ctx) {
		super(ctx);
	}

	public int draw(int idx, final Graphics render) {
		final Tile dest = ctx.movement.destination();
		drawLine(render, idx++, "Destination: " + (dest != null ? dest.toString() : "null"));
		return idx;
	}
}
