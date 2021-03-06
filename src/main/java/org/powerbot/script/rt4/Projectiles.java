package org.powerbot.script.rt4;

import org.powerbot.bot.rt4.*;
import org.powerbot.bot.rt4.client.Projectile;
import org.powerbot.bot.rt4.client.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Projectiles
 * {@link Projectiles} is a utility which provides access to the game's projectiles.
 * <p>
 * {@link org.powerbot.script.rt4.Projectile}s are game projectiles on the current plane which target an entity.
 */
public class Projectiles extends IdQuery<org.powerbot.script.rt4.Projectile> {
	public Projectiles(final ClientContext factory) {
		super(factory);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<org.powerbot.script.rt4.Projectile> get() {
		final List<org.powerbot.script.rt4.Projectile> items = new ArrayList<org.powerbot.script.rt4.Projectile>();

		final Client client = ctx.client();
		if (client == null) {
			return items;
		}

		for (final Projectile n : NodeQueue.get(client.getProjectiles(), Projectile.class)) {
			final org.powerbot.script.rt4.Projectile p = new org.powerbot.script.rt4.Projectile(ctx, n);
			items.add(p);
		}

		return items;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.powerbot.script.rt4.Projectile nil() {
		return new org.powerbot.script.rt4.Projectile(ctx, new Projectile(ctx.client().reflector, null));
	}
}
