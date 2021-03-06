package org.powerbot.bot.rt6;

import org.powerbot.script.*;
import org.powerbot.script.rt6.ClientContext;

import java.awt.*;

import static org.powerbot.bot.DebugHelper.*;

public class TDestination implements TextPaintListener {
	private final ClientContext ctx;

	public TDestination(final ClientContext ctx) {
		this.ctx = ctx;
	}

	public int draw(int idx, final Graphics render) {
		final Tile dest = ctx.movement.destination();
		drawLine(render, idx++, "Destination: " + (dest != null ? dest.toString() : "null"));
		return idx;
	}
}
