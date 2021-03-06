package org.powerbot.script.rt6;

import org.powerbot.bot.rt6.client.*;
import org.powerbot.script.Tile;
import org.powerbot.script.*;

import java.awt.*;

/**
 * GroundItem
 */
public class GroundItem extends GenericItem implements InteractiveEntity, Identifiable, Nameable, Stackable, Drawable, Actionable {
	public static final Color TARGET_COLOR = new Color(255, 255, 0, 75);
	private final TileMatrix tile;
	private final ItemNode item;

	public GroundItem(final ClientContext ctx, final Tile tile, final ItemNode item) {
		super(ctx);
		this.tile = tile.matrix(ctx);
		boundingModel = this.tile.boundingModel;
		this.item = item;
		bounds(-64, 64, -64, 0, -64, 64);
	}

	@Override
	public void bounds(final int x1, final int x2, final int y1, final int y2, final int z1, final int z2) {
		tile.bounds(x1, x2, y1, y2, z1, z2);
	}

	@Override
	public int id() {
		return item.getId();
	}

	@Override
	public int stackSize() {
		return item.getStackSize();
	}

	@Override
	public String[] actions() {
		return groundActions();
	}

	@Override
	public Tile tile() {
		return tile.tile();
	}

	@Override
	public Point nextPoint() {
		return tile.nextPoint();
	}

	public Point centerPoint() {
		return tile.centerPoint();
	}

	@Override
	public boolean contains(final Point point) {
		return tile.contains(point);
	}

	@Override
	public boolean valid() {
		return ctx.groundItems.select().contains(this);
	}

	@Override
	public int hashCode() {
		return item.hashCode();
	}

	@Override
	public boolean equals(final Object o) {
		return o instanceof GroundItem && tile.equals(((GroundItem) o).tile) && item.equals(((GroundItem) o).item);
	}

	@Override
	public String toString() {
		return GroundItem.class.getSimpleName() + "[id=" + id() + ",stacksize=" + stackSize() + ",name=" + name() + "]";
	}
}
